package pl.infoshare.junit5._12_exercise;

public enum Regulation {
    EC261(500),
    BRAZIL(1000);

    private int minDistance;

    Regulation(int minDistance) {
        this.minDistance = minDistance;
    }

    public int getMinDistance() {
        return minDistance;
    }
}
