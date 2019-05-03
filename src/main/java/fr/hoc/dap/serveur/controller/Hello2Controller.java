package fr.hoc.dap.serveur.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.hoc.dap.serveur.service.GoogleService;

//TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
@Controller
public class Hello2Controller extends GoogleService {

    //TODO TJF by Djer |JavaDoc| Il manque la JavaDoc
    @RequestMapping("/hello2")
    public ArrayList<String> hello(ModelMap model) {

      //TODO TJF by Djer |POO| Ne Compile pas !!!! (traite les "error" remontées par Eclipse)
        ArrayList<String> Tableau = new ArrayList<String>(10);
        tableau.add(flow.loadCredential)
        return Tableau;

    }
}
