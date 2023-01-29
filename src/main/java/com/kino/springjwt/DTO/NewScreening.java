package com.kino.springjwt.DTO;

import java.sql.Timestamp;

public class NewScreening {

    private Integer id;
    private Integer idMovie;
    private Timestamp date;
    private Double price;
    private Integer seats;


    public NewScreening(){

    }

    public NewScreening(Integer id, Integer idMovie, Timestamp date, Double price, Integer seats) {
        this.id = id;
        this.idMovie = idMovie;
        this.date = date;
        this.price = price;
        this.seats = seats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

}
