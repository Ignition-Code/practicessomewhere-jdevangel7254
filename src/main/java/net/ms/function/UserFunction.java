package net.ms.function;

import net.ms.model.User;

import java.util.List;
import java.util.Scanner;

public class UserFunction {
    private final List<User> USERS;
    private final Scanner SCANNER;

    public UserFunction(final List<User> USERS, final Scanner SCANNER) {
        this.USERS = USERS;
        this.SCANNER = SCANNER;
    }

    //Verificar credenciales
    public User login(final String USERNAME, final String PASSWORD) {
        for (User user : USERS) {
            if (user.getUserName().equals(USERNAME) && user.getUserPassword().equals(PASSWORD)) {
                return user;
            }
        }
        return null;
    }

    //Registrar un usuario
    public void userRegister(final int ID, final String USERNAME, final String PASSWORD, final boolean ADMIN) {
        this.USERS.add(new User(ID, USERNAME, PASSWORD, ADMIN));
    }

    //Menu de usuario
    public int userMenu(final User USER_LOGGED) {

        int option;
        System.out.println("\n------------------------- MENU ------------------------");
        System.out.println("\t-> [1] Perfil");
        System.out.println("\t-> [2] Cambiar contraseña");
        if (USER_LOGGED.isUserAdmin()) {
            System.out.println("\t-> [3] Lista de usuarios");
            System.out.println("\t-> [4] Agregar usuario");
            System.out.println("\t-> [5] Eliminar usuario");
            System.out.println("\t-> [6] Libros");
            System.out.println("\t-> [7] Cerrar sesión");
            System.out.println("\t-> [8] Salir");
            option = this.SCANNER.nextInt();
            System.out.println("-------------------------------------------------------");
            switch (option) {
                case 1:
                    System.out.println("\nNombre de usuario: \t" + USER_LOGGED.getUserName());
                    System.out.println("Contraseña: \t\t" + (USER_LOGGED.getUserPassword().isEmpty() ? "*" : USER_LOGGED.getUserPassword().replaceAll(".", "*")));
                    break;
                case 2:
                    this.SCANNER.nextLine();
                    System.out.println("Ingrese contraseña anterior:");
                    final String OLD_PASSWORD = this.SCANNER.nextLine();
                    System.out.println("Ingrese contraseña nueva:");
                    final String NEW_PASSWORD = this.SCANNER.nextLine();
                    if (OLD_PASSWORD.equals(USER_LOGGED.getUserPassword())) {
                        USER_LOGGED.setUserPassword(NEW_PASSWORD);
                        for (int i = 0; i < this.USERS.size(); i++){
                            if (this.USERS.get(i).getUserID() == USER_LOGGED.getUserID()){
                                this.USERS.set(i, USER_LOGGED);
                                break;
                            }
                        }
                    } else {
                        System.out.println("\n\t<Credenciales incorrectas!>");
                    }
                    break;
                case 3:
                    if (this.USERS.isEmpty()) {
                        System.out.println("\n\t<Ningún usuario disponible>");
                    } else {
                        System.out.println();
                        for (User user : this.USERS) {
                            System.out.println(user.toString());
                        }
                    }
                    break;
                case 4:
                    //generamos id de acuerdo a la cantidad de usuarios
                    final int ID = this.USERS.size() + 1;
                    SCANNER.nextLine();
                    System.out.println("Nombre de usuario: ");
                    final String USERNAME = SCANNER.nextLine();
                    System.out.println("Contraseña: ");
                    final String PASSWORD = SCANNER.nextLine();
                    System.out.println("Administrador? [S] o [N]");
                    final boolean ADMIN = SCANNER.nextLine().equalsIgnoreCase("s");
                    userRegister(ID, USERNAME, PASSWORD, ADMIN);
                    break;
                case 5:
                    System.out.println("Seleccionar usuario a eliminar [ ]");
                    final int SIZE = this.USERS.size();
                    for (int i = 0; i < SIZE; i++) {
                        System.out.println("\t[" + i + "] " + this.USERS.get(i));
                    }
                    final int INDEX = this.SCANNER.nextInt();
                    System.out.println("-------------------------------------------------------");
                    if (INDEX == 0) {
                        System.out.println("\n\t<No es posible eliminar al usuario administrador principal>");
                    } else if (INDEX >= SIZE || INDEX < 0) {
                        System.out.println("** Opción no válida **");
                    } else {
                        System.out.println("Usuario eliminado: " + this.USERS.get(INDEX));
                        this.USERS.remove(INDEX);
                    }
                    break;
                case 6, 7, 8:
                    return option;
                default:
                    System.out.println("** Opción no válida **");
                    break;
            }
        } else {
            System.out.println("\t-> [3] Libros");
            System.out.println("\t-> [4] Cerrar sesión");
            System.out.println("\t-> [5] Salir");
            option = this.SCANNER.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\nNombre de usuario: \t" + USER_LOGGED.getUserName());
                    System.out.println("Contraseña: \t\t" + (USER_LOGGED.getUserPassword().isEmpty() ? "*" : USER_LOGGED.getUserPassword().replaceAll(".", "*")));
                    break;
                case 2:
                    this.SCANNER.nextLine();
                    System.out.println("Ingrese contraseña anterior:");
                    final String OLD_PASSWORD = this.SCANNER.nextLine();
                    System.out.println("Ingrese contraseña nueva:");
                    final String NEW_PASSWORD = this.SCANNER.nextLine();
                    if (OLD_PASSWORD.equals(USER_LOGGED.getUserPassword())) {
                        USER_LOGGED.setUserPassword(NEW_PASSWORD);
                        for (int i = 0; i < this.USERS.size(); i++){
                            if (this.USERS.get(i).getUserID() == USER_LOGGED.getUserID()){
                                this.USERS.set(i, USER_LOGGED);
                                break;
                            }
                        }
                    } else {
                        System.out.println("\n\t<Credenciales incorrectas!>");
                    }
                    break;
                case 3:
                    return 5;
                case 4:
                    return 7;
                case 5:
                    return 8;
                default:
                    System.out.println("** Opción no válida **");
                    break;
            }
        }

        return option;
    }
}
