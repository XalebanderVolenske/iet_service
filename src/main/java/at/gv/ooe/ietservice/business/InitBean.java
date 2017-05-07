package at.gv.ooe.ietservice.business;

import at.gv.ooe.ietservice.entity.Ticket;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Created by alexandervollovec on 07/05/2017.
 */
@Startup
@Singleton
public class InitBean {

    @Inject
    TicketFacade ticketFacade;

    @PostConstruct
    private void init() {
        ticketFacade.save(new Ticket("Drucker kaputt"));
        ticketFacade.save(new Ticket("Monitor zu klein"));
        ticketFacade.save(new Ticket("Strom weg"));
        ticketFacade.save(new Ticket("Sessel fehlt"));
    }

}
