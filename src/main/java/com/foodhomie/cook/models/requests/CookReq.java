package com.foodhomie.cook.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;



@Data
public class CookReq {

    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("contact")
    private String contact;
    @JsonProperty("street_address")
    private String streetAddress;
    @JsonProperty("city")
    private String city;
    @JsonProperty("postal_code")
    private String postalCode;
    @JsonProperty("province")
    private String province;
    @JsonProperty("kitchenName")
    private String kitchenName;

    public CookReq() {
    }

    public CookReq(String email, String password, String firstName, String lastName, String contact, String streetAddress, String city, String postalCode, String province, String kitchenName) {
        this.setEmail(email);
        this.setPassword(password);
        this.setPassword(firstName);
        this.setLastName(lastName);
        this.setContact(contact);
        this.setStreetAddress(streetAddress);
        this.setCity(city);
        this.setPostalCode(postalCode);
        this.setProvince(province);
        this.setKitchenName(kitchenName);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getKitchenName() {
        return kitchenName;
    }

    public void setKitchenName(String kitchenName) {
        this.kitchenName = kitchenName;
    }
}
