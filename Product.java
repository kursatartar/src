class Product {
    private String id;  //id için string tercih ettim çünkü ileride trafik artar ve
    // birden fazla sunucu olursa duplicate id'leri engellemek
    // zor olabilir diye düşündüm.
    private String name;
    private double price;
    private String category;

    public Product(String i, String n, double p, String categ) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
