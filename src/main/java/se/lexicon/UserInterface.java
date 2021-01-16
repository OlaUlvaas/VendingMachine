package se.lexicon;
import se.lexicon.data.Communication;
import se.lexicon.data.VendingMachineImpl;
import se.lexicon.model.Chocolate;
import se.lexicon.model.Drink;
import se.lexicon.model.Fruit;
import se.lexicon.model.Product;

import java.util.Arrays;
import java.util.Scanner;

//********************* THE VENDING MACHINE *********************\\

public class UserInterface
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        VendingMachineImpl vm = new VendingMachineImpl();
        Communication co = new Communication();

        vm.products[0] = new Drink(1, "Milk", 18, "Milk from the cow", "30 cl", "Taste like Regular milk") ;
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


        boolean on = true;

        while(on){
            co.welcome();
            System.out.print("Make a choice: ");
            int fromUser = scanner.nextInt();
            switch (fromUser){
                case 1 :
                    System.out.print("How much money do you want to insert? ");
                    int moneyInsert = scanner.nextInt();
                    vm.addCurrency(moneyInsert);
                    break;
                case 2 :
                    System.out.println("There is " + vm.getBalance() + " SEK in the Moneypool");
                    break;
                case 3 :
                    System.out.print("Please enter productnumber: ");
                    int productNumber = scanner.nextInt();
                    Product theOne = vm.request(productNumber);
                    System.out.println(theOne.toString());
                    System.out.println(theOne.use());
                    break;
                case 4 :
                    System.out.println("Thanks for your purchase, you get " + vm.endSession() + " SEK" +
                            "  back in change.");
                    break;
                case 5 :
                    String[] strArray = vm.getProducts();
                    System.out.println("\n********************* THE VENDING MACHINE MENY *********************");
                    for(int i = 0; i < vm.products.length; i++){
                        System.out.println(strArray[i]);
                    }
                    System.out.println();
                    break;
                case 6 :
                    System.out.print("Please enter productnumber: ");
                    int prodNumber = scanner.nextInt();
                    System.out.println(vm.getDescription(prodNumber));
                    break;
                case 7 :
                    System.out.println("*** Welcome back ***");
                    on = false;
                    break;
                default:
                    System.out.println("\nYour choice must be a number between 1 and 6.\n");
            }
        }
        scanner.close();
    }
}

