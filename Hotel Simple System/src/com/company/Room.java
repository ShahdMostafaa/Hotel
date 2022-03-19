package com.company;

public class Room {
    private int room_num ;
    private int days_of_reservation ;
    private boolean is_reserved ;

    public int getRoom_num() {
        return room_num;
    }
    public void setRoom_num(int room_num) {
        this.room_num = room_num;
    }
    public int getDays_of_reservation() {
        return days_of_reservation;
    }
    public void setDays_of_reservation(int days_of_reservation) {
        this.days_of_reservation = days_of_reservation;
    }
    public boolean isIs_reserved() {
        return is_reserved;
    }
    public void setIs_reserved(boolean is_reserved) {
        this.is_reserved = is_reserved ;
    }
}
