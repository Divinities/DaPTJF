package fr.hoc.dap.serveur;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
//TODO TJF by Djer |POO| Devrait être dnsn le (sous) pacakeg "controller"
@RestController
public class HelloController {

    //TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
    @RequestMapping("/Hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    //TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
    @RequestMapping("/Bonjour")
    public String direBonjour(@RequestParam("name") String theName) {
        return "Salut !" + theName;
    }
}
