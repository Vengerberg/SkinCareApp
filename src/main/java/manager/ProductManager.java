package manager;

import domain.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> products;
    private static ProductManager pm = null;

    private ProductManager() {
        products = new ArrayList<>();
        load();
    }

    public boolean load() {
        try {
            File f = new File("src\\main\\resources\\products.txt");
            Scanner s = new Scanner(f);

            // ignore line 0
            s.nextLine();

            while(s.hasNextLine()) {
                String[] vals = s.nextLine().split(",");
                boolean owned = vals[5].equalsIgnoreCase("TRUE") ? true : false;
                addProduct(new Product(Integer.parseInt(vals[0]), vals[1], vals[2], Arrays.asList(vals[3].split("/")), vals[4], owned, Double.parseDouble(vals[6].replaceAll("\\$", ""))));
            }

            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public ArrayList<Product> getAllOfType(String type) {
        ArrayList<Product> result = new ArrayList<>();

        for(Product p: products) {
            if(p.getType().contains(type.toUpperCase())) {
                result.add(p);
            }
        }

        return result;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void removeProduct(Product p) {
        products.remove(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    public static ProductManager getInstance() {
        if (pm == null)
            pm = new ProductManager();

        return pm;
    }
}
