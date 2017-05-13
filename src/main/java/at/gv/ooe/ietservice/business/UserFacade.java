package at.gv.ooe.ietservice.business;

import at.gv.ooe.ietservice.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by alexandervollovec on 13.05.17.
 */
@Stateless
public class UserFacade {

    @PersistenceContext
    EntityManager em;

    public User save(User user) {
        return em.merge(user);
    }

    public List<User> findAll() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

}
