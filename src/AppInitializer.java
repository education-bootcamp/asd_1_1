import entity.Address;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Arrays;

public class AppInitializer {
    public static void main(String[] args) {
        Address address1 = new Address("SriLanka", "Colombo", 15000);
        Address address2 = new Address("USA", "South Carolina", 45800);
        Address address3 = new Address("SriLanka", "Panadura", 12500);
        Student student1 = new Student();
       /* ArrayList list= new ArrayList<>();
        list.add(address1);
        list.add(address2);
        list.add(address3);*/
        student1.setName("Nimal");
        student1.setAddressList(Arrays.asList(address1, address2, address3));
        saveStudent(student1);
    }

    private static void saveStudent(Student sanath) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            long savedId = (long) session.save(sanath);
            transaction.commit();
            System.out.println("saved Student Primary Key : " + savedId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
