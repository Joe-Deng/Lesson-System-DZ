package com.dz.entity;

public class InstructInfo {
    private String classId;
    private String className;
    private String lessonId;
    private String lessonName;
    private String teacherId;
    private String teacherName;
    private int schedule;

    @Override
    public String toString() {
        return "InstructInfo{" +
                "classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", lessonId='" + lessonId + '\'' +
                ", lessonName='" + lessonName + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", schedule=" + schedule +
                '}';
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public InstructInfo(String classId, String className, String lessonId, String lessonName, String teacherId, String teacherName, int schedule) {
        this.classId = classId;
        this.className = className;
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.schedule = schedule;
    }
}
