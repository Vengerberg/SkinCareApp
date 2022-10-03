package domain;

public class Exfoliation extends Day {

    public Exfoliation() {
        super();
        pmRoutine = new ExfoliationRoutine(pmTime);
    }
}

