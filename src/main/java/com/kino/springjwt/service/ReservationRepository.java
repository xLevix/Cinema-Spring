package com.kino.springjwt.service;

import com.kino.springjwt.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findAllByIdScreeningId(Integer id);

    List<Reservation> findAllByUserIdId(Long userId_id);

}
