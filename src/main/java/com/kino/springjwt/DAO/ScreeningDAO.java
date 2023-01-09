package com.kino.springjwt.DAO;

import com.kino.springjwt.DTO.ScreeningDTO;
import com.kino.springjwt.entity.Screening;
import com.kino.springjwt.service.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningDAO {

    private final ScreeningRepository screeningRepository;

    public ScreeningDAO(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }

    public ScreeningDTO getScreeningById(Integer id) {
        return new ScreeningDTO(screeningRepository.findById(id).get());
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

}
