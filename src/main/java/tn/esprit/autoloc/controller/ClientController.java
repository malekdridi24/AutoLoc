package tn.esprit.autoloc.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService service;
    public ClientController(ClientService service) { this.service = service; }
    @GetMapping public List<Client> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<Client> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping public ResponseEntity<Client> create(@RequestBody Client entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }
    @PutMapping("/{id}") public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client entity) {
        try { return ResponseEntity.ok(service.update(id, entity)); }
        catch (NoSuchElementException ex) { return ResponseEntity.notFound().build(); }
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        try { service.delete(id); return ResponseEntity.noContent().build(); }
        catch (NoSuchElementException ex) { return ResponseEntity.notFound().build(); }
    }
}
