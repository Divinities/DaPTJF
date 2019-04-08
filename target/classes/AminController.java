package fr.hoc.dap.serveur.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.util.store.DataStore;
@controller
public class AminController throws GeneralSecurityException, IOException {

  public DataStore<StoredCredential> getCredentialMap() throws GeneralSecurityException, IOException { 

      googleautrisationcodeflow flow= get.flow();
      DataStore<StoredCredential> datas = flow.getCredentialDataStore();
      
      return data;
  
}
}