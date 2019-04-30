/**
 * 
 */
package fr.hoc.dap.serveur.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.hoc.dap.serveur.service.CalendarService;

/**
 * //TODO TJF by Djer |JavaDoc| Il manque la description (de la classe) : première ligne de la JavaDoc
 * @author house
 */
@RestController
public class CalendarControl {

    //TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
    @Autowired
    private CalendarService gcService = new CalendarService();

    //TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
    @RequestMapping("/event/nextevent")
    public String getService(@RequestParam(value = "nb", defaultValue = "1") final Integer nb,
            @RequestParam("userKey") final String userKey) throws GeneralSecurityException, IOException {

        return gcService.nextEvents(nb, userKey);
    }
}
