package com.kino.springjwt.DTO;

import com.kino.springjwt.entity.User;

public class UserDTO {
    private Integer id;
    private String username;
    private String email;

    public UserDTO() {
    }

    public UserDTO(Integer id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public UserDTO(User userId) {
        this.id = Math.toIntExact(userId.getId());
        this.username = userId.getUsername();
        this.email = userId.getEmail();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
