package fr.hoc.dap.serveur;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author house
 *
 */

@SpringBootApplication
public class Application {

    /** Logger. */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Entry Point.
     * @param args args
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * create a customisez config?
     * @return the customised config
     */
    @Bean
    public Config config() {
        Config config = new Config();
        //config.setClientSecretFile("/credential_web.json");
        return config;
    }

    /**
     * Execute code after Spring start the app.
     * @return a CommandLineRunner instance
     */
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

            LOG.info(config().getCredentialFilePath());

            //1- Gérer la config

            //2- Changer le "appName" en "BoB"

            //3- Passer cette config aux Service (CalendarService, GmailService)
            //            Config config = new Config();
            //
            //            config.setApplicationName("bob 258");
            //            LOG.info("salut le monde");
            //
            //            System.out.println("Lancement de : " + config.getApplicationName());
            //
            //            GmailService mail = GmailService.getInstance();
            //            LOG.info("salut le monde");
            //
            //            CalendarService calendrier = CalendarService.getInstance();
            //            LOG.info("salut le monde");
            //
            //            mail.setConf(config);
            //            mail.displayNbUnreadMessage();
            //
            //            calendrier.setConf(config);
            //            calendrier.nextEvents();

        };
    }
}
