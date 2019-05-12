package com.example.madhav.schoolmanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madhav.schoolmanagement.Model.Exam;
import com.example.madhav.schoolmanagement.Model.Fees;
import com.example.madhav.schoolmanagement.Model.Notice;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class exam_panel_admin extends AppCompatActivity {
    private EditText subject;
    private  EditText examType ,message,className;
    private DatePicker datePicker;
    private Button submit;
    FirebaseDatabase database;
    DatabaseReference student;
    Exam exam;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_panel_panel);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        subject= findViewById(R.id.editText7);
        className= findViewById(R.id.editText17);
        examType= findViewById(R.id.editText5);
        message = findViewById(R.id.editText18);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        submit = findViewById(R.id.button1);


        database = FirebaseDatabase.getInstance();
        student = database.getReference("Exam");
//        exam = new Exam();


        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {

                String Sb = subject.getText().toString();
                if(TextUtils.isEmpty(Sb)) {
                    subject.setError("Insert Subject");
                    return;
                }

                String cN = className.getText().toString();
                if(TextUtils.isEmpty(cN)) {
                    className.setError("Insert ClassName");
                    return;
                }

                String eT = examType.getText().toString();
                if(TextUtils.isEmpty(eT)) {
                    examType.setError("Insert ExamType");
                    return;
                }
                String Me = message.getText().toString();
                if(TextUtils.isEmpty(Me)) {
                    message.setError("Insert Message");
                    return;
                }


//                btnInsert();
                String subject1 = subject.getText().toString();
                String className1 = className.getText().toString();
                String examType1 = examType.getText().toString();
                String message1 = message.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String datePicker1 = sdf.format(new Date(datePicker.getMonth()));

                String key = student.push().getKey();
                exam = new Exam();


                exam.setSubject(subject1);
                exam.setClassName(className1);
                exam.setExamType(examType1);
                exam.setMessage(message1);
                exam.setDatePicker(datePicker1);

                student.child(key).setValue(exam);
                subject.setText("");
                className.setText("");
                examType.setText("");
                message.setText("");
                datePicker.setMaxDate(2019);


                Toast.makeText(exam_panel_admin.this,"Exam Data Inserted...",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(exam_panel_admin.this,adminDashBoard.class);
                startActivity(intent);
                finish();




            }
        });
    }

//    private void getValues(){
//        exam.setSubject(subject.getText().toString());
//        exam.setClassName(className.getText().toString());
//        exam.setExamType(examType.getText().toString());
//        exam.setMessage(message.getText().toString());
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        exam.setDatePicker(sdf.format(new Date(datePicker.getMonth())));
//    }

//    public void btnInsert(){
//        student.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange (@NonNull DataSnapshot dataSnapshot) {
//                getValues();
//                student.child("Admin").setValue(exam);
//                //Toast.makeText(teacher_admin_panel.this , "Data Inserted...",Toast.LENGTH_SHORT.show());
//                Toast.makeText(exam_panel_admin.this,"Database Inserted...",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(exam_panel_admin.this,adminDashBoard.class);
//                startActivity(intent);
//                finish();
//            }
//
//            @Override
//            public void onCancelled (@NonNull DatabaseError databaseError) {
//                Toast.makeText(exam_panel_admin.this,"Database Error",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }





    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(exam_panel_admin.this, adminDashBoard.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
