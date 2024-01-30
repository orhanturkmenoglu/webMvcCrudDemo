package com.example.webMvcCrudDemo.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = " must not be empty name")
    private String name;

    @NotNull(message = " must not be empty barcode")
    @Min(value = 0 ,message = "must be greater than or equal to zero")
    private String barcode;

    @NotNull(message = " must not be empty brand")
    private String brand;

    @NotNull(message = " must not be empty author")
    private String author;

    @NotNull(message = " must not be empty category")
    private String category;

    @NotNull(message = " must not be empty Number Of Pages")
    @Min(value = 0,message = "must be greater than or equal to zero")
    private Long numberOfPages;

    @NotNull(message = " must not be empty Amount Of Stock")
    @Min(value = 0,message = "must be greater than or equal to zero")
    private Long amountOfStock;

    @NotNull(message = " must not be empty Purchase Price")
    @Min(value = 0,message = "the lowest purchase price should be zero")
    private double purchasePrice;

    @NotNull(message = " must not be empty Sale Price")
    @Min(value = 0,message = "the lowest sale price should be zero")
    private double salePrice;

    @NotNull(message = " must not be empty Discount Rate")
    @Min(value = 0,message = "the lowest discount rate should be zero")
    private double discountRate;

    @NotNull(message = " must not be empty Discounted Price")
    @Min(value = 0,message = "the lowest discounted price rate should be zero")
    private double discountedPrice;

    public double getDiscountedPrice() {
        return getSalePrice() - ((getSalePrice() * getDiscountRate()) / 100);
    }
}
