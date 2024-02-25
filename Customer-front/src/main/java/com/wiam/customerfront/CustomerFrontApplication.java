package com.wiam.customerfront;

import com.wiam.customerfront.entities.Customer;
import com.wiam.customerfront.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerFrontApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("Wiam").email("Wiam@gmail.com").build());
            customerRepository.save(Customer.builder().name("Imane").email("imane@gmail.com").build());
            customerRepository.save(Customer.builder().name("Asmaa").email("asmaa@gmail.com").build());
        };
    }






}
