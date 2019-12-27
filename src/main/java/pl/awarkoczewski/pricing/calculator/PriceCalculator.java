package pl.awarkoczewski.pricing.calculator;

import pl.awarkoczewski.pricing.model.Price;
import pl.awarkoczewski.rentals.Rental;

public interface PriceCalculator {

    Price calculateRentalPrice(Rental rental);
}
