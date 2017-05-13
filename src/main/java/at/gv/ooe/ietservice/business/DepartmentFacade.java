package at.gv.ooe.ietservice.business;

import at.gv.ooe.ietservice.entity.Department;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by alexandervollovec on 13.05.17.
 */
public class DepartmentFacade {

    @PersistenceContext
    EntityManager em;

    public Department save(Department dept) {
        return em.merge(dept);
    }

    public List<Department> findAll() {
        return em.createNamedQuery("Department.findAll", Department.class).getResultList();
    }

}
