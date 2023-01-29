package com.kino.springjwt.DAO;

import com.kino.springjwt.DTO.NewScreening;
import com.kino.springjwt.DTO.ScreeningDTO;
import com.kino.springjwt.entity.Screening;
import com.kino.springjwt.service.MovieRepository;
import com.kino.springjwt.service.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningDAO {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;

    public ScreeningDAO(ScreeningRepository screeningRepository, MovieRepository movieRepository) {
        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
    }

    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }

    public Screening getScreeningById(Integer id) {
        return screeningRepository.findById(id).get();
    }

    public Screening save(Screening screening) {
        return screeningRepository.save(screening);
    }

    public void delete(Integer id) {
        screeningRepository.deleteById(id);
    }

    public long countScreenings() {
        return screeningRepository.count();
    }

    public List<ScreeningDTO> getScreeningByFilmyId(Integer id) {
        return screeningRepository.findAllByIdMovieId(id).stream().map(ScreeningDTO::new).collect(java.util.stream.Collectors.toList());
    }

    public void addScreening(NewScreening newScreening) {
        Screening screening = new Screening();
        screening.setIdMovie(movieRepository.findById(newScreening.getIdMovie()).get());
        screening.setDate(newScreening.getDate());
        screening.setPrice(newScreening.getPrice());
        screening.setSeats(newScreening.getSeats());
        screeningRepository.save(screening);
    }

}
