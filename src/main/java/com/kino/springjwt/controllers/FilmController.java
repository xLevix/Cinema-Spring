package com.kino.springjwt.controllers;

import com.kino.springjwt.DAO.MovieDAO;
import com.kino.springjwt.DAO.ReservationDAO;
import com.kino.springjwt.DAO.ScreeningDAO;
import com.kino.springjwt.DAO.UserDAO;
import com.kino.springjwt.DTO.MovieDTO;
import com.kino.springjwt.DTO.NewReservation;
import com.kino.springjwt.DTO.ReservationDTO;
import com.kino.springjwt.DTO.ScreeningDTO;
import com.kino.springjwt.entity.Reservation;
import com.kino.springjwt.entity.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FilmController {

    private final MovieDAO movieDAO;
    private final ScreeningDAO screeningDAO;
    private final ReservationDAO reservationDAO;
    private final UserDAO userDAO;

    @Autowired
    public FilmController(MovieDAO movieDAO, ScreeningDAO screeningDAO, ReservationDAO reservationDAO, UserDAO userDAO) {
        this.movieDAO = movieDAO;
        this.screeningDAO = screeningDAO;
        this.reservationDAO = reservationDAO;
        this.userDAO = userDAO;
    }

    @GetMapping("/filmy")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<MovieDTO> getMovies() {
        return movieDAO.getAllMovies();
    }

    @GetMapping("/filmy/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public MovieDTO getMovie(@PathVariable("id") int id) {
        return movieDAO.getMovieById(id);
    }

    @GetMapping("/filmy/{id}/seanse")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<ScreeningDTO> getSeansebyFilm(@PathVariable("id") int id) {
        return screeningDAO.getScreeningByFilmyId(id);
    }

    @PostMapping("/filmy/add")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void addMovie(@RequestBody MovieDTO movieDTO) {
        movieDAO.addMovie(movieDTO);
    }

    @GetMapping("/seanse/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Screening getScreening(@PathVariable("id") int id) {
        return screeningDAO.getScreeningById(id);
    }

    @GetMapping("/seanse/{id}/rezerwacje")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<ReservationDTO> getReservationsByScreening(@PathVariable("id") int id) {
        return reservationDAO.getReservationsByScreening(id);
    }

    @PostMapping("/rezerwacja/add")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void addReservation(@RequestBody NewReservation newReservation) {
        Reservation reservation = new Reservation();
        reservation.setName(newReservation.getName());
        reservation.setLastName(newReservation.getLastName());
        reservation.setSeatNumber(newReservation.getSeatNumber());
        reservation.setIdScreening(screeningDAO.getScreeningById(newReservation.getIdScreening()));
        reservation.setUserId(userDAO.findById(newReservation.getUserId()));
        reservationDAO.save(reservation);
    }

    @GetMapping("/rezerwacje/user/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<ReservationDTO> getReservationsByUser(@PathVariable("id") int id) {
        return reservationDAO.getReservationsByUser(id);
    }


    //search film by contain word
    @GetMapping("/filmy/search/{word}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<MovieDTO> getMoviesByWord(@PathVariable("word") String word) {
        return movieDAO.getMoviesByWord(word);
    }

}
