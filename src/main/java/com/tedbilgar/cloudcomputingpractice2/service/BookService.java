package com.tedbilgar.cloudcomputingpractice2.service;

import com.tedbilgar.cloudcomputingpractice2.entities.BookEntity;

import java.util.List;

public interface BookService {
    List<BookEntity> getAllBooks();
    List<BookEntity> getBookById(Long id);
    List<BookEntity> findBookByName(String name, String sort);
}
