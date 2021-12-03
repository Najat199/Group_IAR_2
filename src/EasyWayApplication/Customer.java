package EasyWayApplication;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Customer extends Person {

    private int customerID;
    private String cardNum;
    private String CVV;
    private String cardExpirationDate;
    private double points;
    private double totalPrice=0;
    private ArrayList <Product> FavoriteProdects=new ArrayList<Product>();
    private ArrayList <Product> cartProduct=new ArrayList<Product>();
    Scanner input=new Scanner(System.in);
    
    public Customer() {
        
        
    }

    public boolean addProductToFavorite(Product currentProduct) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Favorites.txt", true)));
            out.println(currentProduct.getProductID());
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println("Sorry, something went wrong :(");
           
        }
      return FavoriteProdects.add(currentProduct);

    }

    public boolean addProductToCart(Product currentProduct) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Cart.txt", true)));
            out.println(currentProduct.getProductID());
            cartProduct.add(currentProduct);
            out.flush();
            out.close();
        } catch (IOException e) {
           System.out.println("Sorry, something went wrong :(");
        }
return cartProduct.add(currentProduct);
    }
   
    
    public double getTotalPrice(){
        for(int i=0;i<cartProduct.size();i++){
         totalPrice=totalPrice+cartProduct.get(i).getPrice();
        }
        return totalPrice;
    }
    
   public String makePayment() {
      double total=getTotalPrice();
        while(true){
        System.out.println("Please choose the pament method you prefer :");
        System.out.println(" ********************************************** ");
        System.out.println("1.CASH");
        System.out.println("2.CREDIT CARD");
        System.out.println(" ********************************************** ");
        int choosenNumberForPymmentMethod=input.nextInt();
        switch(choosenNumberForPymmentMethod){
            case 1 :System.out.println("\t\tPay by cash");
                    System.out.println(" ********************************************** ");
                    CashPayment cashPayment=new CashPayment(total);
                    System.out.print("Please enter your location :");
                    super.setAddress(input.next());
                    return "\nThank you for shopping from Easy Way System :)\n"
                            +" ********************************************** \n"
                            +cashPayment.paymentDetails()
                            +"\nYour order is on its way to you!!";
                   
            case 2 :System.out.println("\t\tPay by credit card");
                    System.out.println(" ********************************************** ");
                    System.out.println("Please enter the credit card information :");
                    System.out.print("A credit card number must have between 13 and 16 digits): \nIt must start with:\n"
                            + "4 for Visa cards\n" +
                              "5 for Master cards\n" +
                              "37 for American Express cards\n" +
                              "6 for Discover cards\n\nCard number : ");
                        cardNum=input.next();
                          while(!Checker.isValidCardNumber(cardNum)){
                                 System.out.println("Invalid Card number ,please enter a valid Card number again :");
                                 cardNum=input.next();}
                           
                    System.out.print("Card expiration date in MM/YY format : ");
                    cardExpirationDate=input.next();
                    while(!Checker.isValidExpiryDate(cardExpirationDate)){
                        System.out.println("Invalid expiration date ,please enter a valid expiration date again :");
                        cardExpirationDate=input.next();
                    }
                    System.out.print("CVV (It should be 3 0r 4 digits): ");
                    CVV=input.next();
                        while(!Checker.isValidCVVNumber(CVV)){
                        System.out.println("Invalid CVV ,please enter a valid CVV again :");
                        CVV=input.next();
                    }
                    System.out.print("Please enter your location :");
                    super.setAddress(input.next());
                   CreditCardPayment creditCardPayment =new CreditCardPayment(total,cardNum,cardExpirationDate,CVV);
                    return "\nThank you for shopping from Easy Way System :)\n"
                            +" ********************************************** \n"
                            +creditCardPayment.paymentDetails()+
                            "\nYour order is on its way to you!!";
                            
                     
            default:return "invalid choise"; 
            
        }
        }
        
    }
    
     
}
