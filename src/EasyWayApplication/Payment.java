package EasyWayApplication;

public class Payment {

    double total;

    public Payment(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String paymentDetails() {
        return "The payment amount is " + total;
    }

}
