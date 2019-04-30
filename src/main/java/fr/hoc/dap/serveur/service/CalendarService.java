package fr.hoc.dap.serveur.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

/** 
 * //TODO TJF by Djer |JavaDoc| Ce commentaire n'est pas utile. JavaDoc va automatiquement extraire les information d'héritage. "Contain all Google calendar services" serait mieux
 * la class Clendrier hérite de la class GoogleService . */
@Service
public class CalendarService extends GoogleService {
    //TODO TJF by Djer |Spring| Depuis que c'est un "@Service" Spring fait de cette classe un Singleton automatiquement
    private static CalendarService INSTANCE = null;

    //    private CalendarService() {
    //    }
    //    public synchronized static CalendarService getInstance() {
    //        if (INSTANCE == null) {
    //            INSTANCE = new CalendarService();
    //        }
    //        System.out.println("getInstance");
    //        return INSTANCE;

    /** Maximum events to display.
     * @param userKey */
    //TODO TJF by Djer |POO| "buildService" serait mieux.
    //TODO TJF by Djer |Audit Code| Prend en comtpe les remarques de ton outils d'audit de code !
    public Calendar getService(String userKey) throws GeneralSecurityException, IOException {
        // Build a new authorized API client service.
        final NetHttpTransport httptransport = GoogleNetHttpTransport.newTrustedTransport();
        Calendar service = new Calendar.Builder(httptransport, JSON_FACTORY, getCredentials(userKey))
                .setApplicationName(maConf.getApplicationName()).build();
        return service;
    }

    //     * les paramètres d'entrée de programme.
    //     * @param userKey
    //     * @return
    //     * @throws IOException Google IO
    //     * @throws GeneralSecurityException Google security
    //     *
    //TODO TJF by Djer |Audit Code| Prend en comtpe les remarques de ton outils d'audit de code !
    //TODO TJF by Djer |POO| Le nom de méthdoe cient en générla un verbe.
    public String nextEvents(final Integer nb, String userKey) throws IOException, GeneralSecurityException {
        //TODO TJF by Djer |Log4J| Une petite log ? 
        Calendar service = getService(userKey);
        String results = "";
        // List the next 10 events from the primary calendar.
        DateTime now = new DateTime(System.currentTimeMillis());

        Events events = service.events().list("primary").setMaxResults(nb).setTimeMin(now).setOrderBy("startTime")
                .setSingleEvents(true).execute();
        List<Event> items = events.getItems();
        if (items.isEmpty()) {
            results = "No upcoming events";
            //System.out.println("No upcoming events found.");
        } else {
            //System.out.println("Upcoming events");
            for (Event event : items) {
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                results += event.getSummary() + " " + start;
                //System.out.printf("%s (%s)\n", event.getSummary(), start);
            }

        }

        return results;
    }
}
