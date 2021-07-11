package com.org.pojo;

public class TeacherSchedule {
    private String ID;
    private String teacherId;
    private String lessonId;
    private int schedule;

    @Override
    public String toString() {
        return "TeacherSchedule{" +
                "ID='" + ID + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", lessonId='" + lessonId + '\'' +
                ", schedule=" + schedule +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public TeacherSchedule(String ID, String teacherId, String lessonId, int schedule) {
        this.ID = ID;
        this.teacherId = teacherId;
        this.lessonId = lessonId;
        this.schedule = schedule;
    }

    public TeacherSchedule() {
    }
}
