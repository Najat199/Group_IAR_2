
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Product {

    private String section;
    private String category;
    private String productID;
    private String productName;
    private String price;
    private String isAvailable;

    public Product(String section, String category, String productID, String productName, String price) {
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
    public String getPrice() {
        return price;
    }
    
    

    public static Product searchByID(String ProductID) throws FileNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new FileReader("products.txt"));
        String[] setter;
        String line = "";
        while ((line = input.readLine()) != null) {
            if (line.contains(ProductID)) {
            setter = line.split(",");
                return new Product (setter[0], setter[1], setter[2],
                        setter[3], setter[4]);
            }

        }

        return null;
    }


    public String specificCategory(String Section, String category) throws FileNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new FileReader("products.txt"));
        String[] setter;
        String line = "";
        while ((line = input.readLine()) != null) {
            if (line.contains(Section.trim()) && line.contains(category.trim())) {
                setter = line.split(",");
                return "Product Name: "+setter[3]+" \n"+"Price: "+setter[4];
            }
        }
        return "";
    }

    public void displayProduct() {
    }

}
