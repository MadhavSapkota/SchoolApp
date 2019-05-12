package com.example.madhav.schoolmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.madhav.schoolmanagement.Model.Exam;
import com.example.madhav.schoolmanagement.Model.Fees;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class fee_data_admin extends AppCompatActivity {
    private EditText studentName,pathway,standard,totalFee,paidFee,remainingFee,message;
    private DatePicker datePicker;
    private Button submit;
    FirebaseDatabase database;
    DatabaseReference admin;
    List<Fees> list;
    RecyclerView recyclerview;
//    Fees fee;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_data_admin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        studentName = findViewById(R.id.editText9);
        pathway = findViewById(R.id.editText7);
        standard = findViewById(R.id.editText5);
        totalFee = findViewById(R.id.editText11);
        paidFee = findViewById(R.id.editText13);
        remainingFee = findViewById(R.id.editText15);
        message = findViewById(R.id.editText18);
        recyclerview = (RecyclerView) findViewById(R.id.rview);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        submit = findViewById(R.id.button1);


        database = FirebaseDatabase.getInstance();
        admin = database.getReference("Fees");
//        fee = new Fees();






        admin.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<>();

                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    Fees userdetails = dataSnapshot1.getValue(Fees.class);
                    Fees lista = new Fees();
                    String studentName =userdetails.getStudentName();
                    String pathway =userdetails.getPathway();
                    String standard =userdetails.getStandard();
                    String totalFee =userdetails.getTotalFee();
                    String paidFee =userdetails.getPaidFee();
                    String remainingFee =userdetails.getRemainingFee();
                    String message =userdetails.getMessage();



//                    String student_Standard =userdetails.getStandard();
//                    String studentLoginUser =userdetails.getLoginUser();
//                    String studentloginPassword =userdetails.getLoginPassword();
//                    String student_BirthDate =userdetails.getBirthDate();
//                    String  studentAddress =userdetails.getAddress();
//                    String studentParentPhone =userdetails.getParentPhone();
//                    String student_batch =userdetails.getBatch();


                    lista.setStudentName(studentName);
                    lista.setPathway(pathway);
                    lista.setStandard(standard);
                    lista.setTotalFee(totalFee);
                    lista.setPaidFee(paidFee);
                    lista.setRemainingFee(remainingFee);
                    lista.setMessage(message);

//                    lista.setSubject(subject);
//                    lista.setClassName(className);
//                    lista.setExamType(examType);
//                    lista.setMessage(message);
//                    lista.setDatePicker(date_picker);




//                    listdata.setStudent(student);
//                    listdata.setStudentName(student_fullname);
//                    listdata.setRollNumber(student_RollNumber);
//                    listdata.setEnrollNumber(studentEnrollmentNumber);
//                    listdata.setDivision(student_Division);
//                    listdata.setStandard(student_Standard);
//                    listdata.setLoginUser(studentLoginUser);
//                    listdata.setLoginPassword(studentloginPassword);
//                    listdata.setBirthDate(student_BirthDate);
//                    listdata.setAddress(studentAddress);
//                    listdata.setParentPhone(studentParentPhone);
//                    listdata.setBatch(student_batch);
                    list.add(lista);


                }

//               for(int j=0;j<list.size();j++){
//                  UserCustomAdapter clubAdapter = new UserCustomAdapter(list,adminteacherData.this );
//                  }



//                Displaying values in the ListView
                FeeAdapter recycler = new FeeAdapter(list ,fee_data_admin.this);
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(fee_data_admin.this);
                recyclerview.setLayoutManager(layoutmanager);
                recyclerview.setItemAnimator( new DefaultItemAnimator());
                recyclerview.setAdapter(recycler);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //  Log.w(TAG, "Failed to read value.", error.toException());
            }
        });








    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(fee_data_admin.this, adminDashBoard.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
