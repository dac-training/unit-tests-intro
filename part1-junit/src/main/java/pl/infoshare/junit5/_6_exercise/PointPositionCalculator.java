package pl.infoshare.junit5._6_exercise;

import pl.infoshare.junit5._6_exercise.model.Layer;
import pl.infoshare.junit5._6_exercise.model.Point;

public interface PointPositionCalculator {

    Point calculateNewPosition(Point point, Layer layer, int distance);

}
