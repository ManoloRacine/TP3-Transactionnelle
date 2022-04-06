package com.manolo.tp3transactionnelle;

import com.manolo.tp3transactionnelle.model.Employee;
import com.manolo.tp3transactionnelle.service.AdminService;
import com.manolo.tp3transactionnelle.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tp3TransactionnelleApplication implements CommandLineRunner {

    @Autowired
    private AdminService adminService ;

    @Autowired
    private EmployeeService employeeService ;

    public static void main(String[] args) {
        SpringApplication.run(Tp3TransactionnelleApplication.class, args);
    }


    public void run(String... args) {
        System.out.println("test");
        long idClient = adminService.createClient("firstName", "lastName", "password") ;
        System.out.println(adminService.getClientByIdWithBorrowing(idClient));

        long idCD = employeeService.createCD("name1", "author", 2002, 100, "testa",  5);
        long idDVD = employeeService.createDVD("name1", "author1", 2002, 100, "testg", 5);
        long idBook = employeeService.createBook("name2", "author", 2020, 200, "testg",  5) ;

        System.out.println(employeeService.researchDocumentByAuthor("author"));
        System.out.println(employeeService.researchDocumentByYear(2002));
        System.out.println(employeeService.researchDocumentByCategory("testg"));
        System.out.println(employeeService.researchDocumentContainingTitle("e1"));
    }
}
