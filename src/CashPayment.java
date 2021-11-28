/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Win 8.1
 */
public class CashPayment extends Payment{

    public CashPayment(double total) {
        super(total);
    }
    @Override
    public String paymentDetails(){
         return "The payment amount is "+total;
    }
}
