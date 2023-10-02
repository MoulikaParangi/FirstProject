package com.lfirstproject;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelBooking {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Hotel Reservation System");
        Scanner sc= new Scanner(System.in);
         int userinput;
        String usermail = "", phonenumber = "", location = "";
        AccountCreation accountCreation=new AccountCreation();
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

        }while(userinput<6);

        phonenumber=accountCreation.getPhonenumber();
        String folderpath="C:\\HotelReservation\\"+phonenumber;
        File folder=new File(folderpath);
        if(folder.mkdir())
        {
                System.out.println("Folder created successfully");
                String filename="C:\\HotelReservation\\6159184079\\acc_"+phonenumber+".json";
                File file=new File(filename);
                if(file.createNewFile())
                {
                    accountCreation.saveToJson(filename);
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
