package com.app.controller;

import com.app.dao.BookDAOImpl;
import com.app.dto.BookDto;
import com.app.model.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller

public class HomeController {

    private final BookDAOImpl bookDAOImpl;
    private final JdbcTemplate jdbcTemplate;

    public HomeController(BookDAOImpl bookDAOImpl, JdbcTemplate jdbcTemplate) {
        this.bookDAOImpl = bookDAOImpl;
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        String sql = "select * from book";
        List<Book> books = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Book.class));

        model.addAttribute("books", books);

        return "home";
    }

    @GetMapping("/book/create")
    public String bookCreatePage(){
        return "book_create";
    }

    @PostMapping("/book/create")
    public String bookCreate(@ModelAttribute BookDto dto){
        bookDAOImpl.save(dto);
        return "redirect:/";
    }

    @GetMapping("/book/update/{id}")
    public String bookUpdatePage(@PathVariable Integer id, Model model) {
        Book book = bookDAOImpl.getById(id);
        model.addAttribute("book", book);
        return "book_update";
    }

    @PostMapping("/book/update")
    public String bookUpdate(@ModelAttribute Book book) {
        bookDAOImpl.update(book);
        return "redirect:/";
    }

    @GetMapping("/book/delete/{id}")
    public String deletePage(@PathVariable Integer id){
        bookDAOImpl.delete(id);
        return "redirect:/";
    }

    @GetMapping("/book/search")
    public String search(@RequestParam("search") String search, @RequestParam("category") String category, Model model){

        if (category.equals("title")){
            List<Book> books = bookDAOImpl.searchByTitle(search);
            model.addAttribute("books", books);
        } else if (category.equals("author")) {
            List<Book> books = bookDAOImpl.searchByAuthor(search);
            model.addAttribute("books", books);
        } else if (category.equals("description")) {
            List<Book> books = bookDAOImpl.searchByDescription(search);
            model.addAttribute("books", books);
        } else {
            return "home";
        }
        return "home";
    }
}
