package at.gv.ooe.ietservice.entity;

import javax.persistence.*;
import at.gv.ooe.ietservice.entity.DiaryEntry;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

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
    private Long id;

    private String description;
    private String startDate;
    private String answerDate;
    private String closedDate;
    private String status;
    private String specialistName;
    private String problemUserName;
    private String priority;
    private String solution;

    @ManyToOne(cascade = CascadeType.ALL)
    private
    User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private
    ConfigurationItem ci;

    public Ticket() {
    }

    public Ticket(String description, String startDate, String answerDate, String closedDate, String status, String specialistName, String problemUserName, String priority, String solution, User user, ConfigurationItem ci) {
        this.description = description;
        this.startDate = startDate;
        this.answerDate = answerDate;
        this.closedDate = closedDate;
        this.status = status;
        this.specialistName = specialistName;
        this.problemUserName = problemUserName;
        this.priority = priority;
        this.solution = solution;
        this.user = user;
        this.setCi(ci);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + getId() +
                ", description='" + getDescription() + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(String answerDate) {
        this.answerDate = answerDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }

    public String getProblemUserName() {
        return problemUserName;
    }

    public void setProblemUserName(String problemUserName) {
        this.problemUserName = problemUserName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public ConfigurationItem getCi() {
        return ci;
    }

    public void setCi(ConfigurationItem ci) {
        this.ci = ci;
    }
}

