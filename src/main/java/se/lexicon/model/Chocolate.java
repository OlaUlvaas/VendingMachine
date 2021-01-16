package se.lexicon.model;

import java.util.Objects;

public class Chocolate extends Product {

    private String weight;
    private String taste;


    public Chocolate(){
        //super();
    }
    public Chocolate(int productNumber, String product, int price, String text, String weight, String taste) {
        super(productNumber, product, price, text);
        this.weight = weight;
        this.taste = taste;
    }


    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }


    @Override
    public String examine() {
        return "Dont eat too much " + getProduct() + " " + getWeight() + " even if it " + getTaste() + " and it costs only " + getPrice() + " SEK.";
    }

    @Override
    public String use() {
        return "This " + getProduct() + " makes me speedy.";
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chocolate chocolate = (Chocolate) o;
        return Objects.equals(weight, chocolate.weight) && Objects.equals(taste, chocolate.taste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight, taste);
    }

    @Override
    public String toString() {
        //return examine();
        return "Oh, you buy a " + getProduct();
    }
}
