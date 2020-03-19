package HashMapApp;

import java.io.*;

/**
 * Project: Curs26
 * Author: mihai
 * Date: 2/20/2020
 */
public class Main {
    private static final String file = "saveFile.dat";


    // Restore data from 'saveFile.dat' file
    public static CarRentalSystem restore()throws IOException, ClassNotFoundException, EOFException {
        CarRentalSystem carRentalSystem = null;

        try (ObjectInputStream binaryFileOut = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(file)))){
            carRentalSystem = (CarRentalSystem) binaryFileOut.readObject();
        }catch (EOFException e){
            System.out.println("Empty File!");
        }

        return carRentalSystem;
    }



    public static void main(String[] args) throws IOException, ClassNotFoundException, EOFException {
        CarRentalSystem carRentalSystem = restore();

        if (carRentalSystem == null){
            carRentalSystem = new CarRentalSystem();
        }

        carRentalSystem.run(carRentalSystem, file);
    }
}
