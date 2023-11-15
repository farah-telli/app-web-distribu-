package com.example.job;

import com.example.job.Repositories.JobRepository;
import com.example.job.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JobApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }


    @Autowired
    private JobRepository repository;
    @Bean
    ApplicationRunner init() {
        return (args) -> {
            repository.save(new Job( "service", true));
            repository.save(new Job( "Service",  false));
            repository.save(new Job( "serviiice", false));

            repository.findAll().forEach(System.out::println);

        };
    }
}
