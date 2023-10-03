package com.lfirstproject;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AccountCreation {
    private  String usermail,phonenumber,location;
    private List<Long> reservationList;

    public AccountCreation()
    {

    }
    public AccountCreation(List<Long> reservationList,String usermail,String phonenumber,String location)
    {
       this.usermail=usermail;
       this.phonenumber=phonenumber;
       this.location=location;
       this.reservationList=reservationList;

    }

    public String getUsermail() {
        return usermail;
    }
    public void setUsermail(String usermail)
    {
        this.usermail=usermail;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber=phonenumber;
    }
    public String getLocation()
    {
        return location;
    }
    public void setLocation(String location)
    {
        this.location=location;
    }
    Scanner sc= new Scanner(System.in);


    public List<Long> getReservationList()
    {

        return reservationList;
    }

    public void setReservationList(List<Long> reservationList) {

       this.reservationList=reservationList;
    }

    public void getData()
    {
        System.out.println("Please enter your email");
        usermail = sc.next();
        while (!usermail.contains("@gmail.com")) {
            System.out.println("Please enter email id with @gmail.com");
            usermail = sc.next();
        }
        System.out.println("Please enter your phonenumber");
        phonenumber = sc.next();
        while (phonenumber.length() < 10) {
            System.out.println("Please enter 10 digit phonenumber");
            phonenumber = sc.next();
        }
        System.out.println("Please enter your Location");
        location = sc.next();
    }





    public void saveToJson(String filename)
    {
        JSONObject jsonobject = new JSONObject();

        jsonobject.put("usermail",getUsermail());
        jsonobject.put("phonenumber",getPhonenumber());
        jsonobject.put("location",getLocation());
        jsonobject.put("reservations",getReservationList());
        try(FileWriter fileWriter=new FileWriter(filename))
        {
            fileWriter.write(jsonobject.toString());
            System.out.println("Data has been saved to json file");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
