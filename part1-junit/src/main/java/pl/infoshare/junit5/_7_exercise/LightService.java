package pl.infoshare.junit5._7_exercise;

/**
 * Ćwiczenie 7. Napisz testy dla klas zawierających logikę. Jeżeli fragment kodu uznasz za nietestowalny możesz usprawnić kod produkcyjny
 */
public class LightService {

    private final TimeOfDayProvider timeOfDayProvider;

    public LightService(TimeOfDayProvider timeOfDayProvider) {
        this.timeOfDayProvider = timeOfDayProvider;
    }

    public void activateLights() {
        var timeOfDay = timeOfDayProvider.getTimeOfDay();

        var lightState = LightState.getInstance();
        if (timeOfDay == TimeOfDay.NIGHT || timeOfDay == TimeOfDay.EVENING) {
            if (!lightState.isLightsOn()) {
                lightState.toggle();
            }
        } else if (lightState.isLightsOn()) {
            lightState.toggle();
        }
    }
}
