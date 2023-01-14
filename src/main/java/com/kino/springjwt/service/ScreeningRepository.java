package com.kino.springjwt.service;

import com.kino.springjwt.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {

    List<Screening> findAllByIdMovieId(Integer id);

    Optional<Screening> findById(Integer id);
}
