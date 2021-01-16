package se.lexicon.data;


import se.lexicon.model.Product;

public class VendingMachineImpl implements VendingMachine {

    int moneypool = 0;

    int[] denominations = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
    public Product[] products = new Product[15];



    @Override
    public void addCurrency(int amount) {
        if(amount == denominations[0] || amount == denominations[1] || amount == denominations[2] ||
                amount == denominations[3] || amount == denominations[4]  || amount == denominations[5]  ||
                amount == denominations[6]  || amount == denominations[7]  || amount == denominations[8]  ||
                amount == denominations[9] ){

                moneypool += amount;


        }else{
            System.out.println("Not a valid amount");
        }
    }

    @Override
    public Product request(int productNumber) {
        for(int i = 0; i < products.length; i++){

            if(products[i].getProductNumber() == productNumber){
                if(moneypool >= products[i].getPrice()){
                    moneypool -= products[i].getPrice();
                    return products[i];
                }
            }
        }
        return null;
    }

    @Override
    public int endSession() {
        int change = moneypool;

        moneypool = 0;
        return change;
    }

    @Override
    public String getDescription(int productNumber) {
        for(int i = 0; i < products.length; i++){
            if(products[i].getProductNumber() == productNumber){
                return products[i].examine();
            }
        }
        return null;
    }

    @Override
    public int getBalance() { // ok
        return moneypool;
    }

    @Override
    public String[] getProducts() { // ok

        String[] strArray = new String[15];

        for(int i = 0; i < products.length; i++){
            strArray[i] = products[i].getProductNumber() + " - " + products[i].getProduct();
        }
        return strArray;
    }
}
