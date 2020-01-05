package pl.awarkoczewski.books;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.awarkoczewski.books.model.Book;
import pl.awarkoczewski.books.model.Genre;
import pl.awarkoczewski.books.repository.BookRepository;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class BookFacade {

    private BookRepository bookRepository;

    public Book save(Book book){

        return bookRepository.insertBook(book);
    }

    public Book showBookByTitle(String title){

        return bookRepository.findBooksByTitle(title);
    }

    public List<Book> showBooksByGenre(String genre){

        return bookRepository.findBooksByGenre(genre);
    }
}
