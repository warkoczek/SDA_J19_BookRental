package pl.awarkoczewski.points.repository;

import pl.awarkoczewski.points.model.Points;
import pl.awarkoczewski.points.model.PointsNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryPointsRepository implements PointsRepository {

    List<Points> pointsList;
    Long nextId = 1L;

    public InMemoryPointsRepository() {
        pointsList = new ArrayList<>();
        pointsList.add(new Points(1L, 1L, 6));
        pointsList.add(new Points(2L,2L,20));
        pointsList.add(new Points(3L,3L,90));
        pointsList.add(new Points(4L,4L,100));
        nextId += Long.valueOf(pointsList.size());
    }

    @Override
    public Optional<Points> obtainFriendPointsById(Long friendId) {

        return pointsList.stream()
                .filter(points -> points.getFriendId().equals(friendId))
                .findFirst();


    }

    @Override
    public Points savePoints(Points points) {
        points.setId(nextId);
        pointsList.add(points);
        return points;
    }

    @Override
    public Points update(Points points) {

        Points pointsToUpdate = pointsList.stream()
                .filter(points1 -> points1.getId().equals(points.getId()))
                .findFirst().orElseThrow(() -> new PointsNotFoundException("No such points in the repository"));
        pointsToUpdate.setId(points.getId());
        pointsToUpdate.setPoints(points.getPoints());
        return pointsToUpdate;
    }
}
