package com.kino.springjwt.DAO;

import com.kino.springjwt.DTO.MovieDTO;
import com.kino.springjwt.entity.Movie;
import com.kino.springjwt.service.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieDAO {

    private final MovieRepository movieRepository;

    public MovieDAO(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream().map(MovieDTO::new).collect(java.util.stream.Collectors.toList());
    }

    public MovieDTO getMovieById(Integer id) {
        return new MovieDTO(movieRepository.findById(id).get());
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public void delete(Integer id) {
        movieRepository.deleteById(id);
    }


    public void addMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setDescription(movieDTO.getDescription());
        movie.setName(movieDTO.getName());
        movie.setImage(movieDTO.getImage());
        movie.setPegi(movieDTO.getPegi());
        movie.setRating(movieDTO.getRating());
        movieRepository.save(movie);
    }

    public List<MovieDTO> getMoviesByWord(String word) {
        return movieRepository.findAllByNameContainingIgnoreCase(word).map(MovieDTO::new).stream().collect(Collectors.toList());
    }
}
