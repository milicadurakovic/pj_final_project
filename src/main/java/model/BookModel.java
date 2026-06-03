package model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BookModel {

    private Integer bookId;      // iz baze

    private String workId;       // BookKey sa API-ja 

    private String title;

    private String author;

    private Integer numberOfPages;

    private String genre;

    private Integer publishYear;

    private String coverUrl;

    private Boolean available;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    
}
