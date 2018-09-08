package bookshop;


import domain.Book;

import java.util.LinkedList;
import java.util.List;

public class Persistence {

    private static List<Book> books;

    public static List<Book> getAllBooks() {
        if (books == null) {
            books = new LinkedList<Book>();
            books.add(new Book("111-222-333", "Thomas H. Cormen",
                    "Introduction to Algorithms",(float) 100.0,1));
            books.add(new Book("444-555-666", "Andy Hunt and Dave Thomas",
                    "The Pragmatic Programmer", (float) 200.7,2));
        }
        return books;
    }

    public static Book getBook(String isbn) {
        for (Book b : getAllBooks()) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }
    public static boolean removeBook(String isbn) {
        for (Book b : getAllBooks()) {
            if (b.getIsbn().equals(isbn)) {
            	books.remove(b);
                return true;
            }
        }
        return false;
    }
}
