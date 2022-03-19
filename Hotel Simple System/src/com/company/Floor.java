package com.company;

import java.util.ArrayList;

public class Floor {
    private ArrayList<Room> F_rooms = new ArrayList<>();
    private int floor_num ;
    private int number_of_rooms ;

    public ArrayList<Room> getF_rooms() {
        return F_rooms;
    }
    public void setF_rooms(ArrayList<Room> f_rooms) {
        F_rooms = f_rooms;
    }
    public int getFloor_num() {
        return floor_num;
    }
    public void setFloor_num(int floor_num) {
        this.floor_num = floor_num;
    }
    public int getNumber_of_rooms() {
        return number_of_rooms;
    }
    public void setNumber_of_rooms(int number_of_rooms) {
        this.number_of_rooms = number_of_rooms;
    }

    public void profit() {
    }
}
