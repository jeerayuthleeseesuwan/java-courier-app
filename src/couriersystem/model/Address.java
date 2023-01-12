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
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String postcode;
    private String state;
    private String country;

    public Address(String addressLine1, String addressLine2, String postcode, String state, String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postcode = postcode;
        this.state = state;
        this.country = country;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullAddress() { //for displaying
        return String.join(", ", addressLine1, addressLine2, postcode, state, country);
    }
    
    public String toOneLineString() { //for saving in txt file
        return String.join("#", addressLine1, addressLine2, postcode, state, country);
    }
}
