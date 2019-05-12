package com.example.madhav.schoolmanagement.Model;

public class Fees {
   private String studentName;
    private String pathway;
    private  String standard;
    private String totalFee;
    private String paidFee;
    private String remainingFee;
    private String  message;

    public String getDatePicker ( ) {
        return datePicker;
    }

    public void setDatePicker (String datePicker) {
        this.datePicker = datePicker;
    }

    private String datePicker;

    public Fees (String datePicker) {
        this.datePicker = datePicker;
    }



    public Fees ( ) {
    }

    public Fees (String studentName , String pathway , String standard , String totalFee , String paidFee , String remainingFee , String message) {
        this.studentName = studentName;
        this.pathway = pathway;
        this.standard = standard;
        this.totalFee = totalFee;
        this.paidFee = paidFee;
        this.remainingFee = remainingFee;
        this.message = message;
    }

    public String getStudentName ( ) {
        return studentName;
    }

    public void setStudentName (String studentName) {
        this.studentName = studentName;
    }

    public String getPathway ( ) {
        return pathway;
    }

    public void setPathway (String pathway) {
        this.pathway = pathway;
    }

    public String getStandard ( ) {
        return standard;
    }

    public void setStandard (String standard) {
        this.standard = standard;
    }

    public String getTotalFee ( ) {
        return totalFee;
    }

    public void setTotalFee (String totalFee) {
        this.totalFee = totalFee;
    }

    public String getPaidFee ( ) {
        return paidFee;
    }

    public void setPaidFee (String paidFee) {
        this.paidFee = paidFee;
    }

    public String getRemainingFee ( ) {
        return remainingFee;
    }

    public void setRemainingFee (String remainingFee) {
        this.remainingFee = remainingFee;
    }

    public String getMessage ( ) {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }
}
