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
public class ManagingStaff extends User {

    //overloading (2 same method with different parameters (line 17 and 22)
    public ManagingStaff(String id, String name, String gender, String dateOfBirth, String contactNo, String email, String imgUrl) {
        //set permission parameter as ManagingStaffPermission()
        super(id, name, gender, dateOfBirth, contactNo, email, imgUrl, new ManagingStaffPermission());
    }
    //used for create a new account, excluding the optional fields like DOB
    public ManagingStaff(String id, String name, String email) {
        //set permission parameter as ManagingStaffPermission()
        super(id, name, email, new ManagingStaffPermission());
    }
}
