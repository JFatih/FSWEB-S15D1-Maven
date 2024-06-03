package org.example.models;

import java.util.*;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    public Grocery(){};

    public static void startGrocery(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("0 for close your cart, 1 for adding items to cart, 2 for remove items from cart, 3 for see your cart!");

        String status = myObj.nextLine();

        if(status.equals("0")){
            System.out.println("Cart Closed");
        } else if(status.equals("1")){
            Scanner myObj1 = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
            String newItems = myObj1.nextLine();
            addItems(newItems);
            startGrocery();
        } else if (status.equals("2")) {
            Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
            String removeItems = myObj2.nextLine();
            removeItems(removeItems);
            startGrocery();
        } else if (status.equals("3")) {
            printSorted();
            startGrocery();
        }
    }

    public static void addItems(String products){
        String[] items = products.split(",");
        for(String item : items){
            if(checkItemIsInList(item)){
                System.out.println( item.trim() + " have already added cart!");
            }else{
                groceryList.add((item.trim()));
                Collections.sort(groceryList);
                System.out.println( item + " added cart!");
            }
        }

    }

    public static void removeItems(String products){
        String[] items = products.split(",");
        for(String item : items){
            if(checkItemIsInList(item)){
                groceryList.remove(item);
                System.out.println( item + " items has been removed from cart.");
                Collections.sort(groceryList);
            }else {
                System.out.println( "Sorry " + item + " don't have in cart!");
            }

        }

    }

    public static boolean checkItemIsInList(String product){
        return groceryList.contains(product);
    }

    public static void printSorted(){
        Collections.sort(groceryList);
        for(String item : groceryList){
            System.out.println(item);
        }
    }
}
