package at.gv.ooe.ietservice.business;

import at.gv.ooe.ietservice.entity.ConfigurationItem;
import at.gv.ooe.ietservice.entity.Department;
import at.gv.ooe.ietservice.entity.DiaryEntry;
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
        System.err.println("*************** InitBean Version 2 ******************");
        Ticket ticket1 = new Ticket("Akku defekt", "10.05.2017", "12.05.2017", "", "Aktiv", "Huber", "Mizi", "Dringend", "");
        ticket1.getDiaryEntries().add(new DiaryEntry("10.05.2017 15:30", "Huber", "Akku muss ausgetauscht werden."));
        ticket1.getDiaryEntries().add(new DiaryEntry("10.05.2017 16:15", "Fischer", "Warten auf Anlieferung"));
        ticket1.getDiaryEntries().add(new DiaryEntry("10.05.2017 15:30", "Huber", "Akku doch nicht defekt. Geraet muss getauscht werden."));
        ticketFacade.save(ticket1);
        ticketFacade.save(new Ticket("xToner nicht geliefert", "08.05.2017", "11.05.2017", "", "Aktiv", "Mayr", "Gundula", "Nicht Dringend", ""));
        ticketFacade.save(new Ticket("Kein Strom", "04.05.2017", "05.05.2017", "", "Ausgesetzt", "Leeb", "Heribert", "Dringend", ""));
        ticketFacade.save(new Ticket("Computer zu langsam", "12.05.2017", "", "", "Aktiv", "Hofer", "Hugo", "Sehr dringend", ""));
        Department dept1 = new Department("Wohnbaufoerderung");
        Department dept2 = new Department("Naturschutz");
        Department dept3 = new Department("Wirtschaft");
        departmentFacade.save(dept1);
        departmentFacade.save(dept2);
        departmentFacade.save(dept3);

    }

}
