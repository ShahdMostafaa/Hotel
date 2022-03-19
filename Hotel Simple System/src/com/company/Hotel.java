package com.company;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Floor> H_floors = new ArrayList<>();
    private static int number_of_floors ;

    public ArrayList<Floor> getH_floors() {
        return H_floors;
    }
    public void setH_floors(ArrayList<Floor> h_floors) {
        H_floors = h_floors;
    }
    public static int getNumber_of_floors() {
        return number_of_floors;
    }
    public static void setNumber_of_floors(int number_of_floors) {
        Hotel.number_of_floors = number_of_floors;
    }
}
