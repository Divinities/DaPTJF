package fr.hoc.dap.serveur.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.util.store.DataStore;

@Service
public class AdminService extends GoogleService {

    public DataStore<StoredCredential> getUsers() throws GeneralSecurityException, IOException {

        GoogleAuthorizationCodeFlow flow = getFlow();
        DataStore<StoredCredential> data = flow.getCredentialDataStore();

        return data;

    }
}