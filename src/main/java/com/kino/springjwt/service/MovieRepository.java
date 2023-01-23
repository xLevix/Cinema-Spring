package com.kino.springjwt.service;

import com.kino.springjwt.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Optional<Movie> findById(Integer id);

    Optional<Movie> findAllByNameContainingIgnoreCase(String word);
}
