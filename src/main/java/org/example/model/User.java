package org.example.model;

public class User {
    private final String userId;
    private final String name;
    private final String phone;

    public User(String userId, String name, String phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getPhone() {
        return phone;
    }
}
