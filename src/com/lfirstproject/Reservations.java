package com.lfirstproject;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Reservations {


    private int no_of_people, no_of_days;
    private String food,arrangements;
Scanner sc=new Scanner(System.in);
    public Reservations()
    {

    }
    public Reservations( int no_of_people,int no_of_days,String food, String arrangements)
    {

        this.no_of_people=no_of_people;
        this.no_of_days=no_of_days;
        this.food=food;
        this.arrangements=arrangements;

    }

    public int getNo_of_people()
    {
        return no_of_people;
    }

    public void setNo_of_people(int no_of_people) {
        this.no_of_people = no_of_people;
    }

    public int getNo_of_days() {
        return no_of_days;
    }

    public void setNo_of_days(int no_of_days) {
        this.no_of_days = no_of_days;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getArrangements() {
        return arrangements;
    }

    public void setArrangements(String arrangements) {
        this.arrangements = arrangements;
    }
    public void getReservationData()
    {
        System.out.println("Choose your prefernce 1.Hotel 2. Villa 3. Apartment");
        int choice=sc.nextInt();
        System.out.println("for how many members are you booking?");
        no_of_people=sc.nextInt();
        System.out.println("For how many days are you staying?");
        no_of_days=sc.nextInt();
        System.out.println("Are there any preferences for food (veg/non veg)");
        food=sc.next();
        System.out.println("Are there any arrangements need to be done ?");
        arrangements=sc.next();


    }
    public void writeData(String file)
    {
        JSONObject jsonobject = new JSONObject();

        jsonobject.put("no_of_people",getNo_of_people());
        jsonobject.put("no_of_days",getNo_of_days());
        jsonobject.put("food",getFood());
        jsonobject.put("arrangements",getArrangements());
        try(FileWriter fileWriter=new FileWriter(file))
        {
            fileWriter.write(jsonobject.toString());
            System.out.println("Data has been saved to json file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
