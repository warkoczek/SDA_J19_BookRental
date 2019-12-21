package pl.awarkoczewski;

import pl.awarkoczewski.books.BookFacade;
import pl.awarkoczewski.books.model.Book;
import pl.awarkoczewski.books.repository.InMemoryBookRepository;
import pl.awarkoczewski.friends.FriendFacade;
import pl.awarkoczewski.friends.model.Friend;
import pl.awarkoczewski.friends.repository.InMemoryFriendRepository;



public class App {

    public static void main(String[] args) {

        BookFacade bookFacade = new BookFacade(new InMemoryBookRepository());

        Book book = bookFacade.getBookByTitle("Flights");

        System.out.println("\n" + book.toString() + "\n");

        FriendFacade friendFacade = new FriendFacade(new InMemoryFriendRepository());

        Friend friend = friendFacade.getFriendByFullName("Adam Warkoczewski");

        System.out.println(friend.toString());

    }
}
