package rs.ac.singidunum.pj.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import rs.ac.singidunum.pj.entity.Bookstore;
import rs.ac.singidunum.pj.repo.BookstoreRepository;

@Service
@RequiredArgsConstructor
public class BookstoreService {

    private final BookstoreRepository repository;

    public List<Bookstore> getAll(){
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Bookstore> getById(Integer id){
        return repository.findOneByBookstoreIdAndDeletedAtIsNull(id);
    }

    public Bookstore create(Bookstore entity){
        Bookstore bookstore =new Bookstore();
        bookstore.setName(entity.getName());
        bookstore.setAdress(entity.getAdress());
        bookstore.setCreatedAt(LocalDateTime.now());
        return repository.save(bookstore);
    }
    public Bookstore update(Integer id, Bookstore entity){
        Bookstore bookstore=repository.findOneByBookstoreIdAndDeletedAtIsNull(id).orElseThrow();
        bookstore.setName(entity.getName());
        bookstore.setAdress(entity.getAdress());
        bookstore.setUpdatedAt(LocalDateTime.now());
        return repository.save(bookstore);
    }
    public void deleteById(Integer id){
        Bookstore bookstore =repository.findOneByBookstoreIdAndDeletedAtIsNull(id).orElseThrow();
        bookstore.setDeletedAt(LocalDateTime.now());
        repository.save(bookstore);

    }

    
}
