package com.org.pojo;

public class Student{
    private String ID;
    private String name;
    private String collegeId;
    private String classId;
    private int sex;
    private int grade;
    private String mobile_phone;
    private String avatar;

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", classId='" + classId + '\'' +
                ", sex=" + sex +
                ", grade=" + grade +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", avatar='" + avatar + '\'' +
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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Student(String ID, String name, String collegeId, String classId, int sex, int grade, String mobile_phone, String avatar) {
        this.ID = ID;
        this.name = name;
        this.collegeId = collegeId;
        this.classId = classId;
        this.sex = sex;
        this.grade = grade;
        this.mobile_phone = mobile_phone;
        this.avatar = avatar;
    }

    public Student() {
    }
}
