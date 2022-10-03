package domain;

public class Retinoid extends Day {

    public Retinoid() {
        super();
        pmRoutine = new RetinoidRoutine(pmTime);
    }
}

