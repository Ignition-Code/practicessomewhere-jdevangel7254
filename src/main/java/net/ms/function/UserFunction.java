package net.ms.function;

import net.ms.model.User;

import java.util.List;

public class UserFunction {
    private final List<User> USERS;

    public UserFunction(List<User> USERS) {
        this.USERS = USERS;
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
}
