package com.example.webMvcCrudDemo.mapper;

import com.example.webMvcCrudDemo.dto.BookDto;
import com.example.webMvcCrudDemo.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookMapper {

    public List<BookDto> mapToBookDtoList(List<Book> bookList) {
        return bookList
                .stream()
                .map(this::mapToBookDto)
                .toList();
    }

    public BookDto mapToBookDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .barcode(book.getBarcode())
                .author(book.getAuthor())
                .category(book.getCategory())
                .brand(book.getBrand())
                .numberOfPages(book.getNumberOfPages())
                .amountOfStock(book.getAmountOfStock())
                .purchasePrice(book.getPurchasePrice())
                .discountRate(book.getDiscountRate())
                .salePrice(book.getSalePrice())
                .discountedPrice(book.getDiscountedPrice())
                .build();
    }
}
