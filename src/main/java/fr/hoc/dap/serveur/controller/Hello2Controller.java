package fr.hoc.dap.serveur.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.hoc.dap.serveur.service.GoogleService;

@Controller
public class Hello2Controller extends GoogleService {

    @RequestMapping("/hello2")

    public ArrayList<String> hello(ModelMap model) {

        ArrayList<String> Tableau = new ArrayList<String>(10);
        tableau.add(flow.loadCredential)
        return Tableau;

    }
}
