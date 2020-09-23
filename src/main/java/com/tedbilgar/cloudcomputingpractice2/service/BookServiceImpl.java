package com.tedbilgar.cloudcomputingpractice2.service;

import com.tedbilgar.cloudcomputingpractice2.entities.BookEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private List<BookEntity> bookEntityList;

    @PostConstruct
    public void initBooks() {
        bookEntityList = Stream.of(
                new BookEntity(1L, "CoreJava", 900L, 4.5, "Core Java Volume I – Fundamentals is a Java reference book (Best book for Java)that offers a detailed explanation of various features of Core Java, including exception handling, interfaces, and lambda expressions."),
                new BookEntity(2L, "EffectiveJava", 450L, 3.8, "A must-have book for every Java programmer and Java aspirant, Effective Java makes up for an excellent complementary read with other Java books or learning material. "),
                new BookEntity(3L, "BeginnerGuide", 700L, 4.0, "If you are a seasoned Java programmer looking to enhance your Java knowledge, don’t be averted by the title of the book, Java: A Beginner’s Guide. It is, in fact, one of the most comprehensive books for learning Java. Anyone with basic programming knowledge can easily benefit from the Java: A Beginner’s Guide. "),
                new BookEntity(4L, "HeadFirstJava", 1000L, 4.2, "The most important selling points of Head First Java is its simplicity and super-effective real-life analogies that pertain to the Java programming concepts. It is also the best book to learn java and to start your learning journey with Java Development.")
                ).collect(Collectors.toList());
    }

    public List<BookEntity> getAllBooks() {
        return bookEntityList;
    }

    public List<BookEntity> getBookById(Long id) {
        return bookEntityList.stream().filter(bookEntity -> bookEntity.getId() == id).collect(Collectors.toList());
    }


    public List<BookEntity> findBookByName(String name, String sort) {
        Stream<BookEntity> bookEntityStream = null;
        if (name != null) {
            bookEntityStream = bookEntityList.stream().filter(bookEntity -> bookEntity.getName().equals(name));
        } else {
            bookEntityStream = bookEntityList.stream();
        }
        if (sort != null) {
            if (sort.equals("ASC")) {
                return bookEntityStream.sorted(Comparator.comparing(BookEntity::getId)).collect(Collectors.toList());
            } else {
                return bookEntityStream.sorted(Comparator.comparing(BookEntity::getId).reversed()).collect(Collectors.toList());
            }
        } else {
            return bookEntityStream.collect(Collectors.toList());
        }
    }
}
