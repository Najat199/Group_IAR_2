
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Customer extends Person {

    private int customerID;
    private String cardNum;
    private String CVV;
    private String cardExpirationDate;
    private double points;
    private ArrayList FavoriteProdects;
    private ArrayList cartProduct;
    Scanner input=new Scanner(System.in);
    
    public Customer() {
    }

    
    public String returnProducts() {
        return null;
    }

    public String makePayment(double total) {
        while(true){
        System.out.println("Please choose the payment method you prefer :");
        System.out.println("---------------------------------------------");
        System.out.println("1.CASH");
        System.out.println("2.CREDIT CARD");
        int choosenNumberForPymmentMethod=input.nextInt();
        switch(choosenNumberForPymmentMethod){
            case 1 :System.out.println("\t\tPay by cash");
                    System.out.println("---------------------------------------------");
                    CashPayment cashPayment=new CashPayment(total);
                    return cashPayment.paymentDetails();
                   
            case 2 :System.out.println("\t\tPay by credit card");
                    System.out.println("---------------------------------------------");
                    System.out.println("Please enter the credit card information :");
                    System.out.print("Card number : ");
                    cardNum=input.next();
                    System.out.print("Card expiration date : ");
                    cardExpirationDate=input.next();
                    System.out.print("CVV : ");
                    CVV=input.next();
                   CreditCardPayment creditCardPayment =new CreditCardPayment(total,cardNum,cardExpirationDate,CVV);
                    return creditCardPayment.paymentDetails();
                   
            default:return "invalid choise"; 
            
        }
        }
        
    }
    
     private Date parsedate(String birthDate) {
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = parser.parse(birthDate);
        } catch (ParseException ex) {
        }

        return date;
    }
     
 
    public boolean addToFavorite(int productID){
     
         
        
        return true; 
        }
        
        
        
       
    
     public void addToCart(int productID){
        
    }
}
