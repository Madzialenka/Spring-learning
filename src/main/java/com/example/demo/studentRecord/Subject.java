package com.example.demo.studentRecord;

public class Subject {
    private Long id;
    private String subjectName;
    private SubjectType subjectType;
    private Double grade;
    private Integer ects;

    public Subject() {
    }

    public Subject(Long id, String subjectName, SubjectType subjectType, Double grade, Integer ects) {
        this.id = id;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
        this.grade = grade;
        this.ects = ects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Integer getEcts() {
        return ects;
    }

    public void setEcts(Integer ects) {
        this.ects = ects;
    }
}
