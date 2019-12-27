package pl.awarkoczewski.rentals;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.awarkoczewski.points.LoyaltyProgramFacade;
import pl.awarkoczewski.pricing.PricingFacade;

@AllArgsConstructor
@Data
public class BookRentalFacade {

    PricingFacade pricingFacade;
    LoyaltyProgramFacade loyaltyProgramFacade;

    public RentalSummary rentBook(Rental rental){

        return new RentalSummary(pricingFacade.getRentalPrice(rental),loyaltyProgramFacade.getRentalAward(rental));
    }
}
