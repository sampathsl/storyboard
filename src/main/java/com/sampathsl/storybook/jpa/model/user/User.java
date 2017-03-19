package com.sampathsl.storybook.jpa.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sampathsl.storybook.jpa.model.BaseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

/**
 * Created by SAMPATH on 3/19/2017.
 */
@Entity
public class User extends BaseEntity {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private String firstName;
    private String lastName;
    private String userName;
    @JsonIgnore
    private String passWord;
    @JsonIgnore
    private String[] roles;

    protected User() {
        super();
    }

    public User(String firstName, String lastName, String userName, String passWord, String[] roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        setPassword(passWord);
        this.roles = roles;
    }

    public void setPassword(String passWord) {
        this.passWord = PASSWORD_ENCODER.encode(passWord);
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
