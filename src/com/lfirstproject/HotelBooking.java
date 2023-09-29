package com.lfirstproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HotelBooking {
    public static void main(String[] args)
    {
        System.out.println("Welcome to Hotel Reservation System");
        System.out.println("1.Create an Account");
        System.out.println("2.Start your Reservation");
        System.out.println("3.Cancel your Reservation");
        System.out.println("4.Display all my Reservations");
        System.out.println("5.Please print total bill");
        Scanner sc= new Scanner(System.in);
        int userinput= sc.nextInt();
        String usermail="",phonenumber="",location="";
        if(userinput==1)
        {
            System.out.println("Please enter your email");
             usermail= sc.next();
             while(!usermail.contains("@gmail.com"))
             {
                 System.out.println("Please enter email id with @gmail.com");
                 usermail=sc.next();
             }
            System.out.println("Please enter your phonenumber");
             phonenumber=sc.next();
             while (phonenumber.length()<10)
             {
                 System.out.println("Please enter 10 digit phonenumber");
                 phonenumber=sc.next();
             }
            System.out.println("Please enter your Location");
             location=sc.next();
        }

        String folderpath="C:\\"+phonenumber;
        File folder=new File(folderpath);
        if(!folder.exists())
        {
            boolean success=folder.mkdir();
            if(success)
            {
                System.out.println("Folder created successfully");
            }
            else {
                System.out.println("Failed to create Folder");
            }
        }
        else{
            System.out.println("Folder Already exists");
        }
        String folderpath1="C:\\"+phonenumber;
        String filename="acc_"+phonenumber+".txt";
        File file= new File(folderpath1,filename);
        try
        {
            boolean created=file.createNewFile();
            if(created)
            {
                System.out.println("File created successfully");
            }
            else{
                System.out.println("File already exists");
            }
        }
        catch(IOException e)
        {
          e.printStackTrace();
        }

        String filepath="C:\\6159184079\\acc_6159184079.txt";
        try{
            BufferedWriter writer= new BufferedWriter(new FileWriter(filepath));
            writer.write("User email is: "+usermail);
            writer.newLine();
            writer.write("user phonenumber is :"+phonenumber);
            writer.newLine();
            writer.write("User location is : "+location);
            writer.close();

        }catch(IOException e)
        {
           e.printStackTrace();
        }


    }
}
