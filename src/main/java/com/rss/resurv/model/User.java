package com.rss.resurv.model;

import jakarta.persistence.*;

@MappedSuperclass
//@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    // autoincrement Long primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    // entity attributes
    @Column(nullable = false, length = 30, name = "firstName")
    private String firstName;

    @Column(nullable = false, length = 30, name = "lastName")
    private String lastName;

    @Column(nullable = false, length = 60, name = "password")
    private String password;

    @Column(nullable = false, unique = true, length = 320, name = "email")
    private String email;

    public User(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public User() {

    }

    // getters and setters
    public Long getUser_id() { return user_id; }

    public void setUser_id(Long userId) { this.user_id = userId; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
