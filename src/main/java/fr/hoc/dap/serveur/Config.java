package fr.hoc.dap.serveur;

/** class config.*/

public class Config {

    /** dossier credential.*/
    private static final String CREDENTIAL_FILE_PATH = System.getProperty("user.home") + "/credentials.json";
    /** dossier Tokens.*/
    private static final String TOKENS_DIRECTORY_PATH = System.getProperty("user.home") + "tokens";
    /** dossier Application name.*/
    private static final String APPLICATION_NAME = "HoCDaP";
    /** URL de redirection autorisé. */
    private static final String AUTH2_CALLBACK_URL = "/oAuth2Callback";

    /** app.*/
    private String applicationName;
    /** app.*/
    private String credentialFolder;
    /** app.*/
    private String clientSecretFile;
    /**app.*/
    private String auth2CallBackUrl;

    /** créer le constructeur.*/
    public Config() {
        applicationName = APPLICATION_NAME;
        credentialFolder = TOKENS_DIRECTORY_PATH;
        clientSecretFile = CREDENTIAL_FILE_PATH;
        auth2CallBackUrl = AUTH2_CALLBACK_URL;

    }

    /**
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
