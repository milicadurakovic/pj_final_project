package rs.ac.singidunum.pj.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import model.BookModel;

@Service
public class BookService {

    private final RestClient client = RestClient.builder()
        .baseUrl("https://openlibrary.org")
        .defaultHeader("Accept", "application/json")
        .defaultHeader("X-Name", "PJ_2026")
        .build();

    public List<BookModel> getAll(){
        List<BookModel> unsorted = client.get()
        .uri("/book")
        .retrieve()
        .body(new ParameterizedTypeReference<>() {  
        });

        unsorted.sort(Comparator.comparing(BookModel::getBookId).reversed());
        return unsorted;
    }

    public Optional<BookModel> getById(Integer id){
        try{
            return Optional.ofNullable(
            client.get()
                    .uri("/book/"+id)
                    .retrieve()
                    .body(BookModel.class));
        } catch (HttpClientErrorException.NotFound ex){
            return Optional.empty();
        }
        
    }
    
}
