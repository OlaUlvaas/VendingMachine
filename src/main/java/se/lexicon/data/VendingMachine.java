package se.lexicon.data;

import se.lexicon.model.Product;

public interface VendingMachine {

    void addCurrency(int amount); // Add to deposit pool

    Product request(int productNumber); // Buy a product

    int endSession(); // Returns change and reset the deposit pool

    String getDescription(int productNumber); // View a product description

    int getBalance(); // Returns the deposit pool amount

    String[] getProducts(); // Returns all Products names and products numbers





}
