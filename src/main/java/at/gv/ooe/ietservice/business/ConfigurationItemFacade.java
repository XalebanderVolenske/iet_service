package at.gv.ooe.ietservice.business;

import at.gv.ooe.ietservice.entity.ConfigurationItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by alexandervollovec on 13.05.17.
 */
public class ConfigurationItemFacade {


    @PersistenceContext
    EntityManager em;

    public ConfigurationItem save(ConfigurationItem ci) {
        return em.merge(ci);
    }

    public List<ConfigurationItem> findAll() {
        return em.createNamedQuery("ConfigurationItem.findAllByDept", ConfigurationItem.class).getResultList();
    }

}
