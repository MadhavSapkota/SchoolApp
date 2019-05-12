//TeacherDatas when a user presses teacher image from the teacherDashBoard

package com.example.madhav.schoolmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class teacherData extends AppCompatActivity {
    
    public Button course,attendance,student,teacher,leaveSt,grades,homework;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_data);
        //For the apperance of back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

       //For the grades
        grades = findViewById(R.id.button6);

        grades.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(teacherData.this,studentGradeTeacher.class);
                startActivity(intent);
                finish();

            }

        });




       //For the attendances
        attendance = findViewById(R.id.button13);

        attendance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(teacherData.this,attendanceAdmin.class);

                startActivity(intent);
                finish();

            }

        });


      //For the course
        course = findViewById(R.id.button8);

        course.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(teacherData.this,NewsActivity1.class);
                startActivity(intent);
                finish();

            }

        });
       //For the leaveeaveDetail
        leaveSt = findViewById(R.id.button12);
        leaveSt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(teacherData.this,leaveDetails.class);
                startActivity(intent);
                finish();

            }

        });

     //For the homework
        homework = findViewById(R.id.button9);
        homework.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(teacherData.this,teacherPanelHomework.class);
                startActivity(intent);
                finish();

            }

        });



    }


//Implementation of back arrow
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(teacherData.this, teacherDashboard.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
