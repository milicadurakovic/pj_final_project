package rs.ac.singidunum.pj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.pj.entity.Bookstore;
import rs.ac.singidunum.pj.repo.BookstoreRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/api/bookstore")
@RequiredArgsConstructor

public class BookstoreController {

    private final BookstoreRepository repository;

    @GetMapping
    public List<Bookstore> getBookstore(){
        return repository.findAll();
    }

}
