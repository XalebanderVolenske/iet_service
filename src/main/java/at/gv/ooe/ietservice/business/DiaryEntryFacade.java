package at.gv.ooe.ietservice.business;

import at.gv.ooe.ietservice.entity.DiaryEntry;
import at.gv.ooe.ietservice.entity.Ticket;

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

    public List<DiaryEntry> getDiaryEntriesForTicket(Long ticketID) {
        return em.createNamedQuery("DiaryEntry.getDiaryEntriesForTicket", DiaryEntry.class).setParameter("ticketID", ticketID).getResultList();
    }
}
