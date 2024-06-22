package net.ms.function;

import net.ms.model.Book;
import net.ms.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookFunction {

    private final List<Book> BOOKS;
    private final Scanner SCANNER;

    public BookFunction(final List<Book> BOOK_LIST, final Scanner SCANNER) {
        this.BOOKS = BOOK_LIST;
        this.SCANNER = SCANNER;
    }

    //Agregar nuevos libros a la lista
    public void addBook(final Book book) {
        this.BOOKS.add(book);
    }

    //Búsqueda de libros
    public List<Book> searchBook(final String query) {
        final List<Book> booksFound = new ArrayList<>();
        for (Book book : this.BOOKS) {
            if ((book.getBookTitle().toLowerCase().contains(query.toLowerCase())) || (book.getBookAuthor().toLowerCase().contains(query.toLowerCase()))) {
                booksFound.add(book);
            }
        }

        return booksFound;
    }

    //Menu de libros
    public int bookMenu(final User USER_LOGGED) {
        int option;
        System.out.println("\n------------------------- MENU ------------------------");
        System.out.println("\t-> [1] Lista de libros");
        if (USER_LOGGED.isUserAdmin()) {
            System.out.println("\t-> [2] Agregar libro");
            System.out.println("\t-> [3] Eliminar libro");
            System.out.println("\t-> [4] Buscar libro");
            System.out.println("\t-> [5] Volver al principal");
            option = this.SCANNER.nextInt();
            System.out.println("-------------------------------------------------------");
            switch (option) {
                case 1:
                    if (this.BOOKS.isEmpty()) {
                        System.out.println("\n\t<Ningún libro disponible>");
                    } else {
                        System.out.println();
                        for (Book book : this.BOOKS) {
                            System.out.println(book.toString());
                        }
                    }
                    break;
                case 2:
                    //generamos id de acuerdo a la cantidad de libros
                    final int id = this.BOOKS.size() + 1;
                    //esta es una linea problematica para evitar saltar el siguiente parametro, es necesario pero omitir
                    this.SCANNER.nextLine();
                    System.out.println("Ingrese título: ");
                    final String TITLE = this.SCANNER.nextLine();
                    System.out.println("Ingrese autor: ");
                    final String AUTHOR = this.SCANNER.nextLine();
                    System.out.println("Ingrese ISBN: ");
                    final String ISBN = this.SCANNER.nextLine();
                    //Por defecto al registrar el libro va a estar disponible
                    final Book NEW_BOOK = new Book(id, TITLE, ISBN, AUTHOR, true);
                    this.addBook(NEW_BOOK);
                    break;
                case 3:
                    //delete book
                    break;
                case 4:
                    this.SCANNER.nextLine();
                    System.out.println("Ingrese búsqueda: ");
                    final String QUERY = this.SCANNER.nextLine();
                    final List<Book> BOOKS_RESULT = this.searchBook(QUERY);
                    System.out.println("-------------------------------------------------------");
                    if (BOOKS_RESULT.isEmpty()) {
                        System.out.println("\n\t<Ningún libro disponible>");
                    } else {
                        System.out.println();
                        for (Book book : BOOKS_RESULT) {
                            System.out.println(book.toString());
                        }
                    }
                    break;
                case 5:
                    return option;
                default:
                    System.out.println("** Opción no válida **");
                    break;
            }
        } else {
            System.out.println("\t-> [2] Buscar libro");
            System.out.println("\t-> [3] Prestar");
            System.out.println("\t-> [4] Volver al principal");
            option = this.SCANNER.nextInt();
            System.out.println("-------------------------------------------------------");
            switch (option) {
                case 1:
                    if (this.BOOKS.isEmpty()) {
                        System.out.println("\n\t<Ningún libro disponible>");
                    } else {
                        System.out.println();
                        for (Book book : this.BOOKS) {
                            System.out.println(book.toString());
                        }
                    }
                    break;
                case 2:
                    this.SCANNER.nextLine();
                    System.out.println("Ingrese búsqueda: ");
                    final String QUERY = this.SCANNER.nextLine();
                    final List<Book> BOOKS_RESULT = this.searchBook(QUERY);
                    System.out.println("-------------------------------------------------------");
                    if (BOOKS_RESULT.isEmpty()) {
                        System.out.println("\n\t<Ningún libro disponible>");
                    } else {
                        System.out.println();
                        for (Book book : BOOKS_RESULT) {
                            System.out.println(book.toString());
                        }
                    }
                    break;
                case 3:
                    //lend book
                    break;
                case 4:
                    return 5;
                default:
                    System.out.println("** Opción no válida **");
                    break;
            }
        }
        return option;
    }
}
