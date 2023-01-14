package com.driver.RequestDto;

public class UserDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public UserDto(String username,String password,String firstName,String lastName) {
        this.username = username;
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
    }

    public UserDto() {
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

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
