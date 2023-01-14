package com.kino.springjwt.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SCREENING")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SCREENING", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_MOVIE")
    private Movie idMovie;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "DATE")
    private Timestamp date;

    @Column(name = "SEATS")
    private Integer seats;

    public Screening(Screening screening) {
    }

    public Screening() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Movie idMovie) {
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