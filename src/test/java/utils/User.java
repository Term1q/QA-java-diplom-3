package utils;

import java.util.UUID;

public class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static User getRandomUser() {
        String name = "user" + UUID.randomUUID().toString().substring(0, 8);
        String email = name + "@yandex.ru";
        String password = "password" + UUID.randomUUID().toString().substring(0, 8);
        return new User(name, email, password);
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}