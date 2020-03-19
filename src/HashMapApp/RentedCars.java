package HashMapApp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Project: TemaC26
 * Author: mihai
 * Date: 2/24/2020
 */
public class RentedCars implements Serializable {
    private Set<String> carsList = new HashSet<>();



    // Add cars to list/set
    public void addCars(String plateNo)throws NullPointerException{
        if (plateNo == null){
            throw new NullPointerException("Null plate number string.");
        }

        this.carsList.add(plateNo);
    }


    // Remove cars from list/set
    public void removeCars(String plateNo){
        if (plateNo == null){
            throw new NullPointerException("Null plate number string.");
        }

        this.carsList.remove(plateNo);
    }


    // Total rented cars for one owner
    public int getCarsNo(){
        return this.carsList.size();
    }


    // rented cars list for one owner
    public void getCarList(){
        System.out.println(this.carsList);
    }
}
