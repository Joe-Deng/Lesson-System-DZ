package com.org.pojo;

public class Instruct {
    private String ID;
    private String classId;
    private String lessonId;
    private String teacherId;
    private int schedule;

    public Instruct() {
    }

    @Override
    public String toString() {
        return "Instruct{" +
                "ID='" + ID + '\'' +
                ", classId='" + classId + '\'' +
                ", lessonId='" + lessonId + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", schedule=" + schedule +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public Instruct(String ID, String classId, String lessonId, String teacherId, int schedule) {
        this.ID = ID;
        this.classId = classId;
        this.lessonId = lessonId;
        this.teacherId = teacherId;
        this.schedule = schedule;
    }
}
