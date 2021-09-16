package UI;

import Item.*;
import Knight.Knight;

import java.util.Locale;
import java.util.Scanner;

public class UI {
    private static final Knight k = new Knight();

    private static void add(Scanner sc) {
        while(true) {
            System.out.println("""
                    You can add new ammunition using next command:
                    TYPE_OF_AMMUNITION WEIGHT PRICE
                    where 'TYPE_OF_AMMUNITION' can be:
                    HELMET, ARMOR, WEAPON, GAUNTLETS, TROUSERS, SHOES;
                    'WEIGHT' is weight in grams
                    'PRICE' is price of thing in dollars
                    Enter EXIT to finish adding new items
                    """);
            String text = sc.nextLine().toLowerCase(Locale.ROOT);
            System.out.println();
            String[] command = text.split(" ");
            if (command.length < 4) {
                try {
                    if (command[0].equals("exit") || command[0].equals("e")) {
                        break;
                    }
                    int weight = Integer.parseInt(command[1]);
                    int price = Integer.parseInt(command[2]);
                    switch (command[0]) {
                        case "helmet","h" -> k.addItem(new Helmet(weight, price));
                        case "armor","a" -> k.addItem(new Armor(weight, price));
                        case "weapon","w" -> k.addItem(new Weapon(weight, price));
                        case "gauntlets","g" -> k.addItem(new Gauntlets(weight, price));
                        case "trousers","t" -> k.addItem(new Trousers(weight, price));
                        case "shoes","s" -> k.addItem(new Shoes(weight, price));
                        default -> System.out.println("Unknown command, try again\n");
                    }
                }
                catch (Exception e){
                    System.out.println("Weight or price are not numbers\n");
                }
            }
            else{
                System.out.println("Command contains to many parameters\n");
            }
        }
    }

    private static void calculate(){
        System.out.println("Summary: " + k.calculatePrice() + "\n");
    }

    private static void sort(){
        k.sortInventory();
    }

    private static void find(Scanner sc){
        while (true){
            System.out.println("Enter the range of price");
            String text = sc.nextLine().toLowerCase(Locale.ROOT);
            System.out.println();
            String[] command = text.split(" ");
            if (command.length == 2) {
                try {
                    int min_price = Integer.parseInt(command[0]);
                    int max_price = Integer.parseInt(command[1]);
                    k.findInRange(min_price,max_price).forEach(System.out::println);
                    System.out.println();
                    break;
                }
                catch (Exception e){
                    System.out.println("Weight or price are not numbers\n");
                }
            }
            else{
                System.out.println("Command contains to many parameters\n");
            }
        }
    }

    private static void show(){
        k.get_inventory().forEach(System.out::println);
        System.out.println();
    }

    private static void remove(Scanner sc){
        while(true) {
            System.out.println("""
                    You can remove ammunition using next command:
                    TYPE_OF_AMMUNITION WEIGHT PRICE
                    where 'TYPE_OF_AMMUNITION' can be:
                    HELMET, ARMOR, WEAPON, GAUNTLETS, TROUSERS, SHOES;
                    'WEIGHT' is weight in grams
                    'PRICE' is price of thing in dollars
                    Enter EXIT to finish removing items
                    """);
            String text = sc.nextLine().toLowerCase(Locale.ROOT);
            System.out.println();
            String[] command = text.split(" ");
            if (command.length < 4) {
                try {
                    if (command[0].equals("exit") || command[0].equals("e")) {
                        break;
                    }
                    int weight = Integer.parseInt(command[1]);
                    int price = Integer.parseInt(command[2]);
                    boolean removed = false;
                    boolean def = false;
                    switch (command[0]) {
                        case "helmet","h" -> removed = k.removeItem(new Helmet(weight, price));
                        case "armor","a" -> removed = k.removeItem(new Armor(weight, price));
                        case "weapon","w" -> removed = k.removeItem(new Weapon(weight, price));
                        case "gauntlets","g" -> removed = k.removeItem(new Gauntlets(weight, price));
                        case "trousers","t" -> removed = k.removeItem(new Trousers(weight, price));
                        case "shoes","s" -> removed = k.removeItem(new Shoes(weight, price));
                        default -> {
                            System.out.println("Unknown command, try again\n");
                            def = true;
                        }

                    }
                    if (removed){
                        System.out.println("Successfully removed item");
                    }
                    else if(!def){
                        System.out.println("Item not found");
                    }
                }
                catch (Exception e){
                    System.out.println("Weight or price are not numbers\n");
                }
            }
            else{
                System.out.println("Command contains to many parameters\n");
            }
        }
    }

    private static void clear(){
        k.clear();
    }

    public static void Menu(){
        boolean cont = true;
        while (cont) {
            System.out.println("""
                    Enter command ADD to add new ammunition to the knight
                    Enter command CALCULATE to get price of inventory
                    Enter command SORT to sort all ammunition by weight
                    Enter command FIND to find ammunition within a range of price
                    Enter command SHOW to show all ammunition
                    Enter command REMOVE to delete an item
                    Enter command CLEAR to delete all ammunition
                    Enter command EXIT to finish work with database
                    """);
            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine().toLowerCase(Locale.ROOT);
            System.out.println();
            switch (command) {
                case "add","a"->add(sc);
                case "calculate", "calc"->calculate();
                case "sort"->sort();
                case "find","f"->find(sc);
                case "show","s"->show();
                case "remove","r"->remove(sc);
                case "clear","c"->clear();
                case "exit","e"->cont = false;
                default->System.out.println("Unknown command, try again\n");
            }
        }
    }
}
