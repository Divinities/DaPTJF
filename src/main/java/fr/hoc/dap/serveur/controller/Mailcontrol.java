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

import fr.hoc.dap.serveur.service.GmailService;

/**
 * //TODO TJF by Djer |JavaDoc| Il manque la description (de la classe) : première ligne de la JavaDoc
 * @author house
 */
@RestController
public class Mailcontrol {

    //TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
  //TODO TJF by Djer |IOC| Ne fait PAS de "New" lorsqu'il ya une injection. Tu créé une première instance "pour rien" (Spring va la remplacer).
    @Autowired
    private GmailService gmService = new GmailService();

    //TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
  //TODO TJF by Djer |POO| les noms de méthdoe cientiennent en général un verbe ("retrieveNbUnreadEmail" serait mieux)
    @RequestMapping("/mail/nbunread")
    public Integer nombre(@RequestParam("userKey") final String userKey) throws IOException, GeneralSecurityException {

        return gmService.displayNbUnreadMessage(userKey);
    }
}
