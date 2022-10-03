package domain;

import manager.ProductManager;

import java.util.List;

public class AmRoutines extends Routine {

    Product sunscreen;

    public AmRoutines(String time) {
        super(ConstantUse.VITAMINC, "AM");

        this.time = time;
        ProductManager pm = ProductManager.getInstance();

        for(Product p: pm.getAllOfType(ConstantUse.SUNSCREEN)) {
            if((p.getTime().equalsIgnoreCase("AM") || p.getTime().equalsIgnoreCase("ANY")) && !products.contains(p)) {
                sunscreen = p;
            }
        }

        if(sunscreen == null) sunscreen = pm.getAllOfType(ConstantUse.SUNSCREEN).get(0);
        products.add(sunscreen);
    }

    @Override
    public List<Product> getRoutineOrder() {
        return List.of(cleanser, active, moisturizer, sunscreen);
    }

    @Override
    public String getRoutineType() {
        return "MORNING";
    }
}