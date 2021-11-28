
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Win 8.1
 */
public class CreditCardPayment extends Payment {
    String cardNumber,cardExpirationDate,CVV;
    File file=new File("CreditCardnformation.txt");


    public CreditCardPayment(double total,String cardNumber, String cardExpirationDate, String CVV) {
        super(total);
        this.cardNumber = cardNumber;
        this.cardExpirationDate = cardExpirationDate;
        this.CVV = CVV;
        
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print("The payment amount : "+total
                           +"\npayed by the card : "+cardNumber
                           +"\nwith the expiry date : "+cardExpirationDate
                           +"\nCVV : "+CVV);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry file not found!");
        }
        
    }
    
    @Override
    public String paymentDetails(){
        return "The payment amount : "+total
                           +"\npayed by the card : "+cardNumber
                           +"\nwith the expiry date : "+cardExpirationDate;
    }
}
