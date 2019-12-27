package pl.awarkoczewski.pricing.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Price {

    private Double value;
    private Coinage currency;

    public String toString(){

        return value + " " + currency;
    }
}
