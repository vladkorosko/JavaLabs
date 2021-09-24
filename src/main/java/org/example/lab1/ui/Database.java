package org.example.lab1.ui;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class Database {
    //    private static int numberOfKnight = 1;
    private static final String DB_URL = "jdbc:sqlite:knights.db";

    private static void initDataBase() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void createTable() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement() ) {
            statement.executeUpdate("DROP TABLE IF EXISTS knight");     //+numberOfKnight);
            statement.executeUpdate("CREATE TABLE knight"               //+numberOfKnight
                    + " (type string, weight integer, price integer)");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void addSQL(String type, int weight, int price) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement() ) {

            statement.executeUpdate("insert into knight"                //+numberOfKnight
                    + " values("+"'"+type+"', "+ weight + ", " +price+")");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

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
                        case "helmet","h" -> addSQL("Helmet", weight, price);
                        case "armor","a" -> addSQL("Armor", weight, price);
                        case "weapon","w" -> addSQL("Weapon", weight, price);
                        case "gauntlets","g" -> addSQL("Gauntlets", weight, price);
                        case "trousers","t" -> addSQL("Trousers", weight, price);
                        case "shoes","s" -> addSQL("Shoes", weight, price);
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
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement() ) {
            System.out.println(statement.executeQuery("SELECT SUM(price) FROM knight").getInt(1));
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void sortSQL(){
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement() ) {
            ResultSet rs = statement.executeQuery("SELECT * FROM knight ORDER BY weight");
            while(rs.next()){
                System.out.println("Type: " + rs.getString("type")
                            + ", Weight: " + rs.getInt("weight")
                            + ", Price: " + rs.getInt("price"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void sort(){
        sortSQL();
        System.out.println();
    }

    private static void findInRangeSQL(int min_price, int max_price){
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement() ) {
            ResultSet rs = statement.executeQuery("SELECT * FROM knight "
                    + "where weight >= "+ min_price+ " AND weight <= " + max_price);
            while(rs.next()){
                System.out.println("Type: " + rs.getString("type")
                        + ", Weight: " + rs.getInt("weight")
                        + ", Price: " + rs.getInt("price"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
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
                    findInRangeSQL(min_price, max_price);
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
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement() ) {
            ResultSet rs = statement.executeQuery("select * from knight order by weight");
            while(rs.next()){
                System.out.println("Type: " + rs.getString("type")
                        + ", Weight: " + rs.getInt("weight")
                        + ", Price: " + rs.getInt("price"));
            }
            rs.close();
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void removeSQL(String type, int weight, int price){
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement() ) {
            statement.executeUpdate("DELETE FROM knight " +
                    "WHERE type = '" + type + "' AND weight = "+weight
                    + " AND price = " + price);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
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
                    switch (command[0]) {
                        case "helmet","h" -> removeSQL("Helmet", weight, price);
                        case "armor","a" -> removeSQL("Armor", weight, price);
                        case "weapon","w" -> removeSQL("Weapon", weight, price);
                        case "gauntlets","g" -> removeSQL("Gauntlets", weight, price);
                        case "trousers","t" -> removeSQL("Trousers", weight, price);
                        case "shoes","s" -> removeSQL("Shoes", weight, price);
                        default -> {
                            System.out.println("Unknown command, try again\n");
                        }
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
        createTable();
    }

/*    private static void createNew() {
        numberOfKnight++;
        createTable();
    }*/

    private static void menu(){
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
                    """);//Enter command NEW to create new knight
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
                //case "new", "n"->createNew();
                case "exit","e"->cont = false;
                default->System.out.println("Unknown command, try again\n");
            }
        }
    }

    public static void start() {
        initDataBase();
        createTable();
        menu();
    }
}
