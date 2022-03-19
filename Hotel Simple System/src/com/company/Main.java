package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void Option() {
        Scanner OP = new Scanner(System.in);
        System.out.println("Welcome in Hotel Services ... \n ");
        String [] options  = {"1_ Reserve an Room .." , "2_ Cancel a Reservation ...",
                "3_ View the Profit ..." , "4_ View Available Rooms ..." };
        for(int i = 0 ; i < options.length ; i++)
            System.out.println(options[i]);
        System.out.println();
        System.out.print("Choose The Operation you Want to do : ");
        int option = OP.nextInt() ;
    } // return type

    // Read from file rooms information
    // store the informations about rooms
    public static void Hotel_information( Hotel H ) {
        ArrayList <String> Floor_information = new ArrayList<String>();
        ArrayList <Room> rom = new ArrayList<>();
        ArrayList <Floor> FL = new ArrayList<>();

        String room ;
        try {
            File H_inf = new File("Floors_Information.txt");
            Scanner Room_inf = new Scanner(H_inf);
            System.out.println("open");
            while (Room_inf.hasNextLine()) {
                room = Room_inf.next();
                Floor_information.add(room);
            }
            for (int i = 0 ; i < Floor_information.size(); i++) {
                if (Floor_information.get(i).startsWith("#floor")) {
                    String[] Stan = Floor_information.get(i).split("[#:]", 3);
                    H.setNumber_of_floors(Integer.parseInt(Stan[2]));

                }
                if (Floor_information.get(i).startsWith("Floor")) {
                    String[] Stan = Floor_information.get(i).split("[#,:]", 5);
                    Floor F = new Floor();
                    F.setFloor_num(Integer.parseInt(Stan[1]));
                    F.setNumber_of_rooms(Integer.parseInt(Stan[4]));
                    F.setF_rooms(rom);
                    FL.add(F);
                    H.setH_floors(FL);
                }
                if (Floor_information.get(i).startsWith("Standard")) {
                    Standard_Room S_R = new Standard_Room();
                    String[] rom_if = Floor_information.get(i).split(",", 4);
                    S_R.setRoom_num(Integer.parseInt(rom_if[1]));
                    S_R.setNumber_of_beds(Integer.parseInt(rom_if[2]));
                    S_R.setBed_price(Double.parseDouble(rom_if[3]));
                    S_R.setIs_reserved(false);
                    rom.add(S_R);

                }
                if (Floor_information.get(i).startsWith("Sweet")) {
                    Sweet_Room W_R = new Sweet_Room();
                    String[] rom_if = Floor_information.get(i).split(",", 3);
                    W_R.setRoom_num(Integer.parseInt(rom_if[1]));
                    W_R.setPrice_PerNight(Integer.parseInt(rom_if[2]));
                    W_R.setIs_reserved(false);
                    rom.add(W_R);
                }
                if (Floor_information.get(i).startsWith("Conference")) {
                    Conference_Room C_R = new Conference_Room();
                    String[] rom_if = Floor_information.get(i).split(",", 4);
                    C_R.setRoom_num(Integer.parseInt(rom_if[1]));
                    C_R.setNumber_of_seats(Integer.parseInt(rom_if[2]));
                    C_R.setSeat_price(Double.parseDouble(rom_if[3]));
                    C_R.setIs_reserved(false);
                    rom.add(C_R);
                }

            }
          /*    for(int i = 0 ; i < rom.size(); i++) {
                System.out.println("=====================================");
                System.out.println(rom.get(i).getRoom_num());
            }
            for(int i = 0 ; i < FL.size() ; i++) {
                for(int j = 0 ; j < FL.get(i).getF_rooms().size() ; j++) {
                    System.out.println("///////////////////////////////");
                    System.out.println(FL.get(i).getFloor_num());
                    System.out.println(FL.get(i).getF_rooms().get(j).getRoom_num());

                }

            }
            for(int i = 0 ; i < H.getH_floors().size(); i++) {
                for (int j = 0 ; j < H.getH_floors().get(i).getF_rooms().size() ; j++)
                {
                    System.out.println("***********************************");
                    System.out.println(H.getH_floors().get(i).getFloor_num());
                    System.out.println(H.getH_floors().get(i).getF_rooms().get(j).getRoom_num());
                }
            }*/

            Room_inf.close();
        } catch(Exception ex){
            System.out.println("close");
            return ;
        }

    }

    // show the available rooms in the hotel
    public static void View_Available_rooms(Hotel H){
        for(int i = 0 ; i < H.getH_floors().size(); i++) {
            for (int j = 0 ; j < H.getH_floors().get(i).getF_rooms().size() ; j++)
            {
                System.out.println("***********************************");
                if(H.getH_floors().get(i).getF_rooms().get(j).isIs_reserved() == false) {
                    System.out.println(H.getH_floors().get(i).getFloor_num());
                    System.out.println("*********");
                    System.out.println(H.getH_floors().get(i).getF_rooms().get(j).getRoom_num());
                    System.out.println(H.getH_floors().get(i).getF_rooms().get(j).isIs_reserved());
                }
            }
        }
    }

    //check if the room is empty
    // reserve a room
    public static void Chek_in (Hotel H){
        Scanner Sc = new Scanner(System.in);
        Room rom_in = new Room();
        System.out.println("Welcome in New Reservation ;)");
        System.out.println("*****************************************");
        System.out.println("Choose The Kind of Room that the customer want ...");
        System.out.println("Enter -S- for Standard Room ... -W- for Sweet Room ... -C- for conference : ");
        String rom_T = Sc.next();
        if(rom_T.equals("S") || rom_T.equals("s")){
            System.out.print("Enter the Number of Room for reservation : ");
            int rom_no = Sc.nextInt();
            for(int i = 0 ; i < H.getH_floors().size(); i++)
            {
                for(int j = 0 ; j < H.getH_floors().get(i).getF_rooms().size() ; j++)
                {
                    if(H.getH_floors().get(i).getF_rooms().get(j)instanceof Standard_Room)
                    {
                        if(H.getH_floors().get(i).getF_rooms().get(j).getRoom_num()== rom_no)
                        {
                            if (!(H.getH_floors().get(i).getF_rooms().get(j).isIs_reserved())) {
                                H.getH_floors().get(i).getF_rooms().get(j).setIs_reserved(true);
                                System.out.println("Enter The Number of Days : ");
                                int days = Sc.nextInt();
                                H.getH_floors().get(i).getF_rooms().get(j).setDays_of_reservation(days);
                                break;
                            }
                            else {
                                System.out.println("This room has been reserved");
                                Option();
                            }
                        }
                    }
                }
            }
        }
        else if(rom_T.equals("W") || rom_T.equals("w")){
            System.out.print("Enter the Number of Room for reservation : ");
            int rom_no = Sc.nextInt();
            for(int i = 0 ; i < H.getH_floors().size(); i++)
            {
                for(int j = 0 ; j < H.getH_floors().get(i).getF_rooms().size() ; j++)
                {
                    if(H.getH_floors().get(i).getF_rooms().get(j)instanceof Sweet_Room)
                    {
                        if(H.getH_floors().get(i).getF_rooms().get(j).getRoom_num()== rom_no)
                        {
                            if (!(H.getH_floors().get(i).getF_rooms().get(j).isIs_reserved())) {
                                H.getH_floors().get(i).getF_rooms().get(j).setIs_reserved(true);
                                System.out.println("Enter The Number of Days : ");
                                int days = Sc.nextInt();
                                H.getH_floors().get(i).getF_rooms().get(j).setDays_of_reservation(days);
                                System.out.println("This Reservation is done...");
                                break;
                            }
                            else {
                                System.out.println("This Room Now is busy...");
                                Option();
                            }
                        }
                    }
                }
            }
       }
       else if(rom_T.equals("C") || rom_T.equals("c")) {
            System.out.print("Enter the Number of Room for reservation : ");
            int rom_no = Sc.nextInt();
            for(int i = 0 ; i < H.getH_floors().size(); i++)
            {
                for(int j = 0 ; j < H.getH_floors().get(i).getF_rooms().size() ; j++)
                {
                    if(H.getH_floors().get(i).getF_rooms().get(j)instanceof Conference_Room)
                    {
                        if(H.getH_floors().get(i).getF_rooms().get(j).getRoom_num()== rom_no)
                        {
                            if (!(H.getH_floors().get(i).getF_rooms().get(j).isIs_reserved())) {
                                H.getH_floors().get(i).getF_rooms().get(j).setIs_reserved(true);
                                System.out.println("Enter The Number of Days : ");
                                int days = Sc.nextInt();
                                H.getH_floors().get(i).getF_rooms().get(j).setDays_of_reservation(days);
                                break;
                            }
                            else {
                                System.out.println("This room has been reserved");
                                Option();
                            }
                        }
                    }
                }
            }
       }

    }
    
    // end the reservation of the room or cancel it
    public static void Chek_out (Hotel H){
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter the Number of Room for reservation : ");
        int rom_no = Sc.nextInt();
        for(int i = 0 ; i < H.getH_floors().size(); i++) {
            for (int j = 0; j < H.getH_floors().get(i).getF_rooms().size(); j++) {
                if (H.getH_floors().get(i).getF_rooms().get(j).getRoom_num() == rom_no) {
                    if (H.getH_floors().get(i).getF_rooms().get(j).isIs_reserved()) {
                        H.getH_floors().get(i).getF_rooms().get(j).setIs_reserved(false);
                        System.out.println("This Room Now is Free...");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Hotel H = new Hotel() ;
        Hotel_information(H);
       /*
        View_Available_rooms(H);
        Chek_in(H);
         View_Available_rooms(H);
       */


    }
}

