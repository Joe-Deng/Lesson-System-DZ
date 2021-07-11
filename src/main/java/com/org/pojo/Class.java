package com.org.pojo;

public class Class {
    private String ID;
    private String name;
    private String collegeId;
    private String majorId;
    private int grade;

    @Override
    public String toString() {
        return "Class{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", majorId='" + majorId + '\'' +
                ", grade=" + grade +
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

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Class(String ID, String name, String collegeId, String majorId, int grade) {
        this.ID = ID;
        this.name = name;
        this.collegeId = collegeId;
        this.majorId = majorId;
        this.grade = grade;
    }

    public Class() {
    }
}
