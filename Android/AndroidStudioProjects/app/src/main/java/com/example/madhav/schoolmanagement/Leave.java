package com.example.madhav.schoolmanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Leave extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference users;
    studentLeave leave;
    private EditText student_fullname,student_RollNumber,studentDivision,
            student_Standard,leave_Type,from_date,to_date,message_details;

    private Button submit;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_leave);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        student_fullname = findViewById(R.id.editText26);
        student_RollNumber = findViewById(R.id.editText24);
        studentDivision = findViewById(R.id.editText22);
        student_Standard = findViewById(R.id.editText18);
        leave_Type = findViewById(R.id.editText16);
        from_date = findViewById(R.id.editText14);
        to_date = findViewById(R.id.editText12);
        message_details = findViewById(R.id.editText10);
        submit = findViewById(R.id.button1);

        //Database connection
        database = FirebaseDatabase.getInstance();
        users = database.getReference("studentLeave");
        leave = new studentLeave();


        submit.setOnClickListener(new View.OnClickListener() {
       public void onClick(View v) {
          String student_fullname1 =   student_fullname.getText().toString();
           String student_RollNumber1 = student_RollNumber.getText().toString();
          String studentDivision1 = studentDivision.getText().toString();
          String student_Standard1 = student_Standard.getText().toString();
          String leave_Type1 = leave_Type.getText().toString();
          String  from_date1 = from_date.getText().toString();
          String to_date1 = to_date.getText().toString();
          String message_details1 = message_details.getText().toString();


           String key = users.push().getKey();
           studentLeave userdetails = new studentLeave();

           userdetails.setStudent_fullname(student_fullname1);
           userdetails.setStudent_RollNumber(student_RollNumber1);
           userdetails.setStudentDivision(studentDivision1);
           userdetails.setStudent_Standard(student_Standard1);
           userdetails.setLeave_Type(leave_Type1);
           userdetails.setFrom_date(from_date1);
           userdetails.setTo_date(to_date1);
           userdetails.setMessage_details(message_details1);

           users.child(key).setValue(userdetails);
           student_fullname.setText("");
           student_RollNumber.setText("");
           student_RollNumber.setText("");
           studentDivision.setText("");
           student_Standard.setText("");
           leave_Type.setText("");
           from_date.setText("");
           to_date.setText("");
           message_details.setText("");



            }
        });
    }
//    private void getValues(){
//
//        leave.setStudent_fullname(student_fullname.getText().toString());
//        leave.setStudent_RollNumber(student_RollNumber.getText().toString());
//        leave.setStudentDivision(studentDivision.getText().toString());
////        leave.setEmail(ContactsContract.CommonDataKinds.Email.getText().toString());
//        leave.setStudent_Standard(student_Standard.getText().toString());
//        leave.setLeave_Type(leave_Type.getText().toString());
//        leave.setFrom_date(from_date.getText().toString());
//        leave.setTo_date(to_date.getText().toString());
//        leave.setMessage_details(message_details.getText().toString());
////        leave.setTeacherContact(teacherPhone.getText().toString());
////        leave.setNumberOfClass(numberOfClass.getText().toString());
////        leave.setTeacherBatch(teacherBatch.getText().toString());
//
//
//    }
//
//    public void btnInsert ( ){
//        users.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange (@NonNull DataSnapshot dataSnapshot) {
//                getValues();
//                users.child("Teacher").setValue(leave);
//                //Toast.makeText(teacher_admin_panel.this , "Data Inserted...",Toast.LENGTH_SHORT.show());
//                Toast.makeText(Leave.this,"Database Inserted...",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Leave.this,DashBoardActivity.class);
//                startActivity(intent);
//                finish();
//
//            }
//
//            @Override
//            public void onCancelled (@NonNull DatabaseError databaseError) {
//                Toast.makeText(Leave.this,"Database Error",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//





    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(Leave.this, studentDataStudentPanel.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));

    }
}
