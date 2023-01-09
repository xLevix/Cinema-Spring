package com.kino.springjwt.DTO;

public class NewReservation {

    private Integer id;
    private String name;
    private String lastName;
    private UserDTO userId;
    private Integer seatNumber;
    private Integer idScreening;

    public NewReservation() {
    }

    public NewReservation(Integer id, String name, String lastName, UserDTO userId, Integer seatNumber, Integer idScreening) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.userId = userId;
        this.seatNumber = seatNumber;
        this.idScreening = idScreening;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserDTO getUserId() {
        return userId;
    }

    public void setUserId(UserDTO userId) {
        this.userId = userId;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getIdScreening() {
        return idScreening;
    }

    public void setIdScreening(Integer idScreening) {
        this.idScreening = idScreening;
    }
}
