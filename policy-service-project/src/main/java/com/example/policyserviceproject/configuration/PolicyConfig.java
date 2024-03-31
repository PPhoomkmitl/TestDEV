package com.example.policyserviceproject.configuration;

import com.example.policyserviceproject.model.Policy;
import com.example.policyserviceproject.repository.PolicyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PolicyConfig {
    @Bean
    CommandLineRunner commandLineRunner(PolicyRepository repository) {
        return args -> {
            Policy person1 = new Policy(
                    "นายA1",
                    "P00031",
                    "CL",
                    "A",
                    "00000005"
            );
            Policy person2 = new Policy(
                    "นางB2",
                    "P00032",
                    "LI",
                    "A",
                    "00000006"
            );
            Policy person3 = new Policy(
                    "นายA3",
                    "P00033",
                    "HI",
                    "A",
                    "00000007"
            );

            repository.saveAll(
                    List.of(person1, person2, person3)
            );
        };
    }
}
