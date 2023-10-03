package com.lfirstproject;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelBooking {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Hotel Reservation System");
        Scanner sc= new Scanner(System.in);
         int userinput;
        long acc_no=0;
        String usermail = "", phonenumber = "", location = "";
        List<Long> reservationList=new ArrayList<Long>();
        AccountCreation accountCreation=new AccountCreation();
        Reservations reservations=new Reservations();
        do {
            System.out.println("1.Create an Account");
            System.out.println("2.Start your Reservation");
            System.out.println("3.Cancel your Reservation");
            System.out.println("4.Display all my Reservations");
            System.out.println("5.Please print total bill");
            System.out.println("6.Exit from the application");
            userinput = sc.nextInt();

            if (userinput == 1) {

                accountCreation.getData();
            }
           else if(userinput==2)
            {
                System.out.println("Do you have account, say Yes or No");
                String response=sc.next();
                if(response.equalsIgnoreCase("yes"))
                {
                    System.out.println("Please enter your accountnumber");
                    acc_no=sc.nextLong();
                    reservations.getReservationData();

                }
                else{
                    System.out.println("You dont have account. Please select account creation first");
                }
            }

        }while(userinput<6);

        phonenumber=accountCreation.getPhonenumber();
        reservationList.add(acc_no);
        accountCreation.setReservationList(reservationList);
        long acc = (long) Math.floor(Math.random() * 9000_000_000L) + 1_000_000_000L;
        String acc_num = acc + "";
        File f = new File(acc_num);

        if(f.mkdir())
        {
                System.out.println("Folder created successfully");
            String relativePath = acc_num+"/acc_"+acc_num+".json";
            File file = new File(relativePath);
            String relativepath1=acc_num+"/rs_"+acc_no+".json";
            File file1=new File(relativepath1);


                if(file.createNewFile() && file1.createNewFile())
                {
                    accountCreation.saveToJson(relativePath);
                    reservations.writeData(relativepath1);
                }

            else {
                System.out.println("Failed to create Folder");
            }
        }
        else{
            System.out.println("Folder Already exists");
        }






    }
}
