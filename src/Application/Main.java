package Application;

import Model.entities.Reservation;
import Model.excepetions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

       try {
           System.out.print("Room number: ");
           Integer roomNum = sc.nextInt();

           System.out.print("Check-in date (DD/MM/YYYY): ");
           Date checkIn = sdf.parse(sc.next());

           System.out.print("Check-out date (DD/MM/YYYY): ");
           Date checkOut = sdf.parse(sc.next());

           Reservation reservation = new Reservation(roomNum, checkIn, checkOut);
           System.out.println("Reservation: " + reservation);

           System.out.println("Enter data to update the reservation:");
           System.out.print("Check-in date (dd/MM/yyyy): ");
           checkIn = sdf.parse(sc.next());
           System.out.print("Check-out date (dd/mm/yyyy): ");
           checkOut = sdf.parse(sc.next());

           reservation.updateDates(checkIn, checkOut);
           System.out.println(reservation);
       }
       catch(ParseException e){
            System.out.println("Invalid date format");
       }
       catch(DomainException e){
           System.out.println("Error in reservation: " + e.getMessage());
       }


        sc.close();

    }
}
