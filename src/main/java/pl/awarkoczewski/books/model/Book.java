package pl.awarkoczewski.books.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    private Long id;
    private String title;
    private String author;
    private Genre genre;
    private LocalDate releaseDate;



    public Book(Long id, String title){
        this.id=id;
        this.title=title;
    }


}
