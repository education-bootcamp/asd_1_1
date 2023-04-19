import entity.Address;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {
        Address address1 = new Address( "SriLanka","Colombo",15000);
        Student student1 = new Student(1,"Sanath",address1);
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
