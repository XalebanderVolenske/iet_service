package at.gv.ooe.ietservice.entity;

import javax.persistence.*;

/**
 * Created by alexandervollovec on 07/05/2017.
 */
@NamedQueries({
        @NamedQuery(name = "Ticket.findAll", query = "select t from Ticket t")
})
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String description;

    public Ticket() {
    }

    public Ticket(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

