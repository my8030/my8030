import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static List<String> cart = new ArrayList<>();

    public static void addToCart(String newProduct){
        cart.add(newProduct);
        System.out.println("New product in cart: " + newProduct);
    }

    public static void printProductsInCart(){
        for (String curProduct: cart) {
            System.out.println(curProduct);
        }
        System.out.println();
    }

}
