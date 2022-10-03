package domain;

public class Recovery extends Day {

    public Recovery() {
        super();
        pmRoutine = new RecoveryRoutine(pmTime);
    }
}
