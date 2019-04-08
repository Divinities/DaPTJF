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

@Controller
public class AdminController {
    @Autowired
    private AdminService gservice;

    @RequestMapping("/admin")
    public Map<String, StoredCredential> displayUser() throws IOException, GeneralSecurityException {
        DataStore<StoredCredential> users = gservice.getUsers();

        Map<String, StoredCredential> usersMap = new HashMap<>();

        Set<String> allkeys = users.keySet();

        for (String akey : allkeys) {

            StoredCredential value = users.get(akey);
            usersMap.put(akey, value);
        }
        return usersMap;
    }
}
