package rs.ac.singidunum.pj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rs.ac.singidunum.pj.entity.Bookstore;
import rs.ac.singidunum.pj.entity.Reservation;
import rs.ac.singidunum.pj.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService service;

    @GetMapping
    public List<Reservation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getById(id));
    }

    @PostMapping
    public Reservation create(@RequestBody Reservation entity) {
        return service.create(entity);
    }

    
    @PutMapping(path = "/{id}")
    public Reservation update(@PathVariable Integer id, @RequestBody Reservation entity) {
        return service.update(id, entity);
    }

    

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}