package domain;

import manager.ProductManager;

import java.util.List;

public class RecoveryRoutine extends Routine{

    private Product slug;

    public RecoveryRoutine(String time) {
        super(ConstantUse.SERUM, "PM");
        this.time = time;

        ProductManager pm = ProductManager.getInstance();

        for(Product p: pm.getAllOfType(ConstantUse.SLUG)) {
            if((p.getTime().equalsIgnoreCase("AM") || p.getTime().equalsIgnoreCase("ANY")) && !products.contains(p)) {
                this.slug = p;
            }
        }

        if(this.slug == null) slug = pm.getAllOfType(ConstantUse.SLUG).get(0);
        products.add(slug);
    }

    @Override
    public List<Product> getRoutineOrder() {
        return List.of(cleanser, active, moisturizer, slug);
    }

    @Override
    public String getRoutineType() {
        return "RECOVERY";
    }
}

