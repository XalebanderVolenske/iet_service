package at.gv.ooe.ietservice.rest;

import at.gv.ooe.ietservice.business.TicketFacade;
import at.gv.ooe.ietservice.entity.Ticket;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by alexandervollovec on 06.05.17.
 */
@Path("")
@Stateless
public class TicketEndpoint {

    @Inject
    TicketFacade ticketFacade;

    @GET
    public JsonObject hello() {
        return Json.createObjectBuilder().add("greeting","hello").build();
    }

    @GET
    @Path("tickets")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getTickets() {
        return ticketFacade.findAll();
    }
}
