package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Entity(name = "student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long studentId;
    @Column(name = "student_name", length = 50, nullable = false)
    private String name;

    @ElementCollection
    @JoinTable(
            name = "address_table",
            joinColumns = @JoinColumn(name = "student_id",
                    referencedColumnName = "id")
    )
    private Collection<Address> addressList = new ArrayList<>();/*HashSet<>(); => we can't use indexing*/

    public Student(long studentId, String name, Collection<Address> addressList) {
        this.studentId = studentId;
        this.name = name;
        this.addressList = addressList;
    }

    public Student() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Collection<Address> addressList) {
        this.addressList = addressList;
    }
}
