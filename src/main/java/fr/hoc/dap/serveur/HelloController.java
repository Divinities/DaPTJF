package fr.hoc.dap.serveur;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/Hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/Bonjour")
    public String direBonjour(@RequestParam("name") String theName) {
        return "Salut !" + theName;
    }

}
