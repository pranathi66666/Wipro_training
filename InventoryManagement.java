// Product class
class Product {
    private String id;
    private String name;
    private int stockLevel;
    private double price;

    public Product(String id, String name, int stockLevel, double price) {
        this.id = id;
        this.name = name;
        this.stockLevel = stockLevel;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public double getPrice() {
        return price;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", stockLevel=" + stockLevel +
                ", price=" + price +
                '}';
    }
}

// Supplier interface
interface Supplier {
    void supplyProduct(Product product, int quantity);
    String getSupplierDetails();
}

// Implementation of Supplier
class LocalSupplier implements Supplier {
    private String supplierName;
    private String contactInfo;

    public LocalSupplier(String supplierName, String contactInfo) {
        this.supplierName = supplierName;
        this.contactInfo = contactInfo;
    }
