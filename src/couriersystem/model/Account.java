/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package couriersystem.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author jeera
 */
public class Account {
    private String id;
    private String username;
    private String password;
    private String role;
    private boolean isActive;
    
    public String toOneLineString(){
        return String.join(",",  id, username, password, role, isActive ? "Active" : "Inactive");
    }

    public Account(String id, String username, String password, String role, boolean isActive) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean isActive() {
        return isActive;
    }

    
    

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

   
    public static ArrayList<Account> getListOfAccounts(){
        ArrayList<Account> accounts = new ArrayList<>();
        try{
            File myFile = new File(GlobalConfig.dbPath + "Account.txt");
            Scanner sc = new Scanner(myFile);
            String row;
            Account account;
            while(sc.hasNext()){
                row = sc.nextLine();
                String [] values = row.split(",");
                account = new Account(
                        values[0],
                        values[1],
                        values[2],
                        values[3],
                        values[4].equals("Active") ? true : false
                );
                accounts.add(account);
            }
            sc.close();
        }
        catch(IOException ex){
            
        }
        return accounts;
    }
    
    
}
