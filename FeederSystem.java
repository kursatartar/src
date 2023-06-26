import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
