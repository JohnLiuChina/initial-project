package com.learning.java8;

import com.learning.java8.learning.designPattern.iterator.Book;
import com.learning.java8.learning.designPattern.iterator.BookShelf;
import com.learning.java8.learning.designPattern.iterator.Iterator;

public class BookTest {

    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();
        shelf.addBook(new Book("a"));
        shelf.addBook(new Book("b"));
        shelf.addBook(new Book("c"));

        Iterator iterator = shelf.iterator();

        while (iterator.hasNext()) {
            Book temp = iterator.next();
            System.out.println(temp);
        }
    }

}
