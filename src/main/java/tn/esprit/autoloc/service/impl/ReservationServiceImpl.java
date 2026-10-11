package tn.esprit.autoloc.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;
import tn.esprit.autoloc.service.ReservationService;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository repository;
    public ReservationServiceImpl(ReservationRepository repository) { this.repository = repository; }
    @Override @Transactional(readOnly = true)
    public List<Reservation> findAll() { return repository.findAll(); }
    @Override @Transactional(readOnly = true)
    public Optional<Reservation> findById(Long id) { return repository.findById(id); }
    @Override public Reservation create(Reservation entity) { return repository.save(entity); }
    @Override public Reservation update(Long id, Reservation entity) {
        if (!repository.existsById(id)) throw new NoSuchElementException("Reservation introuvable avec id : " + id);
        entity.setIdReservation(id);
        return repository.save(entity);
    }
    @Override public void delete(Long id) {
        if (!repository.existsById(id)) throw new NoSuchElementException("Reservation introuvable avec id : " + id);
        repository.deleteById(id);
    }
}
