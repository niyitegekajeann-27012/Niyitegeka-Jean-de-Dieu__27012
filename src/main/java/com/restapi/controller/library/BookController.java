package com.restapi.controller.library;

import com.restapi.model.library.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private List<Book> books = new ArrayList<>();
    private Long nextId = 4L;

    public BookController() {
        books.add(new Book(1L, "Inyigisho z'Ubuntu", "Uwase Aline", "978-0132350884", 2020));
        books.add(new Book(2L, "Amateka y'u Rwanda", "Mugabo Eric", "978-0134685991", 2019));
        books.add(new Book(3L, "Imigani Myiza", "Ishimwe Grace", "978-1617294945", 2021));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchByTitle(@RequestParam String title) {
        List<Book> result = books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
                .toList();
        return result.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        book.setId(nextId++);
        books.add(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean removed = books.removeIf(b -> b.getId().equals(id));
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
