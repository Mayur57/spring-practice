package com.mayur.example.example.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student s1 = new Student(
                    "Mayur",
                    "Bhoi",
                    "mayur@example.com",
                    "+9238892323",
                    LocalDate.of(2000, Month.JULY, 5)
            );
            Student[] studentArray = {s1};
            repository.saveAll(Arrays.asList(studentArray));
        };
    };

}
