package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Product {

    private static final Map<String, String> instructions = Map.of(
            "SLUG", "1.Apply over moisturizer evenly and generously over face and neck",
            "RETINOIDS", "1.Apply to completely dry cleansed skin 2.Apply to face and neck 3. Move on to apply moisturizer",
            "EXFOLIATOR", "1.Apply to damp face, neck and hands   2.Pat the product in using fingers or face-roller   3. Wait less than 5 mins before applying next step",
            "CLEANSER", "1. Rub into dry or damp skin  2.Add water after 30 seconds    3.Massage and rinse(do not pat dry)",
            "MOISTURIZER", "1. Apply to damp face and neck 2. Pat product in 3. Wait less than 90 seconds before applying next step",
            "SUNSCREEN", "1.Apply evenly over moisturized skin",
            "VITAMIN C", "1.Apply to dry, cleanser skin 2. Apply to face and neck 3. Apply the moisturizer",
            "SERUM", "1. Apply to damp face and neck 2. Pat product in 3. Wait less than 90 seconds before applying next step"
    );
    private int id;
    private String name;
    private String brand;
    private List<String> type;
    private String time;
    private boolean owned;
    private double price;

    public Product(int id, String name, String brand, List<String> type, String time, boolean owned, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.type = new ArrayList<>();

        for(String s: type) {
            this.type.add(s.toUpperCase());
        }

        this.time = time.toUpperCase();
        this.owned = owned;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", type=" + type +
                ", time='" + time + '\'' +
                ", owned=" + owned +
                ", price=" + price +
                '}';
    }

    public static String getInstruction(String type) {
        return instructions.get(type.toUpperCase());
    }
}


