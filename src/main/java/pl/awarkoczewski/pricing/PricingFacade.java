package pl.awarkoczewski.pricing;

import lombok.AllArgsConstructor;


import pl.awarkoczewski.pricing.calculator.PriceCalculator;
import pl.awarkoczewski.pricing.model.Price;
import pl.awarkoczewski.rentals.Rental;

@AllArgsConstructor
public class PricingFacade {

     PriceCalculator priceCalculator;

     public Price getRentalPrice(Rental rental){

         return priceCalculator.calculateRentalPrice(rental);
     }
}
