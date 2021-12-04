
import EasyWayApplication.CashPayment;
import EasyWayApplication.CreditCardPayment;
import EasyWayApplication.Customer;
import EasyWayApplication.Product;
import org.junit.Test;
import static org.junit.Assert.*;

public class Testing {

    Customer customer = new Customer();
    Product product1 = new Product("Man", "Bottoms", "11220", "Pants", 88.0);
    Product product2 = new Product("Women", "Dresses", "12451", "halter", 89.00);

    @Test
    public void testAddToFavoriteMethod() {
        assertTrue(customer.addProductToFavorite(product1));
    }

    @Test
    public void testAddToCartMethod() {
        assertTrue(customer.addProductToCart(product1));
    }

    @Test
    public void testMakePaymentByCash() {
        customer.addProductToCart(product1);
        customer.addProductToCart(product2);
        CashPayment cashPaymentObject = customer.makePaymentByCash(customer.getTotalPrice());
        assertNotNull(cashPaymentObject);
    }
    @Test
     public void testMakePaymentByCreditCard(){
      customer.addProductToCart(product1);
      customer.addProductToCart(product2);
      CreditCardPayment creditCardPaymentObject=customer.makePaymentByCreditCard(customer.getTotalPrice());
      assertNotNull(creditCardPaymentObject);
    }
}
