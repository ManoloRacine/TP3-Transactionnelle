package com.manolo.tp3transactionnelle.controllers;

import com.manolo.tp3transactionnelle.DTO.ClientDTO;
import com.manolo.tp3transactionnelle.DTO.DocumentSimpleDTO;
import com.manolo.tp3transactionnelle.forms.BookForm;
import com.manolo.tp3transactionnelle.forms.BorrowForm;
import com.manolo.tp3transactionnelle.forms.ClientForm;
import com.manolo.tp3transactionnelle.forms.ReturnForm;
import com.manolo.tp3transactionnelle.model.Book;
import com.manolo.tp3transactionnelle.model.Client;
import com.manolo.tp3transactionnelle.model.Document;
import com.manolo.tp3transactionnelle.service.AdminService;
import com.manolo.tp3transactionnelle.service.ClientService;
import com.manolo.tp3transactionnelle.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class RootController {
    Logger logger = LoggerFactory.getLogger(RootController.class) ;

    private ClientService clientService ;

    private AdminService adminService ;

    private EmployeeService employeeService ;

    public RootController(ClientService clientService, AdminService adminService,
                          EmployeeService employeeService) {
        this.clientService = clientService ;
        this.adminService = adminService ;
        this.employeeService = employeeService ;
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

    @GetMapping("/clientcreate")
    public String getClientCreate(@ModelAttribute ClientForm clientForm,
                                  Model model) {
        clientForm = new ClientForm(new Client()) ;
        model.addAttribute("clientForm", clientForm) ;
        return "clientCreate" ;
    }

    @PostMapping("/clientcreate")
    public String clientPost(@Valid @ModelAttribute ClientForm clientForm,
                             BindingResult errors,
                             Model model
                             ) {

        if (errors.hasErrors()) {
            return "/clientCreate" ;
        }

        adminService.createClient(clientForm.toClient()) ;
        model.addAttribute("clientForm", clientForm) ;
        return "redirect:clients" ;
    }

    @GetMapping("/bookcreate")
    public String getBookCreate(@ModelAttribute BookForm bookForm,
                                Model model) {
        bookForm = new BookForm(new Book()) ;
        model.addAttribute("bookForm", bookForm) ;
        return "bookCreate" ;
    }

    @PostMapping("/bookcreate")
    public String bookPost(@Valid @ModelAttribute BookForm bookForm,
                           BindingResult errors,
                           Model model) {

        if (errors.hasErrors()) {
            return "bookCreate" ;
        }

        employeeService.createBook(bookForm.toBook()) ;
        model.addAttribute("bookForm", bookForm) ;
        return "redirect:/" ;
    }

    @GetMapping("/borrow")
    public String getBorrow(@ModelAttribute BorrowForm borrowForm,
                            Model model) {
        borrowForm = new BorrowForm() ;
        model.addAttribute("borrowForm", borrowForm) ;
        return "borrow" ;
    }

    @PostMapping("/borrow")
    public String postBorrow(@Valid @ModelAttribute BorrowForm borrowForm,
                             BindingResult errors) throws Exception {

        if (errors.hasErrors()) {
            return "borrow" ;
        }

        clientService.borrowDocument(borrowForm.getClientId(), borrowForm.getDocumentId(), borrowForm.getNbDays()) ;
        return "redirect:client/" + borrowForm.getClientId() ;
    }

    @GetMapping("/return")
    public String getReturn(@ModelAttribute ReturnForm returnForm,
                            Model model) {
        returnForm = new ReturnForm() ;
        model.addAttribute("returnForm", returnForm) ;
        return "return" ;
    }

    @PostMapping("/return")
    public String postReturn(@Valid @ModelAttribute ReturnForm returnForm,
                             BindingResult errors) throws Exception {

        if (errors.hasErrors()) {
            return "return" ;
        }

        clientService.returnDocument(returnForm.getClientId(), returnForm.getBorrowId());
        return "redirect:client/" + returnForm.getClientId() ;
    }
}
