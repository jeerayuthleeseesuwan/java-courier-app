/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package couriersystem.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author jeera
 */
public class Order implements Calculatable {
    private String packageId;
    private String packageType;
    private double weight;
    private double length;
    private double width;
    private double height;

    private Date orderDate;
    private String modeOfTransportation;
    private Address shippingAddress;
    
    private String owner;
    private String ownerContactNo;
    private String status;
    private double price;
    private String assignedStaffID;
    
    public static String generatePackageId (){
        try{
            File myFile = new File(GlobalConfig.dbPath + "ID_Tracker.txt");
            Scanner sc = new Scanner(myFile);
            String temp;
            while(sc.hasNext()){
                temp = sc.nextLine();
                String []tempArr = temp.split(",");
                if (tempArr[0].equals("Order")){
                    return "PID" + Integer.parseInt(tempArr[1]);
                }
            }
            sc.close();
        }
        catch(FileNotFoundException | NumberFormatException ex){
            return ex.toString();
        }
        return null;
    }
    
    public static ArrayList<Order> getListOfOrders(){
        ArrayList<Order> orders = new ArrayList<>();
        try{
            File myFile = new File(GlobalConfig.dbPath + "Orders.txt");
            Scanner sc = new Scanner(myFile);
            String row;
            Order order;
            while(sc.hasNext()){
                row = sc.nextLine();
                String [] values = row.split("__");
                String[] addressLines = values[8].split("#");
                Address shippingAddress = new Address(addressLines[0], addressLines[1], addressLines[2], addressLines[3], addressLines[4]);
                Date date;
                try{
                    date = GlobalConfig.orderDateFormat.parse(values[6]);
                } catch (Exception ex){
                    date = null;
                }
                order = new Order(
                        values[0],
                        values[1],
                        Double.parseDouble(values[2]),
                        Double.parseDouble(values[3]),
                        Double.parseDouble(values[4]),
                        Double.parseDouble(values[5]),
                        date,
                        values[7],
                        shippingAddress,
                        values[9],
                        values[10],
                        values[11],
                        values[12]
                );
                orders.add(order);
            }
            sc.close();
        }
        catch(IOException ex){
            
        }
        return orders;
    }
    
    public String toOneLineString(){
        return String.join("__", 
                packageId, packageType, Double.toString(weight), Double.toString(length), Double.toString(width), Double.toString(height),
                GlobalConfig.orderDateFormat.format(orderDate), modeOfTransportation, shippingAddress.toOneLineString(), owner, ownerContactNo, status, assignedStaffID);
    }
    
    // No arg constructor
    public Order(){ }

    public Order(String packageId, String packageType, double weight, double length, double width, double height, Date orderDate, String modeOfTransportation, Address shippingAddress, String owner, String ownerContactNo, String status, String assignedStaffID) {
        this.packageId = packageId;
        this.packageType = packageType;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.orderDate = orderDate;
        this.modeOfTransportation = modeOfTransportation;
        this.shippingAddress = shippingAddress;
        this.owner = owner;
        this.ownerContactNo = ownerContactNo;
        this.status = status;
        this.price = calculatePrice();
        this.assignedStaffID = assignedStaffID;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getPackageType() {
        return packageType;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getModeOfTransportation() {
        return modeOfTransportation;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public String getOwner() {
        return owner;
    }

    public String getOwnerContactNo() {
        return ownerContactNo;
    }

    public String getStatus() {
        return status;
    }
    
    public String getAssignedStaffID() {
        return assignedStaffID;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setModeOfTransportation(String modeOfTransportation) {
        this.modeOfTransportation = modeOfTransportation;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setOwnerContactNo(String ownerContactNo) {
        this.ownerContactNo = ownerContactNo;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setAssignedStaffID(String assignedStaffID) {
        this.assignedStaffID = assignedStaffID;
    }

    @Override
    public double calculatePrice() {
        double price = 0;
        if (packageType != null && packageType.equals("Parcel"))
            price = 5;
        else if (packageType != null && packageType.equals("Document"))
            price = 2;
        
        price += (weight * 0.1);
        price += (length * width * height * 0.01);
        
        if (modeOfTransportation != null && modeOfTransportation.equals("Land"))
            price += 10;
        else if (modeOfTransportation != null && modeOfTransportation.equals("Sea"))
            price += 30;
        else if (modeOfTransportation != null && modeOfTransportation.equals("Air"))
            price += 50;
        
        return price;
    }
    
}
