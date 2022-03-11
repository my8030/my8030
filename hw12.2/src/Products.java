import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Products {
    public static List<String> products = new ArrayList<>();

    public static void addProduct(String newProduct){
        products.add(newProduct);
        System.out.println("New product in list: " + newProduct);
    }

    public static void printProductList(){
        for (String curProduct: products) {
            System.out.println(curProduct);
        }
        System.out.println();
    }

}
