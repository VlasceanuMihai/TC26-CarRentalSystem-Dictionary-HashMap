package HashMapApp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Project: TemaC26
 * Author: mihai
 * Date: 2/24/2020
 */
public class RentedCars{
    private Set<String> carsList = new HashSet<>();


    // add cars to list/set
    public void addCars(String plateNo){
        this.carsList.add(plateNo);
    }

    // total rented cars for one owner
    public int getCarsNo(){
        return this.carsList.size();
    }


    // rented cars list for one owner
    public void getCarList(){
        System.out.println(this.carsList);
    }
}
