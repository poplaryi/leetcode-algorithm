package com.yangyi.code.data;

/**
 * @author kcyangyi@gmail.com
 */

public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
