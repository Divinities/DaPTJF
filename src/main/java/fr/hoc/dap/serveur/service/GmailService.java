package fr.hoc.dap.serveur.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;

/** la class GmailService regroupe les méthode pour acceder au nombre de mails. */
@Service
public class GmailService extends GoogleService {
    //       private static GmailService INSTANCE = null;
    //    private GmailService() {
    //    }
    //
    //    public synchronized static GmailService getInstance() {
    //        if (INSTANCE == null) {
    //            INSTANCE = new GmailService();
    //        }
    //        return INSTANCE;
    //    }
    public Gmail getService(String userKey) throws IOException, GeneralSecurityException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        Gmail service = new Gmail.Builder(httpTransport, JSON_FACTORY, getCredentials(userKey))
                .setApplicationName(maConf.getApplicationName()).build();
        String userId = "me";
        String query = "is:unread in:inbox";

        List<Message> messages = listMessagesMatchingQuery(service, userId, query);

        return service;
    }

    /**
     * la méthode diplayNbUnreadMessage affiche le nombre de mails non lu.
     * @param userKey
     * @return int.
     * @throws IOException Google IO
     * @throws GeneralSecurityException Google security
     */
    public int displayNbUnreadMessage(String userKey) throws IOException, GeneralSecurityException {
        Gmail service = getService(userKey);
        List<Message> messages = listMessagesMatchingQuery(service, "me", "is:unread in:inbox");
        //System.out.println("Nb Email : " + messages.size());
        return messages.size();

    }

    /**
     * Liste les messages de l'utilisateur.
     * @param service L'acces aux Service GMail
     * @param userId "me".
     * @param query query.
     * @return  An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private List<Message> listMessagesMatchingQuery(final Gmail service, final String userId, final String query)
            throws IOException {
        ListMessagesResponse response = service.users().messages().list(userId).setQ(query).execute();

        List<Message> messages = new ArrayList<Message>();
        while (response.getMessages() != null) {

            messages.addAll(response.getMessages());
            if (response.getNextPageToken() != null) {

                String pageToken = response.getNextPageToken();
                response = service.users().messages().list(userId).setQ(query).setPageToken(pageToken).execute();
            } else {
                break;
            }
        }

        // System.out.println(messages.size());

        for (Message message : messages) {
            //System.out.println(message.toPrettyString());

            message.getId();

        }

        return messages;
    }

}
