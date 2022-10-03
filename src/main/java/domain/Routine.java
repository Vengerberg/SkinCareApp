package domain;

import manager.ProductManager;

import java.util.ArrayList;
import java.util.List;

public abstract class Routine {
    ArrayList<Product> products;
    Product cleanser;
    Product active;

    Product moisturizer;
    boolean alerted;
    String time;

    public Routine(String type, String timeOfDay) {
        // get cleansers and select one not already in use
        products = new ArrayList<>();
        alerted = false;
        ProductManager pm = ProductManager.getInstance();

        for(Product p: pm.getAllOfType(ConstantUse.CLEANSER)) {
            if((p.getTime().equalsIgnoreCase("AM") || p.getTime().equalsIgnoreCase("ANY")) && !products.contains(p)) {
                cleanser = p;
                products.add(p);
            }
        }

        if(cleanser == null) cleanser = pm.getAllOfType(ConstantUse.CLEANSER).get(0);
        products.add(cleanser);

        for(Product p: pm.getAllOfType(type)) {
            if((p.getTime().equalsIgnoreCase(timeOfDay) || p.getTime().equalsIgnoreCase("ANY"))  && !products.contains(p)) {
                active = p;
            }
        }

        if(active == null) active = pm.getAllOfType(type).get(0);
        products.add(active);

        for(Product p: pm.getAllOfType(ConstantUse.MOISTURIZER)) {
            if((p.getTime().equalsIgnoreCase("AM") || p.getTime().equalsIgnoreCase("ANY")) && !products.contains(p)) {
                moisturizer = p;
            }
        }

        if(moisturizer == null) moisturizer = pm.getAllOfType(ConstantUse.MOISTURIZER).get(0);
        products.add(moisturizer);
    }

    // Sort and return Products
    public abstract List<Product> getRoutineOrder();

    public String getTime() {
        return time;
    }

    public void alerted() {
        alerted = true;
    }

    public abstract String getRoutineType();

    public String getProductsString() {
        String result = "";

        for(Product p: products) {
            result += p.getName() + " ";
        }

        return result;
    }
}
