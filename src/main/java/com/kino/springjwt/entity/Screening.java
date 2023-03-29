package com.kino.springjwt.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
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
}