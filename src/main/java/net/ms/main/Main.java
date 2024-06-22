package net.ms.main;

import net.ms.function.BookFunction;
import net.ms.function.UserFunction;
import net.ms.model.Book;
import net.ms.model.User;
import net.ms.util.Constants;
import net.ms.util.Constants.MENU;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int option = 0;

        //Nivel de acceso por defecto es usuario
        Constants.MENU currentMenu = Constants.MENU.USER;
        //Usuario conectado por defecto es null
        User userConnected = null;

        final List<Book> BOOKS = new ArrayList<>();
        final Scanner SCANNER = new Scanner(System.in);
        final List<User> USERS = new ArrayList<>();
        //Asignamos usuario por defecto
        USERS.add(new User(1, "admin", "", true));

        //Funciones
        final UserFunction USER_FUNCTIONS = new UserFunction(USERS, SCANNER);
        final BookFunction BOOK_FUNCTIONS = new BookFunction(BOOKS, SCANNER);

        System.out.println("=======================================================");
        System.out.println("=== BIENVENIDO AL SISTEMA DE GESTION DE BIBLIOTECAS ===");
        System.out.println("=======================================================");
        while (option != 8) {
            if (userConnected == null) {
                System.out.println("\n------------------------- MENU ------------------------");
                System.out.println("\t-> [1] Iniciar sesión");
                System.out.println("\t-> [2] Salir");
                option = SCANNER.nextInt();
                if (option == 1) {
                    System.out.println("-------------------- INICIAR SESIÓN -------------------");
                    SCANNER.nextLine();
                    System.out.println("Nombre de usuario: ");
                    final String USERNAME = SCANNER.nextLine();
                    System.out.println("Contraseña: ");
                    final String PASSWORD = SCANNER.nextLine();
                    userConnected = USER_FUNCTIONS.login(USERNAME, PASSWORD);
                    if (userConnected == null) {
                        System.out.println("-------------------------------------------------------");
                        System.out.println("\n\t<Credenciales incorrectas!>");
                    }
                }
            } else {
                option = switch (currentMenu) {
                    case USER -> USER_FUNCTIONS.userMenu(userConnected);
                    case BOOK -> BOOK_FUNCTIONS.bookMenu(userConnected);
                };

                if (currentMenu == MENU.USER && option == 6) {
                    currentMenu = MENU.BOOK;
                } else if (currentMenu == MENU.BOOK && option == 5) {
                    currentMenu = MENU.USER;
                } else if (option == 7) {
                    userConnected = null;
                }
                /*switch (option) {
                    case 1:
                        System.out.println("-------------------------------------------------------");
                        if (BOOKS.isEmpty()) {
                            System.out.println("\n\t<Ningún libro disponible>");
                        } else {
                            System.out.println();
                            for (Book book : BOOKS) {
                                System.out.println(book.toString());
                            }
                        }
                        break;
                    case 2:
                        //generamos id de acuerdo a la cantidad de libros
                        final int id = BOOKS.size() + 1;
                        //esta es una linea problematica para evitar saltar el siguiente parametro, es necesario pero omitir
                        SCANNER.nextLine();
                        System.out.println("Ingrese título: ");
                        final String TITLE = SCANNER.nextLine();
                        System.out.println("Ingrese autor: ");
                        final String AUTHOR = SCANNER.nextLine();
                        System.out.println("Ingrese ISBN: ");
                        final String ISBN = SCANNER.nextLine();
                        //Por defecto al registrar el libro va a estar disponible
                        final Book NEW_BOOK = new Book(id, TITLE, ISBN, AUTHOR, true);
                        new BookFunction(BOOKS).addBook(NEW_BOOK);
                        break;
                    case 3:
                        SCANNER.nextLine();
                        System.out.println("Ingrese búsqueda: ");
                        final String QUERY = SCANNER.nextLine();
                        final List<Book> BOOKS_RESULT = new BookFunction(BOOKS).searchBook(QUERY);
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
                    default:
                        System.out.println("** Opción no válida **");
                }*/
            }
        }
        SCANNER.close();
    }
}
