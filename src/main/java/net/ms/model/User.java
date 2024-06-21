package net.ms.model;

public class User {
    private String userName;
    private String userPassword;
    private boolean userAdmin;

    public User(String userName, String userPassword, boolean userAdmin) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAdmin = userAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(boolean userAdmin) {
        this.userAdmin = userAdmin;
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "nombre='" + userName + '\'' +
                ", contraseña='" + userPassword.replace("", "*") + '\'' +
                ", admin=" + userAdmin +
                '}';
    }
}
