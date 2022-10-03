package domain;

import java.util.List;

public class ExfoliationRoutine extends Routine {

    public ExfoliationRoutine(String time) {
        super(ConstantUse.EXFOLIATOR, "PM");
        this.time = time;
    }

    @Override
    public List<Product> getRoutineOrder() {
        return List.of(cleanser, active, moisturizer);
    }

    @Override
    public String getRoutineType() {
        return "EXFOLIATION";
    }
}