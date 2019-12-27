package pl.awarkoczewski.pricing;

import org.junit.Assert;
import org.junit.Test;
import pl.awarkoczewski.books.model.Book;
import pl.awarkoczewski.books.model.Genre;
import pl.awarkoczewski.friends.model.Friend;
import pl.awarkoczewski.points.repository.InMemoryPointsRepository;
import pl.awarkoczewski.points.repository.PointsRepository;
import pl.awarkoczewski.pricing.calculator.DefaultPriceCalculator;
import pl.awarkoczewski.pricing.calculator.PriceCalculator;
import pl.awarkoczewski.pricing.model.Price;
import pl.awarkoczewski.rentals.Rental;
import pl.awarkoczewski.time.repository.CurrentTimeRepository;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PricingFacadeTest {

    PricingFacade pricingFacade = new PricingFacade(new DefaultPriceCalculator(new CurrentTimeRepository(),new InMemoryPointsRepository()));
    @Test
    public void getRentalPriceShouldReturnPrice0zlForFriendWithId4() {

        //given
        Friend friend = new Friend(4l,"Maciej", "Ksztuś", "mksztuś@yahoo.com");
        Book book = new Book(1l, "Collapse", "Jared Diamond", Genre.SCIENCE, LocalDate.of(2010,12,12));
        LocalDate rentDate = LocalDate.of(2019,12,10);
        LocalDate returnDate = LocalDate.of(2019,12,30);
        Rental rental = new Rental(friend, book, rentDate, returnDate);
        Double expectedResult = 0d;

        //when
        Price result = pricingFacade.getRentalPrice(rental);

        //then

        Assert.assertEquals(expectedResult,result.getValue());





    }
}