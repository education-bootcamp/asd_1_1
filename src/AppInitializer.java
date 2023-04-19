import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {
        Student sanath = new Student(1,"Sanath");
        saveStudent(sanath);
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
