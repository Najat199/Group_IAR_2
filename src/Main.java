
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static protected Product currentProduct;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int chioce1;
        int chioce2;
        String chioce3;
        do {

            System.out.println(" *************************************** ");
            System.out.println("                Welcome                  ");
            System.out.println(" *************************************** ");
            System.out.println("1. Man");
            System.out.println("2. Women");
            System.out.println("3. Kids");
            System.out.println("4. Product search");
            System.out.println("5. Exit");
            System.out.print(" Please enter your choice: ");
            chioce1 = input.nextInt();
            if (chioce1 == 1) {
                while (true) {
                    System.out.println(" *************************************** ");
                    System.out.println("               Man Section               ");
                    System.out.println(" *************************************** ");
                    System.out.println("please choose the category you want to buy from: ");
                    System.out.println("1. Bottoms");
                    System.out.println("2. Tops");
                    System.out.println("3. Shoes");
                    System.out.println("4. Watches");
                    System.out.print(" Enter your choice or -1 to exit:");
                    chioce2 = input.nextInt();
                    if (chioce2 == -1) {
                        break;

                    } else if (chioce2 > 4 || chioce2 < 1) {
                        continue;

                    } else {
                        //System.out.println("you are in the Man section");
                    }

                }
            } else if (chioce1 == 2) {
                while (true) {
                    System.out.println(" *************************************** ");
                    System.out.println("              Women Section              ");
                    System.out.println(" *************************************** ");
                    System.out.println("please choose the category you want to buy from: ");
                    System.out.println("1. Bottoms");
                    System.out.println("2. Tops");
                    System.out.println("3. Dresses");
                    System.out.println("4. Shoes");
                    System.out.println("5. Bags");
                    System.out.println("6. Beauty");
                    System.out.print(" Enter your choice or -1 to exit:");
                    chioce2 = input.nextInt();
                    if (chioce2 == -1) {
                        break;

                    } else if (chioce2 > 6 || chioce2 < 1) {
                        continue;

                    } else {

                    }
                }
            } else if (chioce1 == 3) {
                while (true) {
                    System.out.println(" *************************************** ");
                    System.out.println("               Kids Section              ");
                    System.out.println(" *************************************** ");
                    System.out.println("please choose the category you want to buy from: ");
                    System.out.println("1. Bottoms");
                    System.out.println("2. Tops");
                    System.out.println("3. Shoes");
                    System.out.println("4. Toys");
                    System.out.print(" Enter your choice or -1 to exit:");
                    chioce2 = input.nextInt();
                    if (chioce2 == -1) {
                        break;

                    } else if (chioce2 > 4 || chioce2 < 1) {
                        continue;

                    } else {
                        //System.out.println("you are in the Kids section");
                    }

                }
            } else if (chioce1 == 4) {
                System.out.print("Enter the ID of the product you are looking for: ");
                chioce3 = input.next();
                currentProduct = Product.searchByID(chioce3);
                if (currentProduct == null) {
                    System.out.println("your search '" + chioce3 + "' did not match any product");
                } else {
                    System.out.println(" *************************************** ");
                    System.out.println("         " + currentProduct.getSection() + "> " + currentProduct.getCategory() + " Section        ");
                    System.out.println(" *************************************** ");
                    System.out.println("Product Name: " + currentProduct.getProductName());
                    System.out.println("Price: " + currentProduct.getPrice());

                }
            } else {
                System.out.println(" \n\n************ Thank you **************** ");
            }

        } while (chioce1 != 5);
    }

} //        Customer customer=new Customer();
//        System.out.println(customer.makePayment(400));

