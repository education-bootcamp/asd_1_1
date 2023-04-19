import entity.Address;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {
        Address residentialAddress = new Address( "SriLanka","Colombo",15000);
        Address permanentAddress = new Address( "SriLanka","Kahatagasdigiliya",12500);
        Student student1 = new Student(1,
                "Sanath",residentialAddress,permanentAddress);
        saveStudent(student1);
    }

    private static void saveStudent(Student sanath) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            long savedId = (long) session.save(sanath);
            transaction.commit();
            System.out.println("saved Student Primary Key : "+savedId);
        }
    }

}
