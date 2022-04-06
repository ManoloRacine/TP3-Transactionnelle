package com.manolo.tp3transactionnelle;

import com.manolo.tp3transactionnelle.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tp3TransactionnelleApplication implements CommandLineRunner {

    @Autowired
    private AdminService adminService ;

    public static void main(String[] args) {
        SpringApplication.run(Tp3TransactionnelleApplication.class, args);
    }


    public void run(String... args) {
        System.out.println("test");
        long idClient = adminService.createClient("firstName", "lastName", "password") ;
        System.out.println(adminService.getClientByIdWithBorrowing(idClient));
    }
}
