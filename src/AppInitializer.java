import entity.Student;
import org.hibernate.Session;

public class AppInitializer {
    public static void main(String[] args) {
        Student sanath = new Student(1,"Sanath");
        saveStudent(sanath);
    }

    private static void saveStudent(Student sanath) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            long savedId = (long) session.save(sanath);
            System.out.println("saved Student Primary Key : "+savedId);
        }
    }

}
