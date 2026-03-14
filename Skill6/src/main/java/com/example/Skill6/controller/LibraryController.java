package com.example.Skill6.controller;

import com.example.Skill6.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    // In-memory storage for books
    private List<Book> bookList = new ArrayList<>();

    // 2. /welcome endpoint
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library!";
    }

    // 3. /count endpoint
    @GetMapping("/count")
    public int totalBooks() {
        return bookList.size();
    }

    // 4. /price endpoint
    @GetMapping("/price")
    public double sampleBookPrice() {
        return 499.99;
    }

    // 5. /books endpoint - return a list of book titles
    @GetMapping("/books")
    public List<String> bookTitles() {
        List<String> titles = new ArrayList<>();
        for (Book book : bookList) {
            titles.add(book.getTitle());
        }
        return titles;
    }

    // 6. /books/{id} endpoint - return book details using @PathVariable
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookList.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // 7. /search endpoint - accepts request parameter
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Search request received for book: " + title;
    }

    // 8. /author/{name} endpoint
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Author name: " + name;
    }

    // 9. /addbook endpoint - accepts Book object in request body
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully: " + book.getTitle();
    }

    // 10. /viewbooks endpoint - return all added Book objects
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}