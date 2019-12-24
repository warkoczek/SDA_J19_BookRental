package pl.awarkoczewski.points;

import lombok.AllArgsConstructor;
import pl.awarkoczewski.friends.model.Friend;

import pl.awarkoczewski.points.calculator.PointsCalculator;
import pl.awarkoczewski.points.model.Points;
import pl.awarkoczewski.points.repository.PointsRepository;
import pl.awarkoczewski.rentals.Rental;

import java.util.Optional;

@AllArgsConstructor
public class LoyaltyProgramFacade {

    PointsCalculator pointsCalculator;
    PointsRepository pointsRepository;

    public Points getRentalAward(Rental rental){

        Integer pointsToAdd = pointsCalculator.calculateTotalRentalPoints(rental);

        return addPoints(rental.getFriend(), pointsToAdd);
    }

    private Points addPoints(Friend friend, Integer pointsToAdd) {

        Optional<Points> currentFriendPoints = pointsRepository.obtainFriendPointsById(friend.getId());

        Points entryForFriend;

        if(currentFriendPoints.isPresent()){
            entryForFriend = currentFriendPoints.get();
            entryForFriend.rentalPointsAdded(pointsToAdd);
            pointsRepository.update(entryForFriend);
        }else{
            entryForFriend = new Points(null,friend.getId(),pointsToAdd + 5);
            pointsRepository.savePoints(entryForFriend);

        }
        return entryForFriend;
    }
}
