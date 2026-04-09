package com.layer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    private int quantity;

}
