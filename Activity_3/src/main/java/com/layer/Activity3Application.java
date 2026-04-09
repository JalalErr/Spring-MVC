package com.layer;

import com.layer.entity.Product;
import com.layer.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Activity3Application {

    private final ProductRepository productRepository;

    public Activity3Application(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Activity3Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Product product = Product.builder()
                    .name("Computer").price(4000).quantity(11).build();
            productRepository.save(product);
            productRepository.save(product.builder().name("Smart Phone").price(7000).quantity(45).build());
            productRepository.save(product.builder().name("Printer").price(100).quantity(4).build());
            productRepository.save(product.builder().name("Camera").price(1800).quantity(8).build());
            productRepository.findAll().forEach(p-> {
                System.out.println("Liste of products : " + p);
            });
            productRepository.save(new Product());
        };
    }
}
