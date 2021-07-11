package com.org.pojo;

public class Teacher{
    private String ID;
    private String collegeId;
    private String name;
    private int sex;
    private int age;

    @Override
    public String toString() {
        return "Teacher{" +
                "ID='" + ID + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getcollegeId() {
        return collegeId;
    }

    public void setcollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher() {
    }

    public Teacher(String ID, String collegeId, String name, int sex, int age) {
        this.ID = ID;
        this.collegeId = collegeId;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
