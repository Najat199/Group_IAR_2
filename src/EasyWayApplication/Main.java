package EasyWayApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static protected Product currentProduct;
	static protected Scanner input;
       

	public static void main(String[] args) throws IOException {
                Customer customer=new Customer();
		input = new Scanner(System.in);
		while (true) {
			PrintMainMenu();
			int chioce1 = input.nextInt();
			switch (chioce1) {
			case 1:
				PrintManMenu(customer);
				break;
			case 2:
				PrintWomenMenu(customer);
				break;
			case 3:
				PrintKidMenu(customer);
				break;
			case 4:
				SearchProduct();
                              break;
			
			case 5:
                         Product.PrintFavorites();
				break;
                        case 6 :Product.PrintCart();
				break;
                        case 7 :System.out.println(customer.makePayment()); 
                                break;
                        case 8 :
                             System.out.println(" \n\n***** Thank you ******* ");
                             System.exit(0); 
                             break;
                            
			default:
				System.out.println(" \n\nPlease Enter correct option");

			}
		}

	}

	
	private static void PrintProducts(String section, String category,Customer customer) {

		while (true) {
			System.out.println(" *************************************** ");
			ArrayList<Product> products = Product.getSectionCategoryProducts(section, category);
			for (int i = 0; i < products.size(); i++) {
				System.out.println((i + 1) + "-" + products.get(i));
			}
			System.out.print(" Enter your choice or -1 to exit:");

			int productindex = input.nextInt();
			if (productindex == -1) {
				return;
			}
			if (productindex > products.size() || productindex < 1) {
				continue;
			}
			currentProduct = products.get(productindex - 1);
			break;
		}
        
		while (true) {
			System.out.println(" *************************************** ");
			System.out.println("              product Selected           ");
			System.out.println(" *************************************** ");
			System.out.println("please choose what do you want to do with this product ");
			System.out.println("1. add to Favorite");
			System.out.println("2. add to cart");
                        
			System.out.print(" Enter your choice or -1 to exit:");
			int option = input.nextInt();
			switch (option) {
			case -1:
				return;
			case 1:
				customer.addProductToFavorite(currentProduct);
				System.out.println("Product Added to Favorites");
				return;
			case 2:
                            customer.addProductToCart(currentProduct);
			System.out.println("Product Added to Cart");
                         
				return;
                       
                          
			default:
				System.out.println(" \n\nPlease Enter correct option");
				break;

			}
		}

	}

	private static void SearchProduct() throws IOException {
		System.out.print("Enter the ID of the product you are looking for: ");
		String itmeID = input.next();
		currentProduct = Product.searchByID(itmeID);
		if (currentProduct == null) {
			System.out.println("your search '" + itmeID + "' did not match any product");
		} else {
			System.out.println(" *************************************** ");
			System.out.println("         " + currentProduct.getSection() + "> " + currentProduct.getCategory()
					+ " Section        ");
			System.out.println(" *************************************** ");
			System.out.println("Product Name: " + currentProduct.getProductName());
			System.out.println("Price: " + currentProduct.getPrice());

		}

	}

	private static void PrintWomenMenu(Customer customer) {

		String[] options = { "Bottoms", "Tops", "Dresses", "Shoes", "Bags", "Beauty" };
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

			int category = input.nextInt();
			if (category == -1) {
				return;
			}
			if (category > 6 || category < 1) {
				continue;
			}
			PrintProducts("Women", options[category - 1],customer);
		}

	}

	private static void PrintKidMenu(Customer customer) {
		String[] options = { "Bottoms", "Tops", "Shoes", "Toys" };
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
			int category = input.nextInt();
			if (category == -1) {
				return;
			}
			if (category > 4 || category < 1) {
				continue;
			}
			PrintProducts("kids", options[category - 1],customer);
		}

	}

	private static void PrintManMenu(Customer customer) {
		String[] options = { "Bottoms", "Tops", "Shoes", "Watches" };
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
			int category = input.nextInt();
			if (category == -1) {
				return;
			}
			if (category > 4 || category < 1) {
				continue;
			}

			PrintProducts("Man", options[category - 1],customer);

		}

	}




	private static void PrintMainMenu() {
		System.out.println(" *************************************** ");
		System.out.println("      Welcome to Easy Way system         ");
		System.out.println(" *************************************** ");
		System.out.println("1. Man");
		System.out.println("2. Women");
		System.out.println("3. Kids");
		System.out.println("4. Product search");
		System.out.println("5. Print Favorites");
		System.out.println("6. Print cart");
                System.out.println("7. Make Payment");
                System.out.println("8. Exit");
		System.out.print(" Please enter your choice: ");

	}
}