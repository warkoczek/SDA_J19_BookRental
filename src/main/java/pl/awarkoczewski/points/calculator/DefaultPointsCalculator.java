package pl.awarkoczewski.points.calculator;

import pl.awarkoczewski.rentals.Rental;
import pl.awarkoczewski.time.repository.CurrentTimeRepository;
import pl.awarkoczewski.time.repository.TimeRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class DefaultPointsCalculator implements PointsCalculator {


    @Override
    public Integer calculateTotalRentalPoints(Rental rental) {

        Integer total = rentalDurationPoints(rental) + bookReleaseDatePoints(rental);
        return total;
    }

    private Integer bookReleaseDatePoints(Rental rental){
        TimeRepository tr = new CurrentTimeRepository();

        LocalDate bookReleaseDate = rental.getBook().getReleaseDate();

        Long daysFromReleaseDate = bookReleaseDate.until(tr.getCurrentDate(),ChronoUnit.DAYS);

        return daysFromReleaseDate <= 182 ? 0 : 1;

    }

    private Integer rentalDurationPoints(Rental rental){

        LocalDate rentDate = rental.getRentDate();
        LocalDate returnDate = rental.getReturnDate();

        Long duration = rentDate.until(returnDate, ChronoUnit.DAYS);

        return getRentalDurationPoints(duration);
    }

    private Integer getRentalDurationPoints(Long duration) {

        if(duration == 1){
            return 30;
        }else if(duration >1 && duration <6){
            return 10;
        }else if(duration >= 6 && duration <=10){
            return 5;
        }else if(duration > 10){
            return 1;
        }else{
            return 0;
        }
    }




}
