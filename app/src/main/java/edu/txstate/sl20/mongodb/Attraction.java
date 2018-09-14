package edu.txstate.sl20.mongodb;

/**
 * Created by sl20 on 4/23/2018.
 */

public class Attraction {
    private int id;
    private String name;
    private String phone;
    private String address;
    private double cost;
    private int image;
    private String objectId;

    public Attraction(int id, String name, String phone, String address,
                      double cost, int image, String objectId, String url) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.cost = cost;
        this.image = image;
        this.objectId = objectId;
        this.url = url;
    }

    public String getObjectId() {

        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    public Attraction(int id, String name, String phone,
                      String address, double cost, int image, String url) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.cost = cost;
        this.image = image;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return name + ", " + phone;
    }

}
