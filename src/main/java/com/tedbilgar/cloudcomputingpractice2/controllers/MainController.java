package com.tedbilgar.cloudcomputingpractice2.controllers;

import com.tedbilgar.cloudcomputingpractice2.entities.BookEntity;
import com.tedbilgar.cloudcomputingpractice2.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("app")
@RestController
@RequiredArgsConstructor
public class MainController {

    private final BookService bookService;

    @GetMapping("cloud")
    public String getCloud() {
        return "hello docker";
    }

    @GetMapping(value = {"books", "books/{id}"})
    public List<BookEntity> getBooks(@PathVariable(required = false) Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String sort) {
        if (id != null) {
            return bookService.getBookById(id);
        }
        return bookService.findBookByName(name, sort);
    }
}
