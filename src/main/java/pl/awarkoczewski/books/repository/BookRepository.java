package pl.awarkoczewski.books.repository;

import pl.awarkoczewski.books.model.Book;
import pl.awarkoczewski.books.model.Genre;


import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Book insertBook(Book book);

    void delete(Book book);

    Book update(Book book);

    Book findBookById(Long id);

    Book findBooksByTitle(String title);

    List<Book> findBooksByGenre(Genre genre);

    Book findBookByPhrase(String phrase);

    List<String> searchBooksWithPhrase(String phrase);
}
