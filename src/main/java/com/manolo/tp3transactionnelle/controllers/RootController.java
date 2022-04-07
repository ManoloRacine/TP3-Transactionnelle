package com.manolo.tp3transactionnelle.controllers;

import com.manolo.tp3transactionnelle.model.Client;
import com.manolo.tp3transactionnelle.service.ClientService;
import com.manolo.tp3transactionnelle.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    Logger logger = LoggerFactory.getLogger(RootController.class) ;

    private ClientService clientService ;

    public RootController(ClientService clientService) {
        this.clientService = clientService ;
    }

    @GetMapping("/")
    public String getRootRequest(Model model) {
        model.addAttribute("documents", clientService.getAllDocuments()) ;
        return "index" ;
    }
}
