package com.company;

public class Conference_Room extends Room {
    private int number_of_seats ;
    private double seat_price ;

    public int getNumber_of_seats() {
        return number_of_seats;
    }
    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }
    public double getSeat_price() {
        return seat_price;
    }
    public void setSeat_price(double seat_price) {
        this.seat_price = seat_price;
    }

    public void profit (){

    }
}
