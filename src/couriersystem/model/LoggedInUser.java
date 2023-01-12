/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package couriersystem.model;

/**
 *
 * @author jeera
 */
public class LoggedInUser { 
    //this a singleton, which mean this object only instantiate once
    //this class is used to store logged in user information
    private static LoggedInUser instance; 
    
    //private constructor.
    private LoggedInUser(){}
            
    /* By making the constructor as private you are not allowing other class 
    to create a new instance of the class you want to create the Singleton. 
    Instead, you are creating one public static method (commonly name as for 
    getInstance()) to provide the single entry point to create the 
    new instance of the class. */
    public static LoggedInUser getInstance() {
        if (instance == null){ //if there is no instance available... create new one
            instance = new LoggedInUser();
        }
        
        return instance;
    }
    
    private String userId;
    private String name;
    private String role;
    private Permission permission;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
