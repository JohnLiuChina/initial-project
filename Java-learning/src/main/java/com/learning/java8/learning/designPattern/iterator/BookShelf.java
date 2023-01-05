package com.learning.java8.learning.designPattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Aggregate {

    private List<Book> books = new ArrayList<>();

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
