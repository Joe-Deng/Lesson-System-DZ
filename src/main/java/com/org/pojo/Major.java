package com.org.pojo;

public class Major {
    private String ID;
    private String name;
    private String CollegeId;

    public Major() {
    }

    @Override
    public String toString() {
        return "Major{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", CollegeId='" + CollegeId + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollegeId() {
        return CollegeId;
    }

    public void setCollegeId(String collegeId) {
        CollegeId = collegeId;
    }

    public Major(String ID, String name, String collegeId) {
        this.ID = ID;
        this.name = name;
        CollegeId = collegeId;
    }
}
