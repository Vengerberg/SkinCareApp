package domain;

public abstract class Day {
    String amTime = "00:00:00";
    String pmTime = "20:00:00";
    Routine amRoutine;
    Routine pmRoutine;
    private boolean complete;

    public Day() {
        amRoutine = new AmRoutines(amTime);
        complete = false;
    }

    public boolean isOver() {
        return complete;
    }

    public void finish() {
        complete = true;
    }
}
