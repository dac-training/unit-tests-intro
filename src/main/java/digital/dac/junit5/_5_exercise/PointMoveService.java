package digital.dac.junit5._5_exercise;

import digital.dac.junit5._5_exercise.model.Layer;
import digital.dac.junit5._5_exercise.model.Point;
import digital.dac.junit5._5_exercise.model.PointCannotBeMovedException;
import digital.dac.junit5._5_exercise.model.PointValidationException;

/**
 * Ćwiczenie 6. Napisz testy dla poniższej klasy wykorzystując bibliotekę Mockito.
 * Pamiętaj, żeby upewnić się, że wartości wysłane do poszczególnych metod zawierają konkretnie te dane których oczekujesz.
 */
public class PointMoveService {

    private final PointValidator pointValidator;
    private final PointLayerFindService pointLayerFindService;
    private final PointPositionCalculator pointPositionCalculator;

    public PointMoveService(PointValidator pointValidator, PointLayerFindService pointLayerFindService, PointPositionCalculator pointPositionCalculator) {
        this.pointValidator = pointValidator;
        this.pointLayerFindService = pointLayerFindService;
        this.pointPositionCalculator = pointPositionCalculator;
    }

    public Point movePoint(Point point, int distance) {
        try {
            pointValidator.canMove(point);
            var intLayer = pointLayerFindService.getPointLayer(point);

            var layer = new Layer(intLayer);
            return pointPositionCalculator.calculateNewPosition(point, layer, distance);
        } catch (PointValidationException pointValidationException) {
            throw new PointCannotBeMovedException(point);
        }
    }
}
