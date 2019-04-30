package fr.hoc.dap.serveur;

/** class config.*/

public class Config {

    //TODO TJF by Djer |JavaDoc| ajouter "xxxx par defaut" pour clarifié l'utilité de cette constante.
    /** dossier credential.*/
  //TODO TJF by Djer |POO| Dépose tes fichei "d'application" dans un sous dossier du "userHome" ("dao" oar exemple).
  //TODO TJF by Djer |POO| Evite d'utilsier le "/" (ne fonctionne aps sous Linux/mac). Utilise la property "file.separator" à la place
    private static final String CREDENTIAL_FILE_PATH = System.getProperty("user.home") + "/credentials.json";
    /** dossier Tokens.*/
  //TODO TJF by Djer |POO| Il te manque le séparateur de fichier (ou dossier) avant le "token"
    private static final String TOKENS_DIRECTORY_PATH = System.getProperty("user.home") + "tokens";
    /** dossier Application name.*/
    private static final String APPLICATION_NAME = "HoCDaP";
    /** URL de redirection autorisé. */
    private static final String AUTH2_CALLBACK_URL = "/oAuth2Callback";

    //TODO TJF by Djer |JavaDoc| Les commentaire sur tes constante (sans le "par defaut") irait bien ici
    /** app.*/
    private String applicationName;
    /** app.*/
    private String credentialFolder;
    /** app.*/
    private String clientSecretFile;
    /**app.*/
    private String auth2CallBackUrl;

  //TODO TJF by Djer |JavaDoc| "Constructeur avec pré-remplissage avec les valeurs par défaut" serait mieux.
    /** créer le constructeur.*/
    public Config() {
        applicationName = APPLICATION_NAME;
        credentialFolder = TOKENS_DIRECTORY_PATH;
        clientSecretFile = CREDENTIAL_FILE_PATH;
        auth2CallBackUrl = AUTH2_CALLBACK_URL;
    }

    /**
//     * //TODO TJF by Djer |JavaDoc| Cette JavaDoc semble êtyre un "mauvais copier/coller"
     * Execute code after Spring start the app.
     * @return a credentialFolder
     */
    public String getCredentialFolder() {
        return credentialFolder;
    }

    /**
     * Execute code after Spring start the app.
     * @param credentialFolder .
     */
  //TODO TJF by Djer |Audit Code| Prend en compte la remarque de ton outil d'audit de qualité du code ("masque un attribut")
    public void setCredentialFolder(final String credentialFolder) {
        this.credentialFolder = credentialFolder;
    }

    /**
     * mjolihou.
     * @return clent
     */
    public String getClientSecretFile() {
        return clientSecretFile;
    }

    /**
    * lfkjgmdljgk.
    * @param clientSecretFile.
    */
    public void setClientSecretFile(String clientSecretFile) {
        this.clientSecretFile = clientSecretFile;
    }

    public String getCredentialFilePath() {
        return clientSecretFile;
    }

    public String getTokensDirectoryPath() {
        return credentialFolder;
    }

    /**
     * @param appName the applicationName to set
     */
    public void setApplicationName(final String appName) {
        this.applicationName = appName;
    }

    /**
     * 
     * @return
     */
    public String getApplicationName() {
        return applicationName;
    }

    public String getoAuth2CallbackUrl() {
        return auth2CallBackUrl;

    }
}
