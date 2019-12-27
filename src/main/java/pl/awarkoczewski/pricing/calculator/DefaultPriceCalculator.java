package pl.awarkoczewski.pricing.calculator;

import lombok.AllArgsConstructor;
import pl.awarkoczewski.points.model.Points;
import pl.awarkoczewski.points.repository.PointsRepository;
import pl.awarkoczewski.pricing.model.Coinage;
import pl.awarkoczewski.pricing.model.Price;
import pl.awarkoczewski.rentals.Rental;
import pl.awarkoczewski.time.repository.TimeRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@AllArgsConstructor
public class DefaultPriceCalculator implements PriceCalculator{

    private TimeRepository timeRepository;
    private PointsRepository pointsRepository;

    @Override
    public Price calculateRentalPrice(Rental rental) {
        //TODO in PointsRepository -deduct 100points and start counting over again.
        Double value = (rentalDurationPrice(rental) - hundredPointsDiscount(rental))* bookAgeMultiplier(rental);
        Coinage currency = Coinage.PLN;
        return new Price(value, currency);
    }

    private Double bookAgeMultiplier(Rental rental) {
        final Period daysFromReleaseDate = rental.getBook().getReleaseDate().until(timeRepository.getCurrentDate());

        return Double.valueOf(daysFromReleaseDate.getYears()) < 0.5 ? 2d : 1;
    }

    private Double rentalDurationPrice(Rental rental){

        LocalDate rentDate = rental.getRentDate();
        LocalDate returnDate = rental.getReturnDate();
        Double weeks = Double.valueOf(rentDate.until(returnDate, ChronoUnit.WEEKS));
        return weeks <= 2 ? 1d : 2d;
    }

    private Double hundredPointsDiscount(Rental rental) {

        return obtainFriendPoints(rental) >= 100 ? 1d : 0;

    }

    private Double obtainFriendPoints(Rental rental){

        Optional<Points> optionalPoints = pointsRepository.obtainFriendPointsById(rental.getFriend().getId());

        if(optionalPoints.isPresent()){
            return Double.valueOf(optionalPoints.get().getPoints());
        }else{
            return 0d;
        }


    }


}
