import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class Product {
    private int id;
    private String name;
    private double price;
    private String category;

    public Product(int i, String s, double v, String electronic) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}

class Platform {
    private String name;
    private String format;

    public Platform(String cimri, String json) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }


}

class FeederSystem {
    private List<Product> products;
    private List<Platform> platforms;

    public FeederSystem(List<Product> products, List<Platform> platforms) {
        this.products = products;
        this.platforms = platforms;
    }

    public void generateFiles() {
        for (Platform platform : platforms) {
            String fileName = platform.getName() + "." + platform.getFormat().toLowerCase();

            try (FileWriter fileWriter = new FileWriter(fileName)) {
                String fileContent = "";
                if (platform.getFormat().equalsIgnoreCase("json")) {
                    fileContent = generateJSON();
                } else if (platform.getFormat().equalsIgnoreCase("xml")) {
                    fileContent = generateXML();
                }

                fileWriter.write(fileContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String generateJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            sb.append("    {\n");
            sb.append("        \"id\": ").append(product.getId()).append(",\n");
            sb.append("        \"name\": \"").append(product.getName()).append("\",\n");
            sb.append("        \"price\": ").append(product.getPrice()).append(",\n");
            sb.append("        \"category\": \"").append(product.getCategory()).append("\"\n");
            sb.append("    }");

            if (i != products.size() - 1) {
                sb.append(",");
            }

            sb.append("\n");
        }

        sb.append("]\n");

        return sb.toString();
    }

    private String generateXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<products>\n");

        for (Product product : products) {
            sb.append("    <product>\n");
            sb.append("        <id>").append(product.getId()).append("</id>\n");
            sb.append("        <name>").append(product.getName()).append("</name>\n");
            sb.append("        <price>").append(product.getPrice()).append("</price>\n");
            sb.append("        <category>").append(product.getCategory()).append("</category>\n");
            sb.append("    </product>\n");
        }

        sb.append("</products>\n");

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product(1, "Product 1", 1.00, "Electronic"),
                new Product(2, "Product 2", 2.00, "Fashion"),
                new Product(3, "Product 3", 3.00, "Home Decor"),
                new Product(3, "Product 4", 4.00, "Electronic"),
                new Product(3, "Product 5", 5.00, "Fashion"),
                new Product(3, "Product 6", 6.00, "Home Decor"),
                new Product(3, "Product 7", 7.00, "Electronic"),
                new Product(3, "Product 8", 8.00, "Fashion"),
                new Product(3, "Product 9", 9.00, "Home Decor"),
                new Product(3, "Product 10",10.00, "Electronic")


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
