package com.example.madhav.schoolmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.madhav.schoolmanagement.Model.Exam;
import com.example.madhav.schoolmanagement.Model.Notice;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class studentDisplayNoticeData extends AppCompatActivity {

    private Spinner spinner ;
    private Spinner spinner1;
    private EditText Subject,board ,noticeHead,AdditionalInformation;
    private DatePicker datePicker;
    private CheckBox studentWise,classWise;
    private Button submit;

    FirebaseDatabase database;
    DatabaseReference users;
    Notice notice;


    String names[] = {"Select Section","A","B","C","D"};
    String name1[]={"Select Class","1","2","3","4","5","6","7","8","9","10"};


    //defining array adpater of string type
    ArrayAdapter<String> adapter;
    String record= "";

    ArrayAdapter<String> adapter1;
    String record1= "";



    List<Notice> list;
    RecyclerView recyclerview;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_display_notice_data);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner2);
        Subject = findViewById(R.id.editText7);
        board = findViewById(R.id.editText5);
        noticeHead = findViewById(R.id.editText);
        AdditionalInformation = findViewById(R.id.editText18);
        studentWise = findViewById(R.id.checkBox2);
        classWise = findViewById(R.id.checkBox);
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        recyclerview = (RecyclerView) findViewById(R.id.rview);



//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
//        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name1);
//        spinner.setAdapter(adapter);
//        spinner1.setAdapter(adapter1);



        //Database Connection
        //Database connection
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Notice");




        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<>();

                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    Notice userdetails = dataSnapshot1.getValue(Notice.class);
                    Notice  lista = new Notice();
                    String spinnera =userdetails.getSpinner();
                    String spinnerb =userdetails.getSpinner1();
                    String Subject =userdetails.getSubject();
                    String board =userdetails.getBoard();
                    String noticeHead =userdetails.getNoticeHead();
                    String additionalInformation =userdetails.getAdditionalInformation();
                    String studentWise =userdetails.getStudentWise();
                    String classWise =userdetails.getClassWise();
                    String date_picker =userdetails.getCalendar();



//                    String student_Standard =userdetails.getStandard();
//                    String studentLoginUser =userdetails.getLoginUser();
//                    String studentloginPassword =userdetails.getLoginPassword();
//                    String student_BirthDate =userdetails.getBirthDate();
//                    String  studentAddress =userdetails.getAddress();
//                    String studentParentPhone =userdetails.getParentPhone();
//                    String student_batch =userdetails.getBatch();


                    lista.setSpinner(spinnera);
                    lista.setSpinner1(spinnerb);
                    lista.setSubject(Subject);
                    lista.setBoard(board);
                    lista.setNoticeHead(noticeHead);
                    lista.setAdditionalInformation(additionalInformation);
                    lista.setStudentWise(studentWise);
                    lista.setClassWise(classWise);
                    lista.setCalendar(date_picker);





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
                studentNoticeCustomAdapter recycler = new studentNoticeCustomAdapter(list ,studentDisplayNoticeData.this);
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(studentDisplayNoticeData.this);
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
                Intent homeIntent = new Intent(studentDisplayNoticeData.this, StudentPanel1.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
