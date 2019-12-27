package pl.awarkoczewski.books;

import org.junit.Assert;
import org.junit.Test;
import pl.awarkoczewski.books.model.Book;
import pl.awarkoczewski.books.model.Genre;
import pl.awarkoczewski.books.repository.BookRepository;
import pl.awarkoczewski.books.repository.InMemoryBookRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class BookFacadeTest {

    BookFacade bookFacade = new BookFacade(new InMemoryBookRepository());
    @Test
    public void saveCorrectlySavesANewBookAtIndex5() {

        //given
        Book bookToSave = new Book(5L, "Flights", "Olga Tokarczuk", Genre.SF,
                LocalDate.of(2011,12,12));
        Long expectedResult = 5L;

        //when

        Book result = bookFacade.save(bookToSave);

        //then
        Assert.assertEquals(expectedResult, result.getId());
    }

    @Test
    public void showBookByTitleShouldReturnBookWithGivenTitleByJaredDiamond() {

        //given
        final Book book = new Book(2l, "Guns Germs and Steal", "Jared Diamond",Genre.SCIENCE, LocalDate.of(2011,12,12));
        final String expectedResult = "Jared Diamond";

        //when
        final Book result = bookFacade.showBookByTitle("Guns Germs and Steal");

        //then
        Assert.assertEquals(expectedResult,result.getAuthor());
    }

    @Test
    public void showBooksByGenreShouldReturnAListOfBooksOfScienceGenre() {


    }
}