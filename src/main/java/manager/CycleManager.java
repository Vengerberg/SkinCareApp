package manager;

import domain.Cycles;
import domain.Routine;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CycleManager {
    private String cycleStart;
    private ArrayList<Cycles> cycles;
    private int currCycle;
    private static CycleManager cm = null;
    private Routine currentRoutine;

    private CycleManager() {
        cycleStart = LocalDateTime.now().toString();
        cycles = new ArrayList<>();
        if(cycles.isEmpty()) {
            cycles.add(new Cycles());
            currCycle = 0;
        } else {
            currCycle = cycles.size();
        }
    }

    public static CycleManager getInstance() {
        if(cm == null) {
            cm = new CycleManager();
        }

        return cm;
    }

    public boolean alert() {
        if(TimeManager.alertTime(cycles.get(currCycle).getNextRoutine().getTime())) {
            currentRoutine = cycles.get(currCycle).getNextRoutine();
            currentRoutine.alerted();
            return true;
        }

        return false;
    }

    public void displayRoutine() throws AWTException {
        String text = "It's time for your " + getCurrentRoutine().getRoutineType().toLowerCase() + " routine!\nClick me for your steps!";
        TrayManager.displayTray("Skin Cycler", text);
    }

    public Routine getCurrentRoutine() {
        return currentRoutine;
    }
}
