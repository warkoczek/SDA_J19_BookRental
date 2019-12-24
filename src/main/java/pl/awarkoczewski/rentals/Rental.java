package pl.awarkoczewski.rentals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.awarkoczewski.books.model.Book;
import pl.awarkoczewski.friends.model.Friend;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Rental {

    private Book book;
    private Friend friend;
    private LocalDate rentDate;
    private LocalDate returnDate;
}
