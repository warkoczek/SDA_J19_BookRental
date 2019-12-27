package pl.awarkoczewski.points.repository;

import pl.awarkoczewski.points.model.Points;


import java.util.Optional;

public interface PointsRepository {

    Optional<Points> obtainFriendPointsById(Long friendId);

    Points savePoints(Points points);

    Points update(Points points);



}
