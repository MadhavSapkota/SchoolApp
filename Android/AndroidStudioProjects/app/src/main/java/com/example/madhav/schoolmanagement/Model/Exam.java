package com.example.madhav.schoolmanagement.Model;

public class Exam {
    private String Subject;
    private String examType;
    private  String datePicker;
    private String message;
    private String className;



//    public Exam (String subject) {
//        Subject = subject;
//    }



    public Exam ( ) {
    }

    public Exam (String subject , String examType , String datePicker , String message,String className) {
        Subject = subject;
        this.examType = examType;
        this.datePicker = datePicker;
        this.message = message;
        this.className = className;
    }

    public String getSubject ( ) {
        return Subject;
    }

    public void setSubject (String subject) {
        Subject = subject;
    }

    public String getExamType ( ) {
        return examType;
    }

    public void setExamType (String examType) {
        this.examType = examType;
    }

    public String getDatePicker ( ) {
        return datePicker;
    }

    public void setDatePicker (String datePicker) {
        this.datePicker = datePicker;
    }

    public String getMessage ( ) {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }


    public String getClassName ( ) {
        return className;
    }

    public void setClassName (String className) {
        this.className = className;
    }
}

