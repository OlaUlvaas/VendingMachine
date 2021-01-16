package se.lexicon.model;

import java.util.Objects;

public abstract class Product {

    private int productNumber;
    private String product;
    private int price;
    private String text;


    // Constructors
    public Product() {

    }

    public Product(int productNumber, String product, int price, String text) {
        this.productNumber = productNumber;
        this.product = product;
        this.price = price;
        this.text = text;
    }

    // Abstract classes
    public abstract String examine();

    public abstract String use();

    // Getters & setters
    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product1 = (Product) o;
        return productNumber == product1.productNumber && price == product1.price && Objects.equals(product, product1.product) && Objects.equals(text, product1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNumber, product, price, text);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber=" + productNumber +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", text='" + text + '\'' +
                '}';
    }
}
