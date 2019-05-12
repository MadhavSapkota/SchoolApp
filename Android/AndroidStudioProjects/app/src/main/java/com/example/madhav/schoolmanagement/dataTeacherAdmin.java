package com.example.madhav.schoolmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.madhav.schoolmanagement.Model.Students;
import com.example.madhav.schoolmanagement.Model.Teacher;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class dataTeacherAdmin extends AppCompatActivity {
    private EditText teacherId,teacher_fullname,teacher_CodeNumber,Department,Email,
            qualificationStandard,teacherLoginUser,teacherLoginPassword,teacherBirthDate,teacherAddress,
            teacherPhone,numberOfClass,teacherBatch;
    FirebaseDatabase database;
    DatabaseReference users1;
//    Teacher teacher;
    List<Teacher> list;
    RecyclerView recyclerview;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_teacher_admin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        teacherId = findViewById(R.id.editText28);
        teacher_fullname = findViewById(R.id.editText26);
        teacher_CodeNumber = findViewById(R.id.editText24);
        Department = findViewById(R.id.editText22);
        Email = findViewById(R.id.editText20);
        qualificationStandard = findViewById(R.id.editText18);
        teacherLoginUser = findViewById(R.id.editText16);
        teacherLoginPassword = findViewById(R.id.editText14);
        teacherBirthDate = findViewById(R.id.editText12);
        teacherAddress = findViewById(R.id.editText10);
        teacherPhone = findViewById(R.id.editText8);
        numberOfClass = findViewById(R.id.editText6);
        teacherBatch = findViewById(R.id.editText4);

        recyclerview = (RecyclerView) findViewById(R.id.rview);


        //Database Connection
        database = FirebaseDatabase.getInstance();
        users1= database.getReference("Teacher");


        users1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<>();

                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    Teacher userdetails = dataSnapshot1.getValue(Teacher.class);
                    Teacher listdata = new Teacher();
                    String teacher_id =userdetails.getTeacherId();
                    String teacher_fullname =userdetails.getTeacherFullName();
                    String teacher_CodeNumber =userdetails.getTeacherCodeNumber();
                    String department =userdetails.getDepartment();
                    String email =userdetails.getEmail();
                    String qualificationStandard =userdetails.getQualificationStandard();
                    String LoginUser =userdetails.getTeacherLoginUsername();
                    String loginPassword =userdetails.getTeacherLoginPassword();
                    String BirthDate =userdetails.getTeacherBirthDate();
                    String address =userdetails.getTeacherAddress();
                    String teacherContact =userdetails.getTeacherContact();
                    String numberOfClass =userdetails.getNumberOfClass();
                    String teacherBatch =userdetails.getTeacherBatch();






                    listdata.setTeacherId(teacher_id );
                    listdata.setTeacherFullName(teacher_fullname);
                    listdata.setTeacherCodeNumber(teacher_CodeNumber);
                    listdata.setDepartment(department);
                    listdata.setEmail(email);
                    listdata.setQualificationStandard(qualificationStandard);
                    listdata.setTeacherLoginUsername(LoginUser);
                    listdata.setTeacherLoginPassword(loginPassword);
                    listdata.setTeacherBirthDate(BirthDate);
                    listdata.setTeacherAddress(address);
                    listdata.setTeacherContact(teacherContact);
                    listdata.setNumberOfClass(numberOfClass);
                    listdata.setTeacherBatch(teacherBatch);
                    list.add(listdata);


                }

//               for(int j=0;j<list.size();j++){
//                  UserCustomAdapter clubAdapter = new UserCustomAdapter(list,adminteacherData.this );
//                  }



//                Displaying values in the ListView
                TeacherCustomAdapter recycler = new TeacherCustomAdapter(list ,dataTeacherAdmin.this);
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(dataTeacherAdmin.this);
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
                Intent homeIntent = new Intent(dataTeacherAdmin.this, adminDashBoard.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));

    }
}
