package com.example.webMvcCrudDemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "books")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String barcode;
    private String brand;
    private String author;
    private String category;
    private long numberOfPages;
    private long amountOfStock;
    private double purchasePrice;
    private double salePrice;
    private double discountRate;
    private double discountedPrice;

    public double getDiscountedPrice() {
        return getSalePrice() - ((getSalePrice() * getDiscountRate()) / 100);
    }
}
