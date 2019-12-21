package pl.awarkoczewski.books.repository;


import org.junit.Assert;
import org.junit.Test;
import pl.awarkoczewski.books.model.Book;
import pl.awarkoczewski.books.model.Genre;

import java.time.LocalDate;

public class InMemoryBookRepositoryTest {

    BookRepository bookRepository = new InMemoryBookRepository();

    @Test
    public void insertProperlySavesANewBookAtIndex5(){

        //given
        Book bookToSave = new Book(5L, "Flights", "Olga Tokarczuk", Genre.SF,
                LocalDate.of(2011,12,12));
        Long expectedResult = 5L;

        //when
        bookRepository.insertBook(bookToSave);
        Book result = bookRepository.findBookById(5L);

        //then
        Assert.assertEquals(expectedResult, result.getId());
    }

}