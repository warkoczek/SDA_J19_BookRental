package pl.awarkoczewski.books.repository;


import org.junit.Assert;
import org.junit.Test;
import pl.awarkoczewski.books.model.Book;
import pl.awarkoczewski.books.model.Genre;

import java.time.LocalDate;
import java.util.List;

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

    @Test
    public void searchBooksByGenreShouldReturnTitleFlightsForIndex0InTheList(){

        //given
        Book book = new Book(5L, "Flights", "Olga Tokarczuk", Genre.SF,
                LocalDate.of(2011,12,12));
        final String genre = "SF";
        final String expectedResult = "Flights";

        //when
        List<Book> books = bookRepository.findBooksByGenre(genre);

        //then
        Assert.assertEquals(expectedResult,books.get(0).getTitle());

    }
    @Test
    public void searchBookByPhraseShouldReturnTitleGunsGermsAndStealForPhraseSteal(){

        //given
        final Book book = new Book(2l, "Guns Germs and Steal","Jared Diamond",Genre.SCIENCE, LocalDate.of(2011,12,12));
        final String phrase = "steal";
        final String expectedResult = "Guns Germs and Steal";

        //when
        Book resultBook = bookRepository.findBookByPhrase(phrase);

        //then
        Assert.assertEquals(expectedResult,resultBook.getTitle());
    }

    @Test
    public void searchBooksByPhraseShouldReturnSortedListOfBookTitles(){

        //given
        final Book book = new Book(6l, "Steal this urine test","Abbie Hoffman",Genre.SCIENCE,LocalDate.of(2019,12,12));
        final String phrase = "steal";
        final String expectedResult = "Steal this urine test";

        //when
        List<String> result = bookRepository.searchBooksWithPhrase(phrase);

        //then
        Assert.assertEquals(expectedResult,result.get(2));
    }

    @Test
    public void searchBooksByPhraseShouldReturn0ForNoneExistingPhrase(){

        //given
        final Book book = new Book(6l, "Steal this urine test","Abbie Hoffman",Genre.SCIENCE,LocalDate.of(2019,12,12));
        final String phrase = "kolo";
        final int expectedResult = 0;

        //when
        List<String> result = bookRepository.searchBooksWithPhrase(phrase);

        //then
        Assert.assertEquals(expectedResult,result.size());
    }


}