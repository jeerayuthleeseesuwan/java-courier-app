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
public class User {
    //access modifier -protected
    protected String id;
    protected String name;
    protected String gender;
    protected String dateOfBirth;
    protected String contactNo;
    protected String email;
    protected String imgUrl;
    protected Permission permissions;

    //overloading (2 same method with different parameters (line 17 and 22)
    public User(String id, String name, String gender, String dateOfBirth, String contactNo, String email, String imgUrl, Permission permissions) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.contactNo = contactNo;
        this.email = email;
        this.imgUrl = imgUrl;
        this.permissions = permissions;
    }
    public User(String id, String name, String email, Permission permissions) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.permissions = permissions;
    }
    
    public String toOneLineString(){
        return String.join(",",  id, name, gender, dateOfBirth, contactNo, email, imgUrl, "end-of-line");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getEmail() {
        return email;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Permission getPermissions() {
        return permissions;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setPermissions(Permission permissions) {
        this.permissions = permissions;
    }
    
    
}
