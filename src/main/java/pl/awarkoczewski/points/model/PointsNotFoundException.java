package pl.awarkoczewski.points.model;

public class PointsNotFoundException extends RuntimeException {


    public PointsNotFoundException(String message) {
        super(message);
    }
}
