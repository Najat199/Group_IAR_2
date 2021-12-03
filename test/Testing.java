
import EasyWayApplication.Customer;
import EasyWayApplication.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Win 8.1
 */
public class Testing {
    
    public Testing() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
     @Test
    public void testAddToFavoriteMethod (){
        Customer testAddFav = new Customer();
        Product currentProduct = new Product("Man", "Bottoms", "11220", "Pants", 88.0);
        assertTrue(testAddFav.addProductToFavorite(currentProduct));
    }
    
    
   @Test
    public void testAddToCartMethod (){
        Customer testAddCart = new Customer();
        Product currentProduct = new Product("Men", "Tops", "11231", "shirt", 72.0);
        assertTrue(testAddCart.addProductToCart(currentProduct));
    } 
    
    
}
