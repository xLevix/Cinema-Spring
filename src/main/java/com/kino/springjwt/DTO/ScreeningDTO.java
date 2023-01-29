package com.kino.springjwt.DTO;

import com.kino.springjwt.entity.Screening;

import java.sql.Timestamp;

public class ScreeningDTO {

    private Integer id;
    private MovieDTO idMovie;
    private Double price;
    private Timestamp date;
    private Integer seats;

    public ScreeningDTO(){

    }

    public ScreeningDTO(Integer id, MovieDTO idMovie, Double price, Timestamp date, Integer seats) {
        this.id = id;
        this.idMovie = idMovie;
        this.price = price;
        this.date = date;
        this.seats = seats;
    }

    public ScreeningDTO(Screening screening) {
        this.id = screening.getId();
        this.idMovie = new MovieDTO(screening.getIdMovie());
        this.price = screening.getPrice();
        this.date = screening.getDate();
        this.seats = screening.getSeats();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MovieDTO getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(MovieDTO idMovie) {
        this.idMovie = idMovie;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
