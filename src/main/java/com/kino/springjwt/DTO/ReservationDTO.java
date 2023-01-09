package com.kino.springjwt.DTO;

import com.kino.springjwt.entity.Reservation;

public class ReservationDTO {
    private Integer id;
    private ScreeningDTO idScreening;
    private String name;
    private String lastName;
    private UserDTO userId;
    private Integer seatNumber;

    public ReservationDTO() {
    }

    public ReservationDTO(Integer id, ScreeningDTO idScreening, String name, String lastName, UserDTO userId, Integer seatNumber) {
        this.id = id;
        this.idScreening = idScreening;
        this.name = name;
        this.lastName = lastName;
        this.userId = userId;
        this.seatNumber = seatNumber;
    }

    public ReservationDTO(Reservation reservation) {
        this.id = reservation.getId();
        this.idScreening = new ScreeningDTO(reservation.getIdScreening());
        this.name = reservation.getName();
        this.lastName = reservation.getLastName();
        this.userId = new UserDTO(reservation.getUserId());
        this.seatNumber = reservation.getSeatNumber();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ScreeningDTO getIdScreening() {
        return idScreening;
    }

    public void setIdScreening(ScreeningDTO idScreening) {
        this.idScreening = idScreening;
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
}
