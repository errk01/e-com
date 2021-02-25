package com.tts.ecomspring.model;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")

    // ints
    private Long id;
    private int quantity;
    private double price;

    // strings
    private String brand;
    private String category;
    private String name;
    private String image;
    private String description;



}
