package com.example.garrett.assignment1;

public class Nightclub {

    private int nightclubID;
    private String nightclubName;
    private String streetaddress;
    private String city;
    private String state;
    private String zipcode;
    private int beer;
    private int wine;
    private int music;
    private double average =  ( beer + wine + music )/3;

    public Nightclub() {
        nightclubID = -1;
    }

    public int getNightclubID() {
        return nightclubID;
    }

    public void setNightclubID(int nightclubID) {this.nightclubID = nightclubID;}

    public String getNightclubName() {
        return nightclubName;
    }

    public void setNightclubName(String nightclubName) {
        this.nightclubName = nightclubName;
    }

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
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

    public int getBeer() {
        return beer;
    }

    public void setBeer(int beer) {
        this.beer = beer;
    }

    public int getWine() {
        return wine;
    }

    public void setWine(int wine) {
        this.wine = wine;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
