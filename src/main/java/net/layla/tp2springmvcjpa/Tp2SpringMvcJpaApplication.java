package net.layla.tp2springmvcjpa;

import net.layla.tp2springmvcjpa.entities.Product;
import net.layla.tp2springmvcjpa.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tp2SpringMvcJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp2SpringMvcJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(ProductRepository productRepository ) {
        return args -> {
            productRepository.save(Product.builder()
                            .name("Computer")
                            .price(5400)
                            .quantity(12)
                    .build());
            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1200)
                    .quantity(11)
                    .build());
            productRepository.save(Product.builder()
                    .name("Smart Phone")
                    .price(12000)
                    .quantity(33)
                    .build());

            productRepository.findAll().forEach(p -> {
                System.out.println(p.toString());
            });
        };
    }
}
