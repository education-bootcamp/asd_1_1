import entity.Laptop;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public class AppInitializer {
    public static void main(String[] args) {
        Laptop laptop = new Laptop(1,"Lenovo");
        Student student1 = new Student(1,"Kamal",laptop);
        saveStudent(student1);
        //findStudent(1);
    }

    private static void findStudent(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student selectedStudent = session.find(Student.class, id);
            System.out.println(selectedStudent);
        }

    }

    private static void saveStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            long savedId = (long) session.save(student);
            transaction.commit();
            System.out.println("saved Student Primary Key : " + savedId);
        }
    }

}
