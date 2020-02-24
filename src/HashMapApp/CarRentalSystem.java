package HashMapApp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Project: Curs26
 * Author: mihai
 * Date: 2/20/2020
 */
public class CarRentalSystem {
    private static Scanner scan = new Scanner(System.in);
    private Map<String, String> rentedCars = new HashMap<String, String>(100, 5f);


    private static String getPlateNo(){
        System.out.println("Introduceti numarul de inmatriculare: ");
        return scan.nextLine();
    }

    private static String getOwnerName(){
        System.out.println("Introduceti numele propietarului: ");
        return scan.nextLine();
    }


    // add a new (key, value) pair
    public void rentCar(String plateNo, String ownerName){
        if (!this.rentedCars.containsKey(plateNo)){
            this.rentedCars.put(plateNo, ownerName);
        }
    }


    // search for a key in hashtable
    public boolean isCarRent(String plateNo){
        if (this.rentedCars.containsKey(plateNo)){
            return true;
        }
        return false;
    }


    // get the value associated to a key
    public String isOwnerName(String plateNo){
        if (this.rentedCars.containsKey(plateNo)) {
            return this.rentedCars.get(plateNo);
        }
        return "The owner is not in the list";
    }


    // remove an existing (key, value) pair
    public void returnCar(String plateNo){
        if (this.rentedCars.containsKey(plateNo)){
            System.out.println("The pair (key, value) is removed from the hashtable!");
            this.rentedCars.remove(plateNo);
            return;
        }

        System.out.println("The pair (key, value) is not in the hashtable");
    }


    // total number of rented cars
    public int totalRentedCars(){
        return this.rentedCars.size();
    }


    public void iterateForEachLoop(){
        for (Map.Entry mapElement : this.rentedCars.entrySet()){
            System.out.println("Key: " + mapElement.getKey());
            System.out.println("Value: " + mapElement.getValue());
        }
        System.out.println();
    }


    public void iterateIterator(){
        Iterator iterator = this.rentedCars.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry mapElement = (Map.Entry) iterator.next();
            System.out.println("Key: " + mapElement.getKey());
            System.out.println("Value: " + mapElement.getValue());
        }
        System.out.println();
    }


    private static void printCommandsList(){
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua pereche (masina, sofer)");
        System.out.println("check        - Verifica daca o masina este deja luata");
        System.out.println("remove       - Sterge o masina existenta din hashtable");
        System.out.println("getOwner     - Afiseaza proprietarul curent al masinii");
        System.out.println("quit         - Inchide aplicatia");
    }


    public void run(){
        boolean quit = false;

        while (!quit){
            System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            String command = scan.nextLine();

            switch (command){
                case "help":
                    printCommandsList();
                    break;
                case "add":
                    this.rentCar(getPlateNo(), getOwnerName());
                    break;
                case "check":
                    System.out.println(this.isCarRent(getPlateNo()) + "\n");
                    break;
                case "remove":
                    this.returnCar(getPlateNo());
                    break;
                case "getOwner":
                    System.out.println(isOwnerName(getPlateNo()) + "\n");
                    break;
                case "iterate1":
                    System.out.println("Iterate with FOR EACH LOOP");
                    this.iterateForEachLoop();
                    break;
                case "iterare2":
                    System.out.println("Iterate with ITERATOR");
                    this.iterateIterator();
                    break;
                case "quit":
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }
}
