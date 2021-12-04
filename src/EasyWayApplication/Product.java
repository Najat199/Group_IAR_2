package EasyWayApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Product {

    private String section;
    private String category;
    private String productID;
    private String productName;
    private double price;
    

    public Product(String section, String category, String productID, String productName, double price) {
        this.section = section;
        this.category = category;
        this.productID = productID;
        this.productName = productName;
        this.price = price;
    }

    public String getSection() {
        return section;
    }

    public String getCategory() {
        return category;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public static void PrintCart() {
        try {
            System.out.println("***************************************");
            System.out.println("             Cart product           ");
            System.out.println("***************************************");
            BufferedReader input = new BufferedReader(new FileReader("Cart.txt"));
            String[] setter;
            String line = "";
            while ((line = input.readLine()) != null) {
                System.out.println(searchByID(line));

            }
            input.close();

        } catch (IOException e) {
            // exception handling left as an exercise for the reader
        }
        System.out.println("***************************************");

    }

    public static void PrintFavorites() {
        try {
            System.out.println("***************************************");
            System.out.println("             Favorites product           ");
            System.out.println("***************************************");
            BufferedReader input = new BufferedReader(new FileReader("Favorites.txt"));
            String[] setter;
            String line = "";
            while ((line = input.readLine()) != null) {
                System.out.println(searchByID(line));

            }
            input.close();

        } catch (IOException e) {
            // exception handling left as an exercise for the reader
        }
        System.out.println("***************************************");

    }

    public static Product searchByID(String ProductID) throws FileNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new FileReader("products.txt"));
        String[] setter;
        String line = "";
        while ((line = input.readLine()) != null) {
            if (line.contains(ProductID)) {
                setter = line.split(",");
                double price = Double.parseDouble(setter[4]);
                return new Product(setter[0], setter[1], setter[2], setter[3], price);
            }

        }
        return null;
    }

    public static String specificCategory(String Section, String category) throws FileNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new FileReader("products.txt"));
        String[] setter;
        String line = "";
        while ((line = input.readLine()) != null) {
            if (line.contains(Section.trim()) && line.contains(category.trim())) {
                setter = line.split(",");
                return "Product Name: " + setter[3] + " \n" + "Price: " + setter[4];
            }
        }
        return "";
    }

    public static ArrayList<Product> getSectionCategoryProducts(String Section, String category) {
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            BufferedReader input = new BufferedReader(new FileReader("products.txt"));
            String[] setter;
            String line = "";

            while ((line = input.readLine()) != null) {
                if (line.contains(Section.trim()) && line.contains(category.trim())) {
                    setter = line.split(",");
                    double price = Double.parseDouble(setter[4]);
                    products.add(new Product(setter[0], setter[1], setter[2], setter[3], price));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return products;
    }

    public void displayProduct() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format("%-10s Price:%s", productName, price);
    }

}
