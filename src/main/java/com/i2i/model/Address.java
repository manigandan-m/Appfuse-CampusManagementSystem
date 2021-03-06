package com.i2i.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Model class for Address
 * It is a physical entity which depicts the particulars of the place where someone lives.
 * Setter and Getter methods for the class variables
 * 
 * @author Manigandan
 * 
 * @created 2016-09-05
 */

@Entity
@Table(name= "address")
public class Address {
   
    @Id   
    @GeneratedValue
    @Column(name = "address_id")
    private int addressId;
   
    @Column(name = "house_number")
    private String houseNumber;
   
    @Column(name = "street_name")
    private String streetName;
   
    @Column(name = "city")
    private String city;
   
    @Column(name = "state")
    private String state;
   
    @Column(name = "country")
    private String country;
   
    @Column(name = "pincode")
    private int pincode;
   
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")   
    @LazyCollection(LazyCollectionOption.FALSE)
    private User user;
   
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }   
   
    public void setUser(User user) {
        this.user = user;       
    }
   
    public User getUser() {
        return user;       
    }
    
    public Address() {
    }   
}