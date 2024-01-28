package com.example.webMvcCrudDemo.service;

import com.example.webMvcCrudDemo.dto.BookDto;
import com.example.webMvcCrudDemo.mapper.BookMapper;
import com.example.webMvcCrudDemo.model.Book;
import com.example.webMvcCrudDemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public List<BookDto> getBookList() {
        List<Book> bookList = bookRepository.findAll();
        return bookMapper.mapToBookDtoList(bookList);
    }

    public void saveBook(Book book) {
        Book saveBook = bookRepository.save(book);
        bookMapper.mapToBookDto(saveBook);
    }

    public BookDto findBookById(long bookId) {
        Book book = bookRepository.findById(bookId).get();
        return bookMapper.mapToBookDto(book);
    }

    public void deleteBookById(long bookId) {
        bookRepository.deleteById(bookId);
    }


}
