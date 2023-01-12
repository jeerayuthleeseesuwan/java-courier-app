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
public class DeliveryStaff extends User {
    
    private String company;

    //overloading (2 same method with different parameters (line 17 and 22)
    public DeliveryStaff(String id, String name, String gender, String dateOfBirth, String contactNo, String email, String imgUrl, String company) {
        super(id, name, gender, dateOfBirth, contactNo, email, imgUrl, new DeliveryStaffPermission());
        this.company = company;
    }
    //used for create a new account, excluding the optional fields like DOB
    public DeliveryStaff(String id, String name, String email) { 
        super(id, name, email, new DeliveryStaffPermission());
    }
    
    //Override method from super class
    @Override
    public String toOneLineString(){
        return String.join(",",  id, name, gender, dateOfBirth, contactNo, email, imgUrl, company, "end-of-line");
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
}
