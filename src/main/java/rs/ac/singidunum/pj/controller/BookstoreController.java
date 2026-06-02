package rs.ac.singidunum.pj.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import rs.ac.singidunum.pj.entity.Bookstore;
import rs.ac.singidunum.pj.repo.BookstoreRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/bookstore")
@RequiredArgsConstructor

public class BookstoreController {

    private final BookstoreRepository repository;

    @GetMapping
    public List<Bookstore> getBookstore(){
        return repository.findAllByDeletedAtIsNull();
    }
    @DeleteMapping(path = "/{id}")
    public void deleteBookstoreById(@PathVariable Integer id){
        Bookstore bookstore =repository.findOneByBookstoreIdAndDeletedAtIsNull(id).orElseThrow();
        bookstore.setDeletedAt(LocalDateTime.now());
        repository.save(bookstore);

    }

}
