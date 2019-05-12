package com.example.madhav.schoolmanagement.Model;

import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Notice {
    private String spinner ;
    private String spinner1;
    private String Subject;
    private String board ;
    private String noticeHead;
    private String AdditionalInformation;
    private String calendar;
    private String studentWise;
    private String classWise;


    public Notice ( ) {
    }

    public Notice (String spinner , String spinner1 , String subject , String board , String noticeHead , String additionalInformation , String calendar , String studentWise , String classWise) {
        this.spinner = spinner;
        this.spinner1 = spinner1;
        Subject = subject;
        this.board = board;
        this.noticeHead = noticeHead;
        AdditionalInformation = additionalInformation;
        this.calendar = calendar;
        this.studentWise = studentWise;
        this.classWise = classWise;
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

    public String getSubject ( ) {
        return Subject;
    }

    public void setSubject (String subject) {
        Subject = subject;
    }

    public String getBoard ( ) {
        return board;
    }

    public void setBoard (String board) {
        this.board = board;
    }

    public String getNoticeHead ( ) {
        return noticeHead;
    }

    public void setNoticeHead (String noticeHead) {
        this.noticeHead = noticeHead;
    }

    public String getAdditionalInformation ( ) {
        return AdditionalInformation;
    }

    public void setAdditionalInformation (String additionalInformation) {
        AdditionalInformation = additionalInformation;
    }

    public String getCalendar ( ) {
        return calendar;
    }

    public void setCalendar (String calendar) {
        this.calendar = calendar;
    }

    public String getStudentWise ( ) {
        return studentWise;
    }

    public void setStudentWise (String studentWise) {
        this.studentWise = studentWise;
    }

    public String getClassWise ( ) {
        return classWise;
    }

    public void setClassWise (String classWise) {
        this.classWise = classWise;
    }


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("spinner", spinner);
        result.put("spinner1", spinner1);
        result.put("Subject", Subject);
        result.put("board", board);
        result.put("noticeHead", noticeHead);
        result.put("AdditionalInformation",AdditionalInformation );
        result.put("calender",calendar );
        result.put("studentWise",studentWise );
        result.put("classWise",classWise);

        return result;



    }
}

