package ru.pavlinina.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.pavlinina.bookstore.models.Book;
import ru.pavlinina.bookstore.repositories.BookRepository;

import java.io.IOException;
import java.util.List;

/**
 * @author Sofia Pavlinina
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "books")
public class BookController {

    private byte[] bytes;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/get")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        this.bytes = file.getBytes();
    }

    @PostMapping("/add")
    public void createBook(@RequestBody Book book) throws IOException {
        book.setPicByte(this.bytes);
        bookRepository.save(book);
        this.bytes = null;
    }

    @PutMapping("/update")
    public void updateBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @DeleteMapping(path = { "/{id}" })
    public Book deleteBook(@PathVariable("id") long id) {
        Book book = bookRepository.getOne(id);
        bookRepository.deleteById(id);
        return book;
    }
}
