package com.example.rabbitmq.Bean;

/**
 * @author 袁毅
 * @date 2019/4/4 0004-上午 12:56
 */
public class book {
    String bookName;
    String author;

    public book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
