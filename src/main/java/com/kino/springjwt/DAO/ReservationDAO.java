package com.kino.springjwt.DAO;

import com.kino.springjwt.DTO.NewReservation;
import com.kino.springjwt.DTO.ReservationDTO;
import com.kino.springjwt.entity.Reservation;
import com.kino.springjwt.service.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationDAO {

    private final ReservationRepository reservationRepository;
    private ScreeningDAO screeningDAO;
    private UserDAO userDAO;

    public ReservationDAO(ReservationRepository reservationRepository, ScreeningDAO screeningDAO) {
        this.reservationRepository = reservationRepository;
        this.screeningDAO = screeningDAO;
    }

    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream().map(ReservationDTO::new).collect(java.util.stream.Collectors.toList());
    }

    public ReservationDTO getReservationById(Integer id) {
        return new ReservationDTO(reservationRepository.findById(id).get());
    }

    public void add(NewReservation newReservation) {
        Reservation reservation = new Reservation();
        reservation.setName(newReservation.getName());
        reservation.setLastName(newReservation.getLastName());
        reservation.setUserId(userDAO.findById(newReservation.getUserId().getId()));
        reservation.setSeatNumber(newReservation.getSeatNumber());
        //reservation.setIdScreening(screeningDAO.getScreeningById(newReservation.getIdScreening()));
        reservationRepository.save(reservation);
    }

    public void delete(Integer id) {
        reservationRepository.deleteById(id);
    }

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public List<Integer> getTakenSeatsByIdScreening(Integer idScreening) {
        return reservationRepository.findAllByIdScreeningId(idScreening).stream().map(Reservation::getSeatNumber).collect(java.util.stream.Collectors.toList());
    }

    public List<Reservation> getReservationsByIdScreening(Integer idScreening) {
        return reservationRepository.findAllByIdScreeningId(idScreening);
    }

    public List<ReservationDTO> getReservationsByScreening(int id) {
        return reservationRepository.findAllByIdScreeningId(id).stream().map(ReservationDTO::new).collect(java.util.stream.Collectors.toList());
    }
}
