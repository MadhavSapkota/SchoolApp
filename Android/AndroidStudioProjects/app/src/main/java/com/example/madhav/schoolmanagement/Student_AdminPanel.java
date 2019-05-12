package com.example.madhav.schoolmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button; // this was missing earlier
import android.widget.EditText;
import android.widget.Toast;

import com.example.madhav.schoolmanagement.Model.Students;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Student_AdminPanel extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference users;
    Students student;

    private Button submit;
    private EditText studentId,student_fullname,student_RollNumber,studentDivision,studentEnrollNumber,
            student_Standard,student_LoginUser,student_LoginPassword,student_BirthDate,student_Address,
            student_ParentPhone,student_Semester,student_batch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_admin_panel);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        studentId = findViewById(R.id.editText28);
        student_fullname = findViewById(R.id.editText26);
        student_RollNumber = findViewById(R.id.editText24);
        studentDivision = findViewById(R.id.editText22);
        studentEnrollNumber = findViewById(R.id.editText20);
        student_Standard = findViewById(R.id.editText18);
        student_LoginUser = findViewById(R.id.editText16);
        student_LoginPassword = findViewById(R.id.editText14);
        student_BirthDate = findViewById(R.id.editText12);
        student_Address = findViewById(R.id.editText10);
        student_ParentPhone = findViewById(R.id.editText8);
//        student_Semester = findViewById(R.id.editText6);
        student_batch = findViewById(R.id.editText4);
        submit = findViewById(R.id.button1);

        //Database connection
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Students");
//        student = new Students();


        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                String userN = studentId.getText().toString();
                if(TextUtils.isEmpty(userN)) {
                    studentId.setError("Insert StudentId");
                    return;
                }

                String stF = student_fullname.getText().toString();
                if(TextUtils.isEmpty(stF)) {
                    student_fullname.setError("Insert Student FullName");
                    return;
                }

                String sR = student_RollNumber.getText().toString();
                if(TextUtils.isEmpty(sR)) {
                    student_RollNumber.setError("Insert RollNumber");
                    return;
                }

                String stD = studentDivision.getText().toString();
                if(TextUtils.isEmpty(stD)) {
                    studentDivision.setError("Insert StudentDivision");
                    return;
                }

                String stEn = studentEnrollNumber.getText().toString();
                if(TextUtils.isEmpty(stEn)) {
                    studentEnrollNumber.setError("Insert StudentDivision");
                    return;
                }

                String stSt = student_Standard.getText().toString();
                if(TextUtils.isEmpty(stSt)) {
                    student_Standard.setError("Insert Student Standard");
                    return;
                }

                String stLU = student_LoginUser.getText().toString();
                if(TextUtils.isEmpty(stLU)) {
                    student_LoginUser.setError("Insert StudentLoginName");
                    return;
                }

                String stLP = student_LoginPassword.getText().toString();
                if(TextUtils.isEmpty(stLP)) {
                    student_LoginPassword.setError("Insert StudentPassword");
                    return;
                }

                String stBd = student_BirthDate.getText().toString();
                if(TextUtils.isEmpty(stBd)) {
                    student_BirthDate.setError("Insert Student Birthdate");
                    return;
                }

                String stAd = student_Address.getText().toString();
                if(TextUtils.isEmpty(stAd)) {
                    student_Address.setError("Insert Student Address");
                    return;
                }

                String stPP = student_ParentPhone.getText().toString();
                if(TextUtils.isEmpty(stPP)) {
                    student_ParentPhone.setError("Insert ParentPhone");
                    return;
                }

                String stBat = student_batch.getText().toString();
                if(TextUtils.isEmpty(stBat)) {
                    student_batch.setError("Insert Batch");
                    return;
                }








                String id = studentId.getText().toString();
                String fullname = student_fullname.getText().toString();
                String RollNumber = student_RollNumber.getText().toString();
                String division = studentDivision.getText().toString();
                String EnrollNumber = studentEnrollNumber.getText().toString();
                String standard = student_Standard.getText().toString();
                String loginUser = student_LoginUser.getText().toString();
                String loginPassword = student_LoginPassword.getText().toString();
                String birthDate = student_BirthDate.getText().toString();
                String studentAddress = student_Address.getText().toString();
                String parentPhone = student_ParentPhone.getText().toString();
//                String semester = student_Semester.getText().toString();
                String studentBatch = student_batch.getText().toString();


                String key = users.push().getKey();
                student = new Students();
//                student.setName(name);




                student.setStudentId(id);
                student.setStudentName(fullname);
                student.setRollNumber(RollNumber);
                student.setDivision(division);
                student.setEnrollNumber(EnrollNumber);
                student.setStandard(standard);
                student.setLoginUser(loginUser);
                student.setLoginPassword(loginPassword);
                student.setBirthDate(birthDate);
                student.setAddress(studentAddress);
                student.setParentPhone(parentPhone);
//                student.setStudentId(semester);
                student.setBatch(studentBatch);


                users.child(key).setValue(student);
                studentId.setText("");
                student_fullname.setText("");
                student_RollNumber.setText("");
                studentDivision.setText("");
                studentEnrollNumber.setText("");
                student_Standard.setText("");
                student_LoginUser.setText("");
                student_LoginPassword.setText("");
                student_BirthDate.setText("");
                student_Address.setText("");
                student_ParentPhone.setText("");
                student_batch.setText("");






//                btnInsert();
//                getValues();

//                String key = users.push().getKey();
//                student = new Students();
//
//                users.child(key).setValue(student);
               Toast.makeText(Student_AdminPanel.this,"StudentData Inserted...",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Student_AdminPanel.this,adminDashBoard.class);
                startActivity(intent);
                finish();




            }
        });
    }

//    private void getValues(){
//
//
//        student.setStudentId(studentId.getText().toString());
//        student.setStudentName(student_fullname.getText().toString());
//        student.setRollNumber(student_RollNumber.getText().toString());
//        student.setDivision(studentDivision.getText().toString());
//        student.setEnrollNumber(studentEnrollNumber.getText().toString());
//        student.setStandard(student_Standard.getText().toString());
//        student.setLoginUser(student_LoginUser.getText().toString());
//        student.setLoginPassword(student_LoginPassword.getText().toString());
//        student.setBirthDate(student_BirthDate.getText().toString());
//        student.setAddress(student_Address.getText().toString());
//        student.setParentPhone(student_ParentPhone.getText().toString());
//        student.setStudentId(student_Semester.getText().toString());
//        student.setBatch(student_batch.getText().toString());
//
//
////        String key = users.push().getKey();
////        users.child(key).setValue(student);
//
//
//    }
//
//
//
//    public void btnInsert ( ){
//        users.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange (@NonNull DataSnapshot dataSnapshot) {
//                getValues();
////                String key = users.push().getKey();
////                users.setValue(student);
////                users.child(key).setValue(student);
//
//
////                users.child("Admin").setValue(student);
//
//                //Toast.makeText(teacher_admin_panel.this , "Data Inserted...",Toast.LENGTH_SHORT.show());
//                Toast.makeText(Student_AdminPanel.this,"Database Inserted...",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Student_AdminPanel.this,adminDashBoard.class);
//                startActivity(intent);
//                finish();
//
//            }
//
//            @Override
//            public void onCancelled (@NonNull DatabaseError databaseError) {
//                Toast.makeText(Student_AdminPanel.this,"Database Error",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(Student_AdminPanel.this, adminDashBoard.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }



    }

