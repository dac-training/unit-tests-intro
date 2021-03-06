package digital.dac.junit5._5_exercise.model;

public class PointCannotBeMovedException extends RuntimeException {

    public PointCannotBeMovedException(Point point) {
        super(String.format("Point %s:%s cannot be moved", point.getX(), point.getY()));
    }
}
