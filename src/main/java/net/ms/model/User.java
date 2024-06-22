package net.ms.model;

public class User {
    private int userID;
    private String userName;
    private String userPassword;
    private boolean userAdmin;

    public User(int userID, String userName, String userPassword, boolean userAdmin) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAdmin = userAdmin;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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
                "ID=" + userID +
                ", Nombre='" + userName + '\'' +
                ", contraseña='" + (userPassword.isEmpty() ? "*" : userPassword.replaceAll(".", "*")) + '\'' +
                ", Admin=" + userAdmin +
                '}';
    }
}
