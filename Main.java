import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("1", "Product 1", 1.00, "Electronic"),
                new Product("2", "Product 2", 2.00, "Fashion"),
                new Product("3", "Product 3", 3.00, "Home Decor"),
                new Product("4", "Product 4", 4.00, "Electronic"),
                new Product("5", "Product 5", 5.00, "Fashion"),
                new Product("6", "Product 6", 6.00, "Home Decor"),
                new Product("7", "Product 7", 7.00, "Electronic"),
                new Product("8", "Product 8", 8.00, "Fashion"),
                new Product("9", "Product 9", 9.00, "Home Decor"),
                new Product("10", "Product 10",10.00, "Electronic")


        );

        // Sample platforms
        List<Platform> platforms = List.of(
                new Platform("Cimri", "JSON"),
                new Platform("Google", "XML"),
                new Platform("Facebook" , "XML")
                // Add more platforms here
        );

        FeederSystem feederSystem = new FeederSystem(products, platforms);
        feederSystem.generateFiles();
    }
}
