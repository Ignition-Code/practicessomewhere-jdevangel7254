package net.ms.main;

import net.ms.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner SCANNER = new Scanner(System.in);
        int option = 0;

        final List<Book> BOOKS = new ArrayList<>();

        System.out.println("=======================================================");
        System.out.println("=== BIENVENIDO AL SISTEMA DE GESTION DE BIBLIOTECAS ===");
        System.out.println("=======================================================");
        while (option != 4) {
            System.out.println("\n------------------------- MENU ------------------------");
            System.out.println("\t-> [1] Lista de libros disponibles");
            System.out.println("\t-> [2] Agregar libro");
            System.out.println("\t-> [3] Buscar libro");
            System.out.println("\t-> [4] Salir");
            option = SCANNER.nextInt();

            switch (option) {
                case 1:
                    System.out.println("-------------------------------------------------------");
                    if (BOOKS.isEmpty()) {
                        System.out.println("\n\t<Ningún libro disponible>");
                    } else {
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
                    final Book newBook = new Book(id, TITLE, ISBN, AUTHOR, true);
                    BOOKS.add(newBook);
                    break;
                default:
                    System.out.println("** Opción no válida **");
            }
        }
        SCANNER.close();
    }
}
