package EasyWayApplication;

import java.util.Date;

public class Order {

    private int customerID;
    private String orderNumber;
    private Date orderDate;
    private Date shipDate;
    private String shipTo;
    private String status;
    private Product[] productsArray;
    private double totalPrice;

    public Order() {
    }

    public void cancelOrder() {
    }

    public void displayOrderReport() {
    }
}
