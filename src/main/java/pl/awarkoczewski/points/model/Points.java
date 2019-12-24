package pl.awarkoczewski.points.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Points {

    @Setter
    private Long id;

    private Long friendId;
    @Setter
    private Integer points;

    public Integer rentalPointsAdded(Integer pointsToAdd){

        return points += pointsToAdd;
    }
}
