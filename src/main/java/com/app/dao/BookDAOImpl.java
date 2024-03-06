package com.app.dao;

import com.app.dto.BookDto;
import com.app.model.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO{
    private final JdbcTemplate jdbcTemplate;

    public BookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(BookDto bookDto) {
        String sql = "insert into book(title, author, price, description) values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, bookDto.getTitle(), bookDto.getAuthor(), bookDto.getPrice(), bookDto.getDescription());
    }

    @Override
    public List<Book> getAll() {
        return jdbcTemplate.query("select * from book", BeanPropertyRowMapper.newInstance(Book.class));
    }

    @Override
    public Book getById(Integer id) {
        return jdbcTemplate.queryForObject("select * from book where id = ?", new Object[]{id},
                BeanPropertyRowMapper.newInstance(Book.class));
    }

    @Override
    @Transactional
    public void update(Book book) {
        jdbcTemplate.update("update book set title = ?, author = ?, price = ?, description = ? where id = ?",
                book.getTitle(), book.getAuthor(), book.getPrice(), book.getDescription(), book.getId());

    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("delete from book where id = ?", id);
    }

    @Override
    public List<Book> searchByTitle(String title) {
        String query = "SELECT * FROM book b WHERE b.title = ?";
        List<Book> bookByTitle = jdbcTemplate.query(query, new Object[]{title},
                BeanPropertyRowMapper.newInstance(Book.class));
        return bookByTitle;
    }

    @Override
    public List<Book> searchByAuthor(String title) {
        String query = "select * from book b where author = ?";
        return jdbcTemplate.query(query, new Object[]{title}, BeanPropertyRowMapper.newInstance(Book.class));
    }

    @Override
    public List<Book> searchByDescription(String description) {
        String sql = "select * from book where description = ?";
        return jdbcTemplate.query(sql, new Object[]{description}, BeanPropertyRowMapper.newInstance(Book.class));
    }
}
