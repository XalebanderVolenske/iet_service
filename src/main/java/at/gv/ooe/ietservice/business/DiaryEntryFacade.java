package at.gv.ooe.ietservice.business;

import at.gv.ooe.ietservice.entity.DiaryEntry;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by alexandervollovec on 13.05.17.
 */
@Stateless
public class DiaryEntryFacade {

    @PersistenceContext
    EntityManager em;

    public DiaryEntry save(DiaryEntry entry) {
        return em.merge(entry);
    }

    public List<DiaryEntry> findAllForTicket() {
        return em.createNamedQuery("DiaryEntry.findAllForTicket", DiaryEntry.class).getResultList();
    }
}
