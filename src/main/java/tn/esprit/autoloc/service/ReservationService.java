package tn.esprit.autoloc.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.autoloc.domain.Reservation;

public interface ReservationService {
    List<Reservation> findAll();
    Optional<Reservation> findById(Long id);
    Reservation create(Reservation entity);
    Reservation update(Long id, Reservation entity);
    void delete(Long id);
}
