package net.ms.function;

import net.ms.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookFunction {

    private final List<Book> BOOKS;

    public BookFunction(final List<Book> BOOK_LIST) {
        this.BOOKS = BOOK_LIST;
    }

    //Agregar nuevos libros a la lista
    public void addBook(final Book book) {
        this.BOOKS.add(book);
    }

    //Búsqueda de libros
    public List<Book> searchBook(final String query) {
        final List<Book> booksFound = new ArrayList<>();
        for (Book book: this.BOOKS) {
            if ((book.getBookTitle().toLowerCase().contains(query.toLowerCase())) || (book.getBookAuthor().toLowerCase().contains(query.toLowerCase()))) {
                booksFound.add(book);
            }
        }

        return booksFound;
    }

    //Menu de libros
    public int bookMenu(){
        System.out.println("\n------------------------- MENU ------------------------");
        System.out.println("\t-> [1] Lista de libros disponibles");
        System.out.println("\t-> [2] Agregar libro");
        System.out.println("\t-> [3] Buscar libro");
        System.out.println("\t-> [4] Salir");
        return 0;
    }
}
