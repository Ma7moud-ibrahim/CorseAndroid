package com.clinics.clinics.models;

public class AuthModel {
    final int id ;
    final String username;
    final String password;
    final String userValidity;

    public AuthModel(int id, String username,String password, String userValidity) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userValidity = userValidity;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public String getUserValidity() {
        return userValidity;
    }
}
