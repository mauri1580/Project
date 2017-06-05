package com.team1.bb.core.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by sdebnath on 4/30/17.
 */
@Embeddable
public class Address {

    @Column(nullable = false, length = 50)
    private String street;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

    @Column(nullable = false, length = 5)
    private String zipcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Address withStreet(final String street) {
        setStreet(street);
        return this;
    }

    public Address withCity(final String city) {
        setCity(city);
        return this;
    }

    public Address withState(final String state) {
        setState(state);
        return this;
    }

    public Address withZipcode(final String zipcode) {
        setZipcode(zipcode);
        return this;
    }

    @Override
    public String toString() {
        return "Address{" +
            "street='" + street + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", zipcode='" + zipcode + '\'' +
            '}';
    }
}
