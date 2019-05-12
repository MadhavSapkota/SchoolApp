package com.example.madhav.schoolmanagement;
//https://www.mytrendin.com/receive-data-firebase-display-recyclerview-android/
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class studentGrades extends AppCompatActivity {

    TextView ename,eemail,eaddress;
    Button save,view;
    FirebaseDatabase database;
    DatabaseReference myRef;
    List<Listdata> list;
    RecyclerView recyclerview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_grades);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        ename = (TextView) findViewById(R.id.etname);
//        eemail = (TextView) findViewById(R.id.eemail);
        eaddress = (TextView) findViewById(R.id.eaddress);
        save = (Button) findViewById(R.id.save);
        view = (Button) findViewById(R.id.view);
        recyclerview = (RecyclerView) findViewById(R.id.rview);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("grade");
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name =  ename.getText().toString();
//                String email =  eemail.getText().toString();
//                String address =  eaddress.getText().toString();
//
//
//                String key =myRef.push().getKey();
//                Userdetails userdetails = new Userdetails();
//
//                userdetails.setName(name);
//                userdetails.setEmail(email);
//                userdetails.setAddress(address);
//
//                myRef.child(key).setValue(userdetails);
//                ename.setText("");
//                eemail.setText("");
//                eaddress.setText("");
//
//            }
//        });



//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                // StringBuffer stringbuffer = new StringBuffer();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    Userdetails userdetails = dataSnapshot1.getValue(Userdetails.class);
                    Listdata listdata = new Listdata();
                    String name=userdetails.getName();
                    String email=userdetails.getEmail();
                    String address=userdetails.getAddress();
                    listdata.setName(name);
                    listdata.setEmail(email);
                    listdata.setAddress(address);
                    list.add(listdata);
                    // Toast.makeText(MainActivity.this,""+name,Toast.LENGTH_LONG).show();

                }

                RecycleviewAdapterGrade recycler = new RecycleviewAdapterGrade(list);
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(studentGrades.this);
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
//        });


    //    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(studentGrades.this, studentDataStudentPanel.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));

    }
}
