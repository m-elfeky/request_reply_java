package com.requestreply.server.DTO;

////// sample DTO class to explain the idea .
public class Data {

    String name;
    String id;


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        // quick toString method to print the object
        return "Hello " + name +   ". Your Id is " + id;
    }
}
