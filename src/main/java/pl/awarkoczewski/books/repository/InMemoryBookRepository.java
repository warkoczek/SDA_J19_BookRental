package pl.awarkoczewski.books.repository;

import pl.awarkoczewski.books.model.Book;
import pl.awarkoczewski.books.model.BookNotFoundException;
import pl.awarkoczewski.books.model.Genre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryBookRepository implements BookRepository {

    List<Book> bookList;
    Long nextId;

    public InMemoryBookRepository() {
        bookList = new ArrayList<>();

        bookList.add(new Book(1l, "Collapse", "Jared Diamond", Genre.SCIENCE, LocalDate.of(2010,12,12)));
        bookList.add(new Book(2l, "Guns Germs and Steal", "Jared Diamond",Genre.SCIENCE, LocalDate.of(2011,12,12)));
        bookList.add(new Book(3l, "The Origin of Species", "Darwin",Genre.SCIENCE, LocalDate.of(1885,12,12)));
        bookList.add(new Book(4l, "Flights", "Olga Tokarczuk",Genre.SF, LocalDate.of(2011,12,12)));
        bookList.add(new Book(5l, "Steal like an Artist","Austin Kleon",Genre.ART, LocalDate.of(2012,02,28)));
        bookList.add(new Book(6l, "Steal this urine test", "Abbie Hoffman", Genre.SCIENCE,LocalDate.of(2019,12,12)));
        nextId = Long.valueOf(bookList.size()+1);
    }


    //what if inserting book is a duplicate?????
    @Override
    public Book insertBook(Book book) {
        book.setId(nextId);
        bookList.add(book);
        return book;
    }
    //after deleted book, id stays empty, is not assigned to other book, is it a LinkedList?
    @Override
    public void delete(Book book) {

        bookList.remove(book);

    }

    @Override
    public Book update(Book book) {

        Book bookToUpdate = bookList.stream()
                .filter(b -> b.getId().equals(book.getId()))
                .findFirst().orElseThrow(() -> new BookNotFoundException("Book does not exist"));

        bookToUpdate.setId(book.getId());
        return bookToUpdate;
    }

    @Override
    public Book findBookById(Long id) {
        return bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst().orElseThrow(() -> new BookNotFoundException("Book with given Id does not exist"));
    }

    @Override
    public Book findBooksByTitle(String title) {

        return bookList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst().orElseThrow(() -> new BookNotFoundException(("Book does not exist")));

    }

    @Override
    public List<Book> findBooksByGenre(String genre) {

        return bookList.stream()
                .filter(book -> book.getGenre().getName().equalsIgnoreCase(genre))
                .collect(Collectors.toList());

    }

    @Override
    public Book findBookByPhrase(String phrase) {

        return bookList.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(phrase.toLowerCase()))
                .findFirst().orElseThrow(() -> new BookNotFoundException("No book title with this phrase"));

    }

    @Override
    public List<String> searchBooksWithPhrase(String phrase) {

        return bookList.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(phrase.toLowerCase()))
                .map(book -> book.getTitle())
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

    }
}
