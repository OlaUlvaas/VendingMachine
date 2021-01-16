package se.lexicon.model;

import java.util.Objects;

public class Drink extends Product{

    private String volume;
    private String taste;



    public Drink(){
        //super();

    }

    public Drink(int productNumber, String product, int price, String text, String volume, String taste) {
        super(productNumber, product, price, text);
        this.volume = volume;
        this.taste = taste;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public String examine() {
        return "This " + getProduct() + " is one of my favorites. It " + getTaste() +
                " and the price for " + getVolume() + " is only " + getPrice() + " SEK.";
    }

    @Override
    public String use() {
        return "Gulp, gulp, gulp... " + getProduct() + " is empty.";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Drink drink = (Drink) o;
        return volume == drink.volume && Objects.equals(taste, drink.taste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume, taste);
    }

    @Override
    public String toString() {
        return "You buy a " + getProduct() + " I hope it can wake you up!";
    }
}
