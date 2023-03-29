package com.kino.springjwt.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESERVATION", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "ID_SCREENING")
    private Screening idScreening;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User userId;

    @Column(name = "SEAT_NUMBER")
    private Integer seatNumber;

    public Reservation() {
    }

}