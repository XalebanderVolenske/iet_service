package at.gv.ooe.ietservice.business;

import at.gv.ooe.ietservice.entity.*;

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
    @Inject
    UserFacade userFacade;
    @Inject
    DiaryEntryFacade diaryEntryFacade;
    @Inject
    DepartmentFacade departmentFacade;
    @Inject
    ConfigurationItemFacade configurationItemFacade;

    @PostConstruct
    private void init() {
        //System.err.println("*************** InitBean Version 2 ******************");
        Department dept1 = new Department("Wohnbaufoerderung");
        Department dept2 = new Department("Naturschutz");
        Department dept3 = new Department("Wirtschaft");
        departmentFacade.save(dept1);
        departmentFacade.save(dept2);
        departmentFacade.save(dept3);
        User user1 = new User("P123542", "Alex", dept1);
        User user2 = new User("P179234", "Maria", dept2);
        User user3 = new User("P093483", "Django", dept3);
        userFacade.save(user1);
        userFacade.save(user2);
        userFacade.save(user3);
        ConfigurationItem ci1 = new ConfigurationItem("AH12345", "HP Deskjet 800", "Leherbauer", "Haribogasse 7 4020 Linz", "4B122", "Drucken", "Drucker", "in Betrieb", dept1);
        ConfigurationItem ci2 = new ConfigurationItem("AH93482", "HP Officejet 200", "Kaiser", "Gansstraße 34 4020 Linz", "5C622", "Drucken", "Drucker", "in Betrieb", dept1);
        ConfigurationItem ci3 = new ConfigurationItem("AH24354", "HP Compaq ", "Pfister", "Am Teichweg 1 4020 Linz", "9A246", "Drucken", "Arbeitsplatz", "in Betrieb", dept1);
        ConfigurationItem ci4 = new ConfigurationItem("AH12038", "HP Deskjet 800", "Hofigner", "Bahnhofsplatz 12 4040 Linz", "7A754", "Drucken", "Arbeitsplatz", "in Betrieb", dept1);
        ConfigurationItem ci5 = new ConfigurationItem("AH85760", "HP Deskjet 800", "Mayrleeb", "Untergering 9 4060 Leonding", "123", "Drucken", "PIM", "in Betrieb", dept2);
        ConfigurationItem ci6 = new ConfigurationItem("AH03475", "HP Deskjet 800", "Birnbaum", "Handelsplatz 67 4050 Traun", "5B400", "Drucken", "PIM", "in Betrieb", dept2);
        configurationItemFacade.save(ci1);
        configurationItemFacade.save(ci2);
        configurationItemFacade.save(ci3);
        configurationItemFacade.save(ci4);
        configurationItemFacade.save(ci5);
        configurationItemFacade.save(ci6);
        Ticket ticket1 = new Ticket("Akku defekt", "10.05.2017", "12.05.2017", "", "Aktiv", "Huber", "Mizi", "Dringend", "", user1, ci1);
        diaryEntryFacade.save(new DiaryEntry("10.05.2017 15:30", "Huber", "Akku muss ausgetauscht werden.", ticket1));
        diaryEntryFacade.save(new DiaryEntry("10.05.2017 16:15", "Fischer", "Warten auf Anlieferung", ticket1));
        diaryEntryFacade.save(new DiaryEntry("10.05.2017 15:30", "Huber", "Akku doch nicht defekt. Geraet muss getauscht werden.",ticket1));
        ticketFacade.save(ticket1);
        ticketFacade.save(new Ticket("Toner nicht geliefert", "08.05.2017", "11.05.2017", "", "Aktiv", "Mayr", "Gundula", "Nicht Dringend", "", user1, ci2));
        ticketFacade.save(new Ticket("Kein Strom", "04.05.2017", "05.05.2017", "", "Ausgesetzt", "Leeb", "Heribert", "Dringend", "", user1, ci3));
        ticketFacade.save(new Ticket("Computer zu langsam", "12.05.2017", "", "", "Aktiv", "Hofer", "Hugo", "Sehr dringend", "", user2, ci4));
    }

}
