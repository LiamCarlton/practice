package com.example.projecttower;

import android.location.Address;

import java.io.Serializable;

public abstract class Person implements Serializable
{
    private String firstName;
    private String lastName;
    private String id;
    private String phone;
    private Address address;
    private idCreate idCreate = new idCreate();


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = idCreate.createID();
    }

    public String getId() {
        return id;
    }

}
