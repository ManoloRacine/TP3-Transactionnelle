package com.manolo.tp3transactionnelle.controllers;

import com.manolo.tp3transactionnelle.DTO.DocumentSimpleDTO;
import com.manolo.tp3transactionnelle.model.Client;
import com.manolo.tp3transactionnelle.model.Document;
import com.manolo.tp3transactionnelle.service.ClientService;
import com.manolo.tp3transactionnelle.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RootController {
    Logger logger = LoggerFactory.getLogger(RootController.class) ;

    private ClientService clientService ;

    public RootController(ClientService clientService) {
        this.clientService = clientService ;
    }

    @GetMapping("/")
    public String getRootRequest(Model model) {
        List<DocumentSimpleDTO> listeDTO = new ArrayList<>() ;
        for (Document document : clientService.getAllDocuments()) {
            DocumentSimpleDTO documentSimpleDTO = new DocumentSimpleDTO(document) ;
            listeDTO.add(documentSimpleDTO) ;
        }

        model.addAttribute("documents", listeDTO) ;
        return "index" ;
    }
}
