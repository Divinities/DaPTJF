package fr.hoc.dap.serveur.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.gmail.GmailScopes;

import fr.hoc.dap.serveur.Config;

/**
 * Classe parente de tous le serviceGoogle. Permet de gèrer les droits.
 * @author house
 */

@Service
public class GoogleService {

    @Autowired
    public Config maConf;

    /** . */
    //protected static final String bob = "Google Calendar API Java Quickstart";
    /** . */

    protected static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    private static List<String> scopes;

    protected Credential getCredentials(final String userKey) throws IOException, GeneralSecurityException {

        GoogleAuthorizationCodeFlow flow = getFlow();

        //        LocalServerReceiver receiver = new LocalServerReceiver.Builder()
        //                .setPort(PORT).build();
        //        return new AuthorizationCodeInstalledApp(flow, receiver)
        //                .authorize("user");

        return flow.loadCredential(userKey);
    }

    public void setConf(Config config) {
        maConf = config;
    }

    /**
     * Load a Google flow.
     * @return jfhgdkjhg
     * @throws GeneralSecurityException sdffdsf
     *
     *
     * @throws IOException vfdsq
     */
    public GoogleAuthorizationCodeFlow getFlow() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        scopes = new ArrayList<String>();
        scopes.add(CalendarScopes.CALENDAR_READONLY);
        scopes.add(GmailScopes.GMAIL_READONLY);
        scopes.add(GmailScopes.GMAIL_LABELS);
        // Load client secrets.
        File in = new java.io.File(maConf.getClientSecretFile());
        Reader targetReader = new FileReader(in);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, targetReader);
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY,
                clientSecrets, scopes)
                        .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(maConf.getCredentialFolder())))
                        .setAccessType("offline").build();

        return flow;
    }

}
