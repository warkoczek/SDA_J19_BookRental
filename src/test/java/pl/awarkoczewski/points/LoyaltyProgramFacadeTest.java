package pl.awarkoczewski.points;

import org.junit.Assert;
import org.junit.Test;
import pl.awarkoczewski.books.model.Book;
import pl.awarkoczewski.books.model.Genre;
import pl.awarkoczewski.friends.model.Friend;
import pl.awarkoczewski.points.calculator.DefaultPointsCalculator;

import pl.awarkoczewski.points.model.Points;
import pl.awarkoczewski.points.repository.InMemoryPointsRepository;
import pl.awarkoczewski.rentals.Rental;

import java.time.LocalDate;


public class LoyaltyProgramFacadeTest {

    LoyaltyProgramFacade loyaltyProgramFacade = new LoyaltyProgramFacade(new DefaultPointsCalculator(),
            new InMemoryPointsRepository());

    @Test
    public void getRentalAwardShouldCalculatePointsForExistingFriend(){

        //given
        Book book = new Book(2l, "Guns Germs and Steal", "Jared Diamond", Genre.SCIENCE, LocalDate.of(2011,12,12));
        Friend friend = new Friend(2l, "Filip","Gondulek","fgondulek@yahoo.com");
        Rental rental = new Rental(friend, book, LocalDate.of(2019,12,12), LocalDate.of(2019,12,22));
        Integer expectedPoints = 26;

        //when
        Points result = loyaltyProgramFacade.getRentalAward(rental);

        //
        Assert.assertEquals(expectedPoints,result.getPoints());

    }

    @Test
    public void getRentalAwardShouldCalculatePointsForNewFriend(){

        //given
        Book book = new Book(2l, "Guns Germs and Steal", "Jared Diamond", Genre.SCIENCE, LocalDate.of(2011,12,12));
        Friend friend = new Friend(5l, "Zdzisiu", "Zdzisiek", "zzdzisiek@yahoo.com");
        Rental rental = new Rental(friend,book, LocalDate.of(2019,12,12),LocalDate.of(2019,12,22));
        Integer expectedResult =11;

        //when
        Points result = loyaltyProgramFacade.getRentalAward(rental);

        //then
        Assert.assertEquals(expectedResult,result.getPoints());
    }

}