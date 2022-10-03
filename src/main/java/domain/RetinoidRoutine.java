package domain;

import java.util.List;

public class RetinoidRoutine extends Routine {

    public RetinoidRoutine(String time) {
        super(ConstantUse.RETINOID, "PM");
        this.time = time;
    }

    @Override
    public List<Product> getRoutineOrder() {
        return List.of(cleanser, active, moisturizer);
    }

    @Override
    public String getRoutineType() {
        return ConstantUse.RETINOID;
    }
}
