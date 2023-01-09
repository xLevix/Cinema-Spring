package com.kino.springjwt.controllers;

import com.kino.springjwt.DAO.MovieDAO;
import com.kino.springjwt.DAO.ReservationDAO;
import com.kino.springjwt.DAO.ScreeningDAO;
import com.kino.springjwt.DTO.MovieDTO;
import com.kino.springjwt.DTO.ReservationDTO;
import com.kino.springjwt.DTO.ScreeningDTO;
import com.kino.springjwt.entity.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FilmController {

    private final MovieDAO movieDAO;
    private final ScreeningDAO screeningDAO;
    private final ReservationDAO reservationDAO;

    @Autowired
    public FilmController(MovieDAO movieDAO, ScreeningDAO screeningDAO, ReservationDAO reservationDAO) {
        this.movieDAO = movieDAO;
        this.screeningDAO = screeningDAO;
        this.reservationDAO = reservationDAO;
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
    public ScreeningDTO getScreening(@PathVariable("id") int id) {
        return screeningDAO.getScreeningById(id);
    }

    @GetMapping("/seanse/{id}/rezerwacje")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<ReservationDTO> getReservationsByScreening(@PathVariable("id") int id) {
        return reservationDAO.getReservationsByScreening(id);
    }





}
