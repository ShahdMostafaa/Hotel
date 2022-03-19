package com.company;

public class Standard_Room extends Room  {
    private int number_of_beds ;
    private double bed_price ;

    public int getNumber_of_beds() {
        return number_of_beds;
    }
    public void setNumber_of_beds(int number_of_beds) {
        this.number_of_beds = number_of_beds;
    }
    public double getBed_price() {
        return bed_price;
    }
    public void setBed_price(double bed_price) {
        this.bed_price = bed_price;
    }

    public void profit (){

    }
}
