package HashMapApp;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Project: Curs26
 * Author: mihai
 * Date: 2/20/2020
 */
public class CarRentalSystem implements Serializable {
    private static Scanner scan = new Scanner(System.in);
    private Map<String, String> rentedCarsList = new HashMap<String, String>();
    private Map<String, RentedCars> ownerCars = new HashMap<>();

    // version ID used for serialization
    private static final long serialVersionUID = 1L;



    private static String getPlateNo(){
        System.out.println("Introduceti numarul de inmatriculare: ");
        return scan.nextLine();
    }

    private static String getOwnerName(){
        System.out.println("Introduceti numele propietarului: ");
        return scan.nextLine();
    }


    // add a new (key, value) pair
    public void rentCar(String plateNo, String ownerName) throws NullPointerException{
        if (plateNo == null || ownerName == null){
            return;
        }

        try {
            if (!this.rentedCarsList.containsKey(plateNo)) {
                System.out.println("The pair (" + plateNo + ", " + ownerName + ") is added into the hashtable!");
                this.rentedCarsList.put(plateNo, ownerName);
            }

            if (this.ownerCars.containsKey(ownerName)) {
                RentedCars cars = this.ownerCars.get(ownerName);
                cars.addCars(plateNo);
            } else {
                System.out.println("The pair (" + ownerName + ", " + plateNo + ") is added into the owner cars list!");
                RentedCars cars = new RentedCars();
                cars.addCars(plateNo);
                this.ownerCars.put(ownerName, cars);
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }


    // search for a key in hashtable
    public boolean isCarRent(String plateNo)throws NullPointerException{
        if (plateNo == null){
            throw new NullPointerException("Plate number is null!");
        }

        return this.rentedCarsList.containsKey(plateNo);
    }


    // get the value associated to a key
    public String isOwnerName(String plateNo){
        if (plateNo == null){
            return "Input plateNo is null";
        }

        if (this.rentedCarsList.containsKey(plateNo)) {
            return this.rentedCarsList.get(plateNo);
        }
        return "The owner is not in the list";
    }


    // remove an existing (key, value) pair
    public void returnCar(String plateNo, String ownerName) throws NullPointerException{
        if (plateNo == null){
            throw  new NullPointerException("Plate number is null!");
        }

        if (!this.rentedCarsList.containsKey(plateNo)){
            System.out.println("The pair (plateNo, ownerName) is not in the hashtable");
        } else{
            System.out.println("The pair (plateNo, ownerName) is removed from the hashtable!");
            this.rentedCarsList.remove(plateNo);
        }

        if (this.ownerCars.containsKey(ownerName)) {
            System.out.println("The pair (ownerName, ownerCarsList) is removed from the owner cars list!");
            RentedCars cars = this.ownerCars.get(ownerName);
            cars.removeCars(plateNo);
        }
    }


    // total number of rented cars
    public int totalRentedCars()throws NullPointerException{
        return this.rentedCarsList.size();
    }


    // total rented cars for one owner
    public int getOwnerCarsNo(String ownerName) {
        if (!this.ownerCars.containsKey(ownerName)) {
            System.out.println(("The owner is not on the list!"));
            return 0;
        }

        return this.ownerCars.get(ownerName).getCarsNo();
    }


    // rented cars list for one owner
    public void getOwnerCarList(String ownerName){
        if (this.ownerCars.containsKey(ownerName)){
            this.ownerCars.get(ownerName).getCarList();
        }
    }


    public void iterateForEachLoop(){
        for (Map.Entry mapElement : this.rentedCarsList.entrySet()){
            System.out.println("Key: " + mapElement.getKey());
            System.out.println("Value: " + mapElement.getValue());
        }
        System.out.println();
    }


    public void iterateIterator(){
        Iterator iterator = this.rentedCarsList.entrySet().iterator();

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
        System.out.println("totalRentedCars     - Afiseaza numarul de masini inchiriate ");
        System.out.println("ownerCarsNo - Afiseaza numarul de masini inchiriate de proprietarul temporar");
        System.out.println("ownerCarsList - Afiseaza lista de masini inchiriate de proprietarul temporar");
        System.out.println("quit         - Inchide aplicatia");
    }



    // Save data intro 'saveFile.dat' file
    private void saveData(CarRentalSystem carRentalSystem, String file) throws IOException{
        try (ObjectOutputStream binaryFileOut = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)))){
            binaryFileOut.writeObject(carRentalSystem);
        }
    }


    // Delete data from 'saveFile.dat' file
    private void reset(String file)throws IOException {
        try (ObjectOutputStream reset = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)))){
            reset.reset();
        }
    }



    public void run(CarRentalSystem carRentalSystem, String file) throws IOException {
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
                    try {
                        System.out.println(this.isCarRent(getPlateNo()) + "\n");
                    }catch (NullPointerException e){
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                    break;

                case "remove":
                    this.returnCar(getPlateNo(), getOwnerName());
                    break;

                case "getOwner":
                    System.out.println(isOwnerName(getPlateNo()) + "\n");
                    break;

                case "totalRentedCars":
                    System.out.println("Total rented cars = " + this.totalRentedCars());
                    break;

                case "ownerCarsNo":
                    String owner = getOwnerName();
                    System.out.println("Cars number for " + owner + " is " + this.getOwnerCarsNo(owner));
                    break;

                case "ownerCarsList":
                    String owner1 = getOwnerName();
                    System.out.println("Cars list for " + owner1 + ": ");
                    this.getOwnerCarList(owner1);
                    break;

                case "iterate1":
                    System.out.println("Iterate with FOR EACH LOOP");
                    this.iterateForEachLoop();
                    break;

                case "iterare2":
                    System.out.println("Iterate with ITERATOR");
                    this.iterateIterator();
                    break;

                case "reset":
                    System.out.println("Reset successful!");
                    this.reset(file);
                    break;

                case "quit":
                    quit = true;
                    this.saveData(carRentalSystem, file);
                    System.out.println("Save successful!");
                    break;

                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }
}
