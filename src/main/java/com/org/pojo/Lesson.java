package com.org.pojo;

public class Lesson {
    private String ID;
    private String name;
    private String collegeId;

    @Override
    public String toString() {
        return "Lesson{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", collegeId='" + collegeId + '\'' +
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
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public Lesson(String ID, String name, String collegeId) {
        this.ID = ID;
        this.name = name;
        this.collegeId = collegeId;
    }

    public Lesson() {
    }
}
