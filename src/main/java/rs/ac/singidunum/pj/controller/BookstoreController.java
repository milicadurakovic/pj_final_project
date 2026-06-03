package rs.ac.singidunum.pj.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import jakarta.websocket.server.PathParam;
import rs.ac.singidunum.pj.entity.Bookstore;
import rs.ac.singidunum.pj.repo.BookstoreRepository;
import rs.ac.singidunum.pj.service.BookstoreService;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api/bookstore")
@RequiredArgsConstructor

public class BookstoreController {

    private final BookstoreService service;

    @GetMapping
    public List<Bookstore> getBookstores(){
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Bookstore> getBookById(@PathVariable Integer id){
        return ResponseEntity.of(service.getById(id));
    }
    
    @PostMapping
    public Bookstore createBookstore(@RequestBody Bookstore entity){
        return service.create(entity);
    }

    @PutMapping(path = "/{id}")
    public Bookstore updateBookstore(@PathVariable Integer id, @RequestBody Bookstore entity){
        return service.update(id,entity);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBookstoreById(@PathVariable Integer id){
        service.deleteById(id);
    }
    

}
