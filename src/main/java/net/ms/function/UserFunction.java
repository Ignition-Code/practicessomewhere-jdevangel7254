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
        for (User user: USERS) {
            if (user.getUserName().equals(USERNAME) && user.getUserPassword().equals(PASSWORD)) {
                return user;
            }
        }
        return null;
    }

    //Registrar un usuario
    public void userRegister(final String USERNAME, final String PASSWORD, final boolean ADMIN) {
        this.USERS.add(new User(USERNAME, PASSWORD, ADMIN));
    }

    //Menu de usuario
    public int userMenu(final User userLogged) {
        int option;
        System.out.println("\n------------------------- MENU ------------------------");
        if (userLogged.isUserAdmin()) {
            System.out.println("\t-> [1] Perfil");
            System.out.println("\t-> [2] Lista de usuarios");
            System.out.println("\t-> [3] Agregar usuario");
            System.out.println("\t-> [4] Eliminar usuario");
            System.out.println("\t-> [5] Salir");
            option = this.SCANNER.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Nombre de usuario: \t" + userLogged.getUserName());
                    System.out.println("Contraseña: \t\t" + userLogged.getUserPassword().replace("", "*"));
                    break;
                case 2:
                    System.out.println("-------------------------------------------------------");
                    if (this.USERS.isEmpty()) {
                        System.out.println("\n\t<Ningún usuario disponible>");
                    } else {
                        System.out.println();
                        for (User user : this.USERS) {
                            System.out.println(user.toString());
                        }
                    }
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    return option;
                default:
                    System.out.println("** Opción no válida **");
                    break;
            }
        } else {
            System.out.println("\t-> [1] Perfil");
            System.out.println("\t-> [2] Salir");
            option = this.SCANNER.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Nombre de usuario: \t" + userLogged.getUserName());
                    System.out.println("Contraseña: \t\t" + userLogged.getUserPassword().replace("", "*"));
                    break;
                case 2:
                    return 5;
                default:
                    System.out.println("** Opción no válida **");
                    break;
            }
        }

        return option;
    }
}
