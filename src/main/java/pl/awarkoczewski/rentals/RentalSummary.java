package pl.awarkoczewski.rentals;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.awarkoczewski.points.model.Points;
import pl.awarkoczewski.pricing.model.Price;

@AllArgsConstructor
@Data
public class RentalSummary {

    private Price price;
    private Points points;

    public String toString(){
        return "Price of your rental is " + price + "\n" + "You current points amount is: " + points;
    }
}
