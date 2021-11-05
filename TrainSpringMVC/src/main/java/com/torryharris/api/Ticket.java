package com.torryharris.api;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Ticket {

    private int counter=100;
    private String pnr;
    private Date travelDate;
    private Train train;
    private TreeMap<Passenger, Integer> passengers = new TreeMap<>();

    public Ticket() {
    }

    public Ticket(Date travelDate, Train train) {
        this.travelDate = travelDate;
        this.train = train;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter =counter;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public TreeMap<Passenger, Integer> getPassengers() {
        return passengers;
    }

    public void setPassengers(TreeMap<Passenger, Integer> passengers) {
        this.passengers = passengers;
    }

    private String generatePNR()
    {
        char source=this.train.getSource().charAt(0);
        char destination=this.train.getDestination().charAt(0);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String date=sdf.format(getTravelDate());
        String pnr=""+source+""+destination+"_"+date+"_"+counter+"";
        return (pnr);
    }


    public Double calcPassengerFare(Passenger passenger) {
        double ticketPrice=train.getTicketPrice();
        int age=passenger.getAge();
        char gender= passenger.getGender();
        if (age>= 60) {
            ticketPrice=ticketPrice*0.4;
            return ticketPrice;
        } else if (age <= 12) {
            ticketPrice=ticketPrice*0.5;
            return ticketPrice;
        }
        else if (gender=='f'){
            ticketPrice=ticketPrice*0.75;
            return ticketPrice;
        }
        else
            return ticketPrice;
    }

    public void addPassenger(String name,int age,char gender)
    {
        Passenger passenger=new Passenger(name,age,gender);
        double cal=calcPassengerFare(passenger);
        passengers.put(passenger,(int)cal);
    }

    private double calculateTotalTicketPrice()
    {
        double totalTicketPrice=0;
        for(Passenger p:passengers.keySet())
        {
            totalTicketPrice+=passengers.get(p);
        }
        return totalTicketPrice;
    }

    private StringBuilder generateTicket()
    {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        String date=sdf.format(getTravelDate());
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("PNR :        "+generatePNR()+"\n");
        stringBuilder.append("Train no :   "+train.getTrainNo()+"\n");
        stringBuilder.append("Train Name : "+train.getTrainName()+"\n");
        stringBuilder.append("From :       "+train.getSource()+"\n");
        stringBuilder.append("To :         "+train.getDestination()+"\n");
        stringBuilder.append("Travel Date :"+date+"\n");
        stringBuilder.append("\n");
        stringBuilder.append("Name\t\tage\t\tGender\t\tFare\n");
        for(Map.Entry<Passenger,Integer>pie:passengers.entrySet())
        {
            stringBuilder.append(pie.getKey().getName()+"\t\t"+pie.getKey().getAge()+"\t\t"+pie.getKey().getGender()
            +"\t\t"+pie.getValue()+"\t\t\n");
        }
        stringBuilder.append("Total Price:"+calculateTotalTicketPrice());
        return stringBuilder;
    }
    public void writeTicket() throws IOException {
       // System.out.println(generateTicket());
        FileOutputStream fos=new FileOutputStream(generatePNR()+".txt");
        StringBuilder str=this.generateTicket();
        fos.write(str.toString().getBytes());
        fos.close();
        File file=new File(generatePNR()+""+".txt");
        FileInputStream fis=new FileInputStream(generatePNR()+".txt");
        System.out.println("Ticket details are:");
        int ch;
        while((ch=fis.read())!=-1)
            System.out.print((char)ch);
        fis.close();
    }
    public String confirmTicket()
    {
        String PNR=generatePNR();
        return PNR;
    }



}

