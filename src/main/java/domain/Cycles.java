package domain;

public class Cycles {
    private Day[] days = new Day[4];
    private int cycleDay;

    public Cycles() {
        days[0] = new Exfoliation();
        days[1] = new Retinoid();
        days[2] = new Recovery();
        days[3] = new Recovery();
        cycleDay = 0;
    }

    public Routine getNextRoutine() {
        for(int i = 0; i < days.length; i++) {
            if(days[i].isOver()) continue;
            if(!days[i].amRoutine.alerted) {
                return days[i].amRoutine;
            } else {
                if(!days[i].pmRoutine.alerted) {
                    return days[i].pmRoutine;
                } else {
                    days[i].finish();
                    cycleDay++;
                }
            }

        }
        return null;
    }
}
