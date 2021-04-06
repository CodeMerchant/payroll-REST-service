package com.example.Payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            employeeRepository.save(new Employee("Pablo", "Escobar", "Drug Lord: Colombia"));
            employeeRepository.save(new Employee("Joaquin El Chapo", "Guzman", "Drug Lord: Mexico"));

            employeeRepository.findAll()
                    .forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("Mercedes S600 Pullman", Status.COMPLETED));
            orderRepository.save(new Order("Mercedes Benz SLS AMG", Status.IN_PROGRESS));

            orderRepository.findAll()
                    .forEach(order -> log.info("Preloaded " + order));
        };

    }

}
