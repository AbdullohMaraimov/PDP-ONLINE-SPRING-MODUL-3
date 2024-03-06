package com.app.dao;

import com.app.dto.BookDto;
import com.app.model.Book;

import java.util.List;

public interface BookDAO {

    // CRUD
    void save(BookDto bookDto);
    List<Book> getAll();
    Book getById(Integer id);
    void update(Book book);
    void delete(Integer id);

    // Searching
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String title);
    List<Book> searchByDescription(String title);
}
