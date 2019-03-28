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
 * @author house
 *
 */

@RestController
public class Mailcontrol {

    @Autowired
    private GmailService gmService = new GmailService();

    @RequestMapping("/mail/nbunread")
    public Integer nombre(@RequestParam("userKey") final String userKey) throws IOException, GeneralSecurityException {

        return gmService.displayNbUnreadMessage(userKey);
    }

}
