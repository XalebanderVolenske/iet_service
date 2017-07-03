package at.gv.ooe.ietservice.entity;

import javax.persistence.*;

/**
 * Created by alexandervollovec on 13.05.17.
 */

@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select u from User u")
})

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String persno;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private
    Department department;

    public User() {
    }

    public User(String persno, String name, Department department) {
        this.setPersno(persno);
        this.setName(name);
        this.setDepartment(department);
    }

    public String getPersno() {
        return persno;
    }

    public void setPersno(String persno) {
        this.persno = persno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", persno='" + persno + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
