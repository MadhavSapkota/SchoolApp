package com.example.madhav.schoolmanagement.Model;

public class Teacher {
    private String teacherId;
    private String teacherFullName;
    private String teacherCodeNumber;
    private String Department;
    private String Email;
    private String qualificationStandard;
    private String teacherLoginUsername;
    private String teacherLoginPassword;
    private String teacherBirthDate;
    private String teacherAddress;
    private String teacherContact;
    private String numberOfClass;
    private String teacherBatch;

    public Teacher () {
    }

    public Teacher (String teacherId , String teacherFullName , String teacherCodeNumber , String department , String email , String qualificationStandard , String teacherLoginUsername , String teacherLoginPassword ,
                    String teacherBirthDate , String teacherAddress , String teacherContact , String numberOfClass , String teacherBatch) {
        this.teacherId = teacherId;
        this.teacherFullName = teacherFullName;
        this.teacherCodeNumber = teacherCodeNumber;
        Department = department;
        Email = email;
        this.qualificationStandard = qualificationStandard;
        this.teacherLoginUsername = teacherLoginUsername;
        this.teacherLoginPassword = teacherLoginPassword;
        this.teacherBirthDate = teacherBirthDate;
        this.teacherAddress = teacherAddress;
        this.teacherContact = teacherContact;
        this.numberOfClass = numberOfClass;
        this.teacherBatch = teacherBatch;
    }

    public String getTeacherId ( ) {
        return teacherId;
    }

    public void setTeacherId (String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherFullName ( ) {
        return teacherFullName;
    }

    public void setTeacherFullName (String teacherFullName) {
        this.teacherFullName = teacherFullName;
    }

    public String getTeacherCodeNumber ( ) {
        return teacherCodeNumber;
    }

    public void setTeacherCodeNumber (String teacherCodeNumber) {
        this.teacherCodeNumber = teacherCodeNumber;
    }

    public String getDepartment ( ) {
        return Department;
    }

    public void setDepartment (String department) {
        Department = department;
    }

    public String getEmail ( ) {
        return Email;
    }

    public void setEmail (String email) {
        Email = email;
    }

    public String getQualificationStandard ( ) {
        return qualificationStandard;
    }

    public void setQualificationStandard (String qualificationStandard) {
        this.qualificationStandard = qualificationStandard;
    }

    public String getTeacherLoginUsername ( ) {
        return teacherLoginUsername;
    }

    public void setTeacherLoginUsername (String teacherLoginUsername) {
        this.teacherLoginUsername = teacherLoginUsername;
    }

    public String getTeacherLoginPassword ( ) {
        return teacherLoginPassword;
    }

    public void setTeacherLoginPassword (String teacherLoginPassword) {
        this.teacherLoginPassword = teacherLoginPassword;
    }

    public String getTeacherBirthDate ( ) {
        return teacherBirthDate;
    }

    public void setTeacherBirthDate (String teacherBirthDate) {
        this.teacherBirthDate = teacherBirthDate;
    }

    public String getTeacherAddress ( ) {
        return teacherAddress;
    }

    public void setTeacherAddress (String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherContact ( ) {
        return teacherContact;
    }

    public void setTeacherContact (String teacherContact) {
        this.teacherContact = teacherContact;
    }

    public String getNumberOfClass ( ) {
        return numberOfClass;
    }

    public void setNumberOfClass (String numberOfClass) {
        this.numberOfClass = numberOfClass;
    }

    public String getTeacherBatch ( ) {
        return teacherBatch;
    }

    public void setTeacherBatch (String teacherBatch) {
        this.teacherBatch = teacherBatch;
    }
}


