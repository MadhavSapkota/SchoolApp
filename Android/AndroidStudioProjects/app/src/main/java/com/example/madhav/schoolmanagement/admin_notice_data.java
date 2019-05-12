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

public class admin_notice_data extends AppCompatActivity {

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
        setContentView(R.layout.activity_admin_notice_data);
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



                    lista.setSpinner(spinnera);
                    lista.setSpinner1(spinnerb);
                    lista.setSubject(Subject);
                    lista.setBoard(board);
                    lista.setNoticeHead(noticeHead);
                    lista.setAdditionalInformation(additionalInformation);
                    lista.setStudentWise(studentWise);
                    lista.setClassWise(classWise);
                    lista.setCalendar(date_picker);






                    list.add(lista);


                }


                NoticeCustomAdapter recycler = new NoticeCustomAdapter(list ,admin_notice_data.this);
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(admin_notice_data.this);
                recyclerview.setLayoutManager(layoutmanager);
                recyclerview.setItemAnimator( new DefaultItemAnimator());
                recyclerview.setAdapter(recycler);

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });






    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(admin_notice_data.this, adminDashBoard.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
