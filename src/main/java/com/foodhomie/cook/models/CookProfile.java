package com.foodhomie.cook.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.foodhomie.cook.models.requests.CookReq;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Data
@Table(name = "cook_profile")
@JsonIgnoreProperties
public class CookProfile implements Serializable {

    @Id
  //  @GeneratedValue(strategy = TABLE)
  //  @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="cook_id", nullable = false)
    private int cook_id;
    @Column(name= "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "contact")
    private String contact;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "city")
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "province")
    private String province;
    @Column(name = "kitchen_name")
    private String kitchenName;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cook_id", nullable = false)
    private Cook cook;

    // Default Constructor
    public CookProfile(){
    }

    // Constructor
    public CookProfile(String firstName, String lastName, String contact, String streetAddress, String city, String postalCode, String province, String kitchenName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.kitchenName = kitchenName;
    }

    // Constructor with CookReq - For Get Method
    public CookProfile(CookReq cookReq) {
        this.firstName = cookReq.getFirstName();
        this.lastName = cookReq.getLastName();
        this.contact = cookReq.getContact();
        this.streetAddress = cookReq.getStreetAddress();
        this.city = cookReq.getCity();
        this.postalCode = cookReq.getPostalCode();
        this.province = cookReq.getProvince();
        this.kitchenName = cookReq.getKitchenName();
    }

    // Constructor with CookProfile Object - For Update Method
    public CookProfile(CookProfile cookProfile) {
        this.firstName = cookProfile.getFirstName();
        this.lastName = cookProfile.getLastName();
        this.contact = cookProfile.getContact();
        this.streetAddress = cookProfile.getStreetAddress();
        this.city = cookProfile.getCity();
        this.postalCode = cookProfile.getPostalCode();
        this.province = cookProfile.getProvince();
        this.kitchenName = cookProfile.getKitchenName();
    }


    // Getters & Setters
    public int getCook_id() {
        return cook_id;
    }

    public void setCook_id(int cook_id) {
        this.cook_id = cook_id;
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

    // Cook Getter & Setter
    @JsonIgnore
    public Cook getCook() {
        return cook;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }


    @Override
    public String toString() {
        return "CookProfile{" +
//                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact='" + contact + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", province='" + province + '\'' +
                ", kitchenName='" + kitchenName + '\'' +
                '}';
    }
}
