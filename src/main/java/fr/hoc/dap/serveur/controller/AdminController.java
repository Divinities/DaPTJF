package fr.hoc.dap.serveur.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.util.store.DataStore;

import fr.hoc.dap.serveur.service.AdminService;

//TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
@Controller
public class AdminController {
    //TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
    @Autowired
    private AdminService gservice;

    //TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
    @RequestMapping("/admin")
    public Map<String, StoredCredential> displayUser() throws IOException, GeneralSecurityException {
        DataStore<StoredCredential> users = gservice.getUsers();

        Map<String, StoredCredential> usersMap = new HashMap<>();

        Set<String> allkeys = users.keySet();

        for (String akey : allkeys) {

            StoredCredential value = users.get(akey);
            usersMap.put(akey, value);
        }

        //TODO TJF by Djer |MVC| Le contenue de ton "usersMap" sevrait être ajouté dans le model ! 
        //TODO TJF by Djer |MVC| Les "xontrolelr" Spring doivent retourner le nom d'une VUE ! Spring va "automatiquement" transfére le mode àcette Vue
        return usersMap;
    }
}
