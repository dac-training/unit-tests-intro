package pl.infoshare.junit5._6_exercise.model;

public class PointCannotBeMovedException extends RuntimeException {

    public PointCannotBeMovedException(Point point) {
        super(String.format("Point %s:%s cannot be moved", point.getX(), point.getY()));
    }
}
