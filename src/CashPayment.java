
public class CashPayment extends Payment{

    public CashPayment(double total) {
        super(total);
    }
    @Override
    public String paymentDetails(){
         return "The payment amount is "+total;
    }
}
