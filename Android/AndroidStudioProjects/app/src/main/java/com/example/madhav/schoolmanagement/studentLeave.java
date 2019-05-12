package com.example.madhav.schoolmanagement;
public class studentLeave {


    private String  student_fullname,student_RollNumber,studentDivision,
            student_Standard,leave_Type,from_date,to_date,message_details;

    public studentLeave ( ) {
    }

    public studentLeave (String student_fullname , String student_RollNumber , String studentDivision , String student_Standard , String leave_Type , String from_date , String to_date , String message_details) {
        this.student_fullname = student_fullname;
        this.student_RollNumber = student_RollNumber;
        this.studentDivision = studentDivision;
        this.student_Standard = student_Standard;
        this.leave_Type = leave_Type;
        this.from_date = from_date;
        this.to_date = to_date;
        this.message_details = message_details;
    }

    public String getStudent_fullname ( ) {
        return student_fullname;
    }

    public void setStudent_fullname (String student_fullname) {
        this.student_fullname = student_fullname;
    }

    public String getStudent_RollNumber ( ) {
        return student_RollNumber;
    }

    public void setStudent_RollNumber (String student_RollNumber) {
        this.student_RollNumber = student_RollNumber;
    }

    public String getStudentDivision ( ) {
        return studentDivision;
    }

    public void setStudentDivision (String studentDivision) {
        this.studentDivision = studentDivision;
    }

    public String getStudent_Standard ( ) {
        return student_Standard;
    }

    public void setStudent_Standard (String student_Standard) {
        this.student_Standard = student_Standard;
    }

    public String getLeave_Type ( ) {
        return leave_Type;
    }

    public void setLeave_Type (String leave_Type) {
        this.leave_Type = leave_Type;
    }

    public String getFrom_date ( ) {
        return from_date;
    }

    public void setFrom_date (String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date ( ) {
        return to_date;
    }

    public void setTo_date (String to_date) {
        this.to_date = to_date;
    }

    public String getMessage_details ( ) {
        return message_details;
    }

    public void setMessage_details (String message_details) {
        this.message_details = message_details;
    }
}
