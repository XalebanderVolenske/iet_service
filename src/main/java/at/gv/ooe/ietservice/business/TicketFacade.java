package at.gv.ooe.ietservice.business;

import at.gv.ooe.ietservice.entity.Ticket;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by alexandervollovec on 07/05/2017.
 */
@Stateless
public class TicketFacade {

    @PersistenceContext
    EntityManager em;

    public Ticket save(Ticket ticket) {
        return em.merge(ticket);
    }

    public List<Ticket> findAll() {
        return em.createNamedQuery("Ticket.findAll", Ticket.class).getResultList();
    }

}
