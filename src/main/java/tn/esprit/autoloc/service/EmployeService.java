package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor

public class EmployeService implements IEmployeService{

    EmployeRepository employeRepository;

    @Override
    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    @Override
    public Optional<Employe> findById(Long id) {
        return employeRepository.findById(id);
    }

    @Override
    public Employe create(Employe entity) {
        return employeRepository.save(entity);
    }

    @Override
    public Employe update(Long id, Employe entity) {
        return employeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        employeRepository.deleteById(id);
    }
}
