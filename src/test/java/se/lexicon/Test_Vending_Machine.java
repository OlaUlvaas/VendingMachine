package se.lexicon;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.data.*;
import se.lexicon.model.*;
import se.lexicon.model.Product;

public class Test_Vending_Machine {

    VendingMachineImpl vm = new VendingMachineImpl();

    @Before
    public void setup(){
        vm.products[0] = new Drink(1, "Milk", 18, "Milk from the cow", "30 cl", "Taste like Regular milk");
        vm.products[1] = new Drink(2,"Soda Water", 25, "Sparkling water of the best quality", "50 cl", "Taste like Water of Life");
        vm.products[2] = new Drink(3,"Coca-Cola", 29, "Secret ingredients", "50 cl", "Taste like Saturday all week");
        vm.products[3] = new Drink(4,"Red Bull", 24, "Gives you wings", "25 cl", "Taste like Awakening");
        vm.products[4] = new Drink(5,"Orange Juice", 27, "Freshly squeezed love", "50 cl", "Taste like Summer");

        vm.products[5] = new Fruit(6, "Orange", 15, "A lot of Vitamin C", "Color of the sun colored");
        vm.products[6] = new Fruit(7, "Banana", 12, "A boome-boomerang", "Yellow");
        vm.products[7] = new Fruit(8, "Pear", 10, "What a body", "Green");
        vm.products[8] = new Fruit(9, "Apple", 10, "A Red Apple", "Red");
        vm.products[9] = new Fruit(10, "Apple", 10, "A Green Apple", "Green");

        vm.products[10] = new Chocolate(11, "Daim", 12, "It doesn't depend on the size", "28 gram", "Taste like Heaven");
        vm.products[11] = new Chocolate(12, "Dubble Daim", 20, "Just two pieces", "56 gram", "Taste like Heaven squared");
        vm.products[12] = new Chocolate(13, "Milka Alpine Milk", 99, "Favorite from Switzerland ", "270 gram", "Taste like Paradise");
        vm.products[13] = new Chocolate(14, "Dubble Japp", 20, "Two is more than one", "60 gram", "Taste like A Double");
        vm.products[14] = new Chocolate(15, "Milk Chocolate", 19, "Has always existed", "100 gram", "Taste like Old School");
    }

    @Test
    public void test_addCurrency_correct_amount(){

        vm.addCurrency(1);
        vm.addCurrency(1000);
        vm.addCurrency(2);

        int expectedValue = 1003;
        int actualValue = vm.getBalance();
        Assert.assertEquals(expectedValue, actualValue);

        vm.addCurrency(50);
        int expValue = 1053;
        int actValue = vm.getBalance();
        Assert.assertEquals(expValue, actValue);
    }

    @Test
    public  void test_addCurrency_not_correct_amount(){

        vm.addCurrency(39);
        int expValue = 0;
        int actValue = vm.getBalance();
        Assert.assertFalse(actValue > expValue);

        vm.addCurrency(-115);
        int eValue = 0;
        int aValue = vm.getBalance();
        Assert.assertFalse(aValue < eValue);
    }

    @Test
    public void test_request_correct_numbers(){
        vm.request(1);
        int expectedProductNumber = 1;
        int actualProductNumber = vm.products[expectedProductNumber - 1].getProductNumber();
        Assert.assertEquals(expectedProductNumber, actualProductNumber);

        vm.request(15);
        int expProductNumber = 15;
        int actProductNumber = vm.products[expProductNumber - 1].getProductNumber();
        Assert.assertEquals(expProductNumber, actProductNumber);
    }

    @Test
    public void test_endSession_back_in_change(){
        vm.addCurrency(100);
        vm.request(5);

        int expectedValue = 73;
        int actualValue = vm.endSession();
        Assert.assertEquals(expectedValue, actualValue);

        vm.addCurrency(20);
        vm.request(10);

        int expValue = 10;
        int actValue = vm.endSession();
        Assert.assertEquals(expValue, actValue);
    }

    @Test
    public void test_endSession_if_reset_after_completed_purchase(){
        vm.addCurrency(100);
        vm.request(5);

        int expectedValue = 73;
        vm.endSession();

        expectedValue = 0;
        int actualValue = vm.getBalance();
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void test_getDescription_correct() {

        String expectedResult = "Mmm... Yellow Bananas is really delicious, and it costs only 12 SEK.";
        String actualResult = vm.getDescription(7);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_getDescription_incorrect() {

        String expectedResult = "Mmm... Yellow Bananas is really delicious, and it costs only 12 SEK.";
        String actualResult = vm.getDescription(6);
        Assert.assertFalse(expectedResult == actualResult);
    }

    @Test
    public void test_getBalance_correct(){

        vm.addCurrency(1000);
        vm.addCurrency(200);
        vm.addCurrency(5);
        vm.request(13);

        int expectedValue = 1106;
        int actualValue = vm.getBalance();

        Assert.assertEquals(expectedValue, actualValue);


        vm.request(7);
        int expValue = 1094;
        int actValue = vm.getBalance();

        Assert.assertEquals(expValue, actValue);
    }

    @Test
    public void test_getProduct_correct(){

        Product[] expectedArray = {
                vm.products[0] = new Drink(1, "Milk", 18, "Milk from the cow", "30 cl", "Taste like Regular milk"),
        vm.products[1] = new Drink(2,"Soda Water", 25, "Sparkling water of the best quality", "50 cl", "Taste like Water of Life"),
        vm.products[2] = new Drink(3,"Coca-Cola", 29, "Secret ingredients", "50 cl", "Taste like Saturday all week"),
        vm.products[3] = new Drink(4,"Red Bull", 24, "Gives you wings", "25 cl", "Taste like Awakening"),
        vm.products[4] = new Drink(5,"Orange Juice", 27, "Freshly squeezed love", "50 cl", "Taste like Summer"),

        vm.products[5] = new Fruit(6, "Orange", 15, "A lot of Vitamin C", "Color of the sun colored"),
        vm.products[6] = new Fruit(7, "Banana", 12, "A boome-boomerang", "Yellow"),
        vm.products[7] = new Fruit(8, "Pear", 10, "What a body", "Green"),
        vm.products[8] = new Fruit(9, "Apple", 10, "A Red Apple", "Red"),
        vm.products[9] = new Fruit(10, "Apple", 10, "A Green Apple", "Green"),

        vm.products[10] = new Chocolate(11, "Daim", 12, "It doesn't depend on the size", "28 gram", "Taste like Heaven"),
        vm.products[11] = new Chocolate(12, "Dubble Daim", 20, "Just two pieces", "56 gram", "Taste like Heaven squared"),
        vm.products[12] = new Chocolate(13, "Milka Alpine Milk", 99, "Favorite from Switzerland ", "270 gram", "Taste like Paradise"),
        vm.products[13] = new Chocolate(14, "Dubble Japp", 20, "Two is more than one", "60 gram", "Taste like A Double"),
        vm.products[14] = new Chocolate(15, "Milk Chocolate", 19, "Has always existed", "100 gram", "Taste like Old School")
    };
        Product[] actualArray = vm.products;

        Assert.assertArrayEquals(expectedArray, actualArray);
    }
}
