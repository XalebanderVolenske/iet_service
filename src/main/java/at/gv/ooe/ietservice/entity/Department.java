package at.gv.ooe.ietservice.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandervollovec on 13.05.17.
 */

@NamedQueries({
        @NamedQuery(name = "Department.findAll", query = "select dept from Department dept")
})

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String departmentName;

    public Department() {
    }

    public Department(String departmentName)
    {
        this.setDepartmentName(departmentName);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
