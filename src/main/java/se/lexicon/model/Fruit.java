package se.lexicon.model;

import java.util.Objects;

public class Fruit extends Product{

    private String color;

    public Fruit(){
        //super();
    }

    public Fruit(int productNumber, String product, int price, String text, String color) {
        super(productNumber, product, price, text);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String examine() {
        return "Mmm... " + getColor() + " " + getProduct() + "s is really delicious, and it costs only " + getPrice() + " SEK.";
    }

    @Override
    public String use() {
        return "This " + getProduct() + " was so small. Maybe I need another one.";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(color, fruit.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }

    @Override
    public String toString() {
        return "You buy a healty " + getProduct();
    }
}
