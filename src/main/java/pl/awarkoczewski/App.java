package pl.awarkoczewski;


import pl.awarkoczewski.books.model.Book;
import pl.awarkoczewski.books.model.Genre;
import pl.awarkoczewski.books.repository.BookRepository;
import pl.awarkoczewski.books.repository.InMemoryBookRepository;
import pl.awarkoczewski.friends.model.Friend;
import pl.awarkoczewski.points.LoyaltyProgramFacade;
import pl.awarkoczewski.points.calculator.DefaultPointsCalculator;

import pl.awarkoczewski.points.repository.InMemoryPointsRepository;
import pl.awarkoczewski.pricing.PricingFacade;
import pl.awarkoczewski.pricing.calculator.DefaultPriceCalculator;

import pl.awarkoczewski.rentals.BookRentalFacade;

import pl.awarkoczewski.rentals.Rental;
import pl.awarkoczewski.rentals.RentalSummary;
import pl.awarkoczewski.time.repository.CurrentTimeRepository;

import java.time.LocalDate;
import java.util.List;


public class App {

    public static void main(String[] args) {

        BookRentalFacade bookRentalFacade = initFacade();

        Friend friend = new Friend(1l, "Adam", "Warkoczewski", "awarkoczewski@yahoo.com");
        Book book = new Book(1l,"Flights","Olga Tokarczuk", Genre.SF, LocalDate.of(2011,12,12));

        Rental rental = new Rental(friend, book, LocalDate.of(2019,12,10),LocalDate.of(2019,12,30));

        RentalSummary rentalSummary = bookRentalFacade.rentBook(rental);

        System.out.println(rentalSummary);




    }

    public static BookRentalFacade initFacade(){

        PricingFacade pricingFacade = new PricingFacade(new DefaultPriceCalculator(new CurrentTimeRepository(), new InMemoryPointsRepository()));
        LoyaltyProgramFacade loyaltyProgramFacade = new LoyaltyProgramFacade(new DefaultPointsCalculator(), new InMemoryPointsRepository());

        return new BookRentalFacade(pricingFacade,loyaltyProgramFacade);
    }
}
