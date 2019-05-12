package com.example.madhav.schoolmanagement.Model;

import android.text.Editable;


import java.util.HashMap;
import java.util.Map;


public class Students {
    private String studentId;
    private String studentName;
    private String RollNumber;
    private String Division;
    private String EnrollNumber;
    private String Standard;
    private String LoginUser;
    private String LoginPassword;
    private String BirthDate;
    private String Address;
    private String ParentPhone;
    private String Batch;

    public Students () {
    }


    public Students (String studentId , String studentName , String rollNumber , String division , String enrollNumber , String standard , String loginUser , String loginPassword , String birthDate ,
                     String address , String parentPhone, String batch ) {
        this.studentId = studentId;
        this.studentName = studentName;
        RollNumber = rollNumber;
        Division = division;
        EnrollNumber = enrollNumber;
        Standard = standard;
        LoginUser = loginUser;
        LoginPassword = loginPassword;
        BirthDate = birthDate;
        Address = address;
        ParentPhone = parentPhone;
        Batch = batch;
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

    public String getRollNumber ( ) {
        return RollNumber;
    }

    public void setRollNumber (String rollNumber) {
        RollNumber = rollNumber;
    }

    public String getDivision ( ) {
        return Division;
    }

    public void setDivision (String division) {
        Division = division;
    }

    public String getEnrollNumber ( ) {
        return EnrollNumber;
    }

    public void setEnrollNumber (String enrollNumber) {
        EnrollNumber = enrollNumber;
    }

    public String getStandard ( ) {
        return Standard;
    }

    public void setStandard (String standard) {
        Standard = standard;
    }

    public String getLoginUser ( ) {
        return LoginUser;
    }

    public void setLoginUser (String loginUser) {
        LoginUser = loginUser;
    }

    public String getLoginPassword ( ) {
        return LoginPassword;
    }

    public void setLoginPassword (String loginPassword) {
        LoginPassword = loginPassword;
    }

    public String getBirthDate ( ) {
        return BirthDate;
    }

    public void setBirthDate (String birthDate) {
        BirthDate = birthDate;
    }

    public String getAddress ( ) {
        return Address;
    }

    public void setAddress (String address) {
        Address = address;
    }

    public String getParentPhone ( ) {
        return ParentPhone;
    }

    public void setParentPhone (String parentPhone) {
        ParentPhone = parentPhone;
    }

    public String getBatch ( ) {
        return Batch;
    }

    public void setBatch (String batch) {
        Batch = batch;
    }





}

