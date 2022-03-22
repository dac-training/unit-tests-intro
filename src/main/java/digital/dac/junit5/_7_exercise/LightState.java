package digital.dac.junit5._7_exercise;

public class LightState {

    private static LightState instance;

    private boolean lightsOn;

    private LightState() {
        instance = new LightState();
    }

    public static LightState getInstance() {
        return instance;
    }

    public boolean isLightsOn() {
        return lightsOn;
    }

    public void toggle() {
        this.lightsOn = true;
    }
}
