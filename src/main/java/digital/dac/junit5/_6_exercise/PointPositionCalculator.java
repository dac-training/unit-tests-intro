package digital.dac.junit5._6_exercise;

import digital.dac.junit5._6_exercise.model.Layer;
import digital.dac.junit5._6_exercise.model.Point;

public interface PointPositionCalculator {

    Point calculateNewPosition(Point point, Layer layer, int distance);

}
