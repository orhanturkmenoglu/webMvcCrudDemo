package com.example.webMvcCrudDemo.controller;

import com.example.webMvcCrudDemo.dto.BookDto;
import com.example.webMvcCrudDemo.model.Book;
import com.example.webMvcCrudDemo.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    @Operation(summary = "list books", description = "list books")
    @ApiResponse(responseCode = "200",description = "list books")
    public String getBookList(Model model) {
        List<BookDto> getBookList = bookService.getBookList();
        model.addAttribute("books", getBookList);
        return "books-list";
    }

    @GetMapping("/books/create")
    @Operation(summary = "create book", description = "create the book object")
    @ApiResponse(responseCode = "201",description = "create book")
    public String createBookForm(Model model) {
        BookDto book = new BookDto();
        model.addAttribute("books", book);
        return "books-create";
    }

    @PostMapping("/books/create")
    @Operation(summary = "create book", description = "create book")
     @ApiResponse(responseCode = "201",description = "create book")
    public String saveBook( @Valid @ModelAttribute("books")  Book book
            , BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "books-create";
        } else {
            bookService.saveBook(book);
        }
        return "redirect:/books";
    }

    @GetMapping("/books/{bookId}/update")
    @Operation(summary = "update book", description = "update book")
    @ApiResponse(responseCode = "201",description = "update book")
    public String updateBookForm(@PathVariable("bookId") long bookId, Model model) {
        BookDto bookDto = bookService.findBookById(bookId);
        model.addAttribute("books", bookDto);
        return "books-update";
    }

    @PostMapping("/books/{bookId}/update")
    @Operation(summary = "update book", description = "update book")
    @ApiResponse(responseCode = "201",description = "update book")
    public String updateBook(@PathVariable("bookId") long bookId, @ModelAttribute("books") Book books) {
        books.setId(bookId);
        bookService.saveBook(books);
        return "redirect:/books";
    }

    @GetMapping("/books/{bookId}/delete")
    @Operation(summary = "delete book object by id", description = "delete book")
    @ApiResponse(responseCode = "200",description = "Delete book")
    public String deleteBook(@PathVariable("bookId") long bookId, Model model) {
        bookService.deleteBookById(bookId);
        model.addAttribute("books", bookId);
        return "redirect:/books";
    }

}
