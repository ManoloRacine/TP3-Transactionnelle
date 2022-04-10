package com.manolo.tp3transactionnelle.controllers;

import com.manolo.tp3transactionnelle.DTO.ClientDTO;
import com.manolo.tp3transactionnelle.DTO.DocumentSimpleDTO;
import com.manolo.tp3transactionnelle.model.Client;
import com.manolo.tp3transactionnelle.model.Document;
import com.manolo.tp3transactionnelle.service.AdminService;
import com.manolo.tp3transactionnelle.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class RootController {
    Logger logger = LoggerFactory.getLogger(RootController.class) ;

    private ClientService clientService ;

    private AdminService adminService ;

    public RootController(ClientService clientService, AdminService adminService) {
        this.clientService = clientService ;
        this.adminService = adminService ;
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

    @GetMapping("/clients")
    public String getClients(Model model) {
        List<ClientDTO> listeDTO = new ArrayList<>() ;

        for (Client client : adminService.getClients()) {
            listeDTO.add(new ClientDTO(client)) ;
        }

        model.addAttribute("clients", listeDTO) ;
        return "clients" ;
    }

    @GetMapping("/client/{id}")
    public String getClientRequest(Model model, @PathVariable(required = false) Long id) {
        Optional<Client> client = adminService.getClientByIdWithBorrowing(id) ;


        model.addAttribute("client", new ClientDTO(client.get())) ;

        return "client" ;
    }
}
