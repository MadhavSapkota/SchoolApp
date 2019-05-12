package com.example.madhav.schoolmanagement.Model;

public class Attendance {
    private String spinner;
    private String spinner1;
    private String spinner2;
    private String studentId;
    private String studentName;
    private String date;

    public Attendance ( ) {
    }

    public Attendance (String spinner , String spinner1 , String spinner2 , String studentId , String studentName , String date) {
        this.spinner = spinner;
        this.spinner1 = spinner1;
        this.spinner2 = spinner2;
        this.studentId = studentId;
        this.studentName = studentName;
        this.date = date;
    }

    public String getSpinner ( ) {
        return spinner;
    }

    public void setSpinner (String spinner) {
        this.spinner = spinner;
    }

    public String getSpinner1 ( ) {
        return spinner1;
    }

    public void setSpinner1 (String spinner1) {
        this.spinner1 = spinner1;
    }

    public String getSpinner2 ( ) {
        return spinner2;
    }

    public void setSpinner2 (String spinner2) {
        this.spinner2 = spinner2;
    }

    public String getStudentId ( ) {
        return studentId;
    }

    public void setStudentId (String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName ( ) {
        return studentName;
    }

    public void setStudentName (String studentName) {
        this.studentName = studentName;
    }

    public String getDate ( ) {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }
}
