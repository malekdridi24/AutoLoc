package tn.esprit.autoloc.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.VehiculeService;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {
    private final VehiculeService service;
    public VehiculeController(VehiculeService service) { this.service = service; }
    @GetMapping public List<Vehicule> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<Vehicule> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping public ResponseEntity<Vehicule> create(@RequestBody Vehicule entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }
    @PutMapping("/{id}") public ResponseEntity<Vehicule> update(@PathVariable Long id, @RequestBody Vehicule entity) {
        try { return ResponseEntity.ok(service.update(id, entity)); }
        catch (NoSuchElementException ex) { return ResponseEntity.notFound().build(); }
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        try { service.delete(id); return ResponseEntity.noContent().build(); }
        catch (NoSuchElementException ex) { return ResponseEntity.notFound().build(); }
    }
}
