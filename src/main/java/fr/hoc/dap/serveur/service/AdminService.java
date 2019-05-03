package fr.hoc.dap.serveur.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.util.store.DataStore;

//TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
@Service
public class AdminService extends GoogleService {

  //TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
    public DataStore<StoredCredential> getUsers() throws GeneralSecurityException, IOException {
        //TODO TJF by Djer |Log4J| Une petite log ?
        GoogleAuthorizationCodeFlow flow = getFlow();
        DataStore<StoredCredential> data = flow.getCredentialDataStore();

        return data;
    }
}