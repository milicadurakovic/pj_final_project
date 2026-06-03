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

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api/bookstore")
@RequiredArgsConstructor

public class BookstoreController {

    private final BookstoreRepository repository;

    @GetMapping
    public List<Bookstore> getBookstore(){
        return repository.findAllByDeletedAtIsNull();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Bookstore> getBookById(@PathVariable Integer id){
        return ResponseEntity.of(repository.findOneByBookstoreIdAndDeletedAtIsNull(id));
    }
    
    @PostMapping
    public Bookstore createBookstore(@RequestBody Bookstore entity){
        Bookstore bookstore =new Bookstore();
        bookstore.setName(entity.getName());
        bookstore.setAdress(entity.getAdress());
        bookstore.setCreatedAt(LocalDateTime.now());
        return repository.save(bookstore);
    }

    @PutMapping(path = "/{id}")
    public Bookstore updateBookstore(@PathVariable Integer id, @RequestBody Bookstore entity){
        Bookstore bookstore=repository.findOneByBookstoreIdAndDeletedAtIsNull(id).orElseThrow();
        bookstore.setName(entity.getName());
        bookstore.setAdress(entity.getAdress());
        bookstore.setUpdatedAt(LocalDateTime.now());
        return repository.save(bookstore);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBookstoreById(@PathVariable Integer id){
        Bookstore bookstore =repository.findOneByBookstoreIdAndDeletedAtIsNull(id).orElseThrow();
        bookstore.setDeletedAt(LocalDateTime.now());
        repository.save(bookstore);

    }
    

}
