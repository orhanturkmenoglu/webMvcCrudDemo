package com.example.webMvcCrudDemo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(title = "books", description = "Book model")
public class BookDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "id of the Book",
            name = "id",
            type = "long",
            example = "1")
    private Long id;

    @Schema(
            description = "Name of the Book",
            name = "name",
            type = "String",
            example = "Var Mısın ?")
    @NotNull(message = " must not be empty name")
    private String name;

    @Schema(
            description = "Barcode of the Book",
            name = "barcode",
            type = "String",
            example = "9786057635839")
    @NotNull(message = " must not be empty barcode")
    @Min(value = 0, message = "must be greater than or equal to zero")
    private String barcode;


    @Schema(
            description = "Brand of the Book",
            name = "brand",
            type = "String",
            example = "Kronik Yayınları")
    @NotNull(message = " must not be empty brand")
    private String brand;


    @Schema(
            description = "Author of the Book",
            name = "author",
            type = "String",
            example = "İlber Ortaylı")
    @NotNull(message = " must not be empty author")
    private String author;


    @Schema(
            description = "Category of the Book",
            name = "category",
            type = "String",
            example = "KİŞİSEL GELİŞİM")
    @NotNull(message = " must not be empty category")
    private String category;


    @Schema(
            description = "Number Of Pages of the Book",
            name = "numberOfPages",
            type = "long",
            example = "320")
    @NotNull(message = " must not be empty Number Of Pages")
    @Min(value = 0, message = "must be greater than or equal to zero")
    private Long numberOfPages;


    @Schema(
            description = "Amount Of Stock of the Book",
            name = "amountOfStock",
            type = "long",
            example = "10")
    @NotNull(message = " must not be empty Amount Of Stock")
    @Min(value = 0, message = "must be greater than or equal to zero")
    private Long amountOfStock;


    @Schema(
            description = "Purchase Price of the Book",
            name = "purchasePrice",
            type = "double",
            example = "60")
    @NotNull(message = " must not be empty Purchase Price")
    @Min(value = 0, message = "the lowest purchase price should be zero")
    private double purchasePrice;


    @Schema(
            description = "Sale Price of the Book",
            name = "salePrice",
            type = "double",
            example = "140")
    @NotNull(message = " must not be empty Sale Price")
    @Min(value = 0, message = "the lowest sale price should be zero")
    private double salePrice;


    @Schema(
            description = "Discount Rate of the Book",
            name = "discountRate",
            type = "double",
            example = "33")
    @NotNull(message = " must not be empty Discount Rate")
    @Min(value = 0, message = "the lowest discount rate should be zero")
    private double discountRate;


    @Schema(
            description = "Discounted Price the Book",
            name = "discountedPrice",
            type = "double",
            example = "1")
    @NotNull(message = " must not be empty Discounted Price")
    @Min(value = 0, message = "the lowest discounted price rate should be zero")
    private double discountedPrice;

    public double getDiscountedPrice() {
        return getSalePrice() - ((getSalePrice() * getDiscountRate()) / 100);
    }
}
