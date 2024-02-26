package Test.demo.Student.StudentEntity;


import javax.persistence.*;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer S_id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private int marks;

    public Integer getId() {
        return S_id;
    }

    public void setId(Integer id) {
        this.S_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }


    public void setMarks(int marks) {
        this.marks = marks;

    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + S_id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", status=" + status +
                ", marks=" + marks +
                '}';
    }

    public StudentEntity(Integer s_id, String name, Address address, Status status, int marks) {
        S_id = s_id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.marks = marks;
    }
}
