
//This is the class where teacher can post the details of attendances and can see the
// details of students attendance.

package com.example.madhav.schoolmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.madhav.schoolmanagement.Model.Students;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class attendanceAdmin extends AppCompatActivity {

    TextView eemail,eaddress;
    Button save,view;
    FirebaseDatabase database;
    DatabaseReference myRef;
    List<Listdata> list;
    RecyclerView recyclerview;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;


    String names[] = {"Select Status","Present","Absent"};
    String names1[] = {"Select Student","Ram Yadav","Madhav Sapkota","Mahima Sapkota","Radha Krishna","Mohan Yadav"};
    String names2[] = {"Select Section","A","B","C","D"};

    ArrayAdapter<String> adapter;
    String record= "";

    ArrayAdapter<String> adapter1;
    String record1= "";

    ArrayAdapter<String> adapter2;
    String record2= "";


    private CheckBox present;



    DatabaseReference Students;
    List<Students> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_admin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        spinner1  = findViewById(R.id.spinner);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        spinner1.setAdapter(adapter);

        spinner2  = findViewById(R.id.spinner1);
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names1);
        spinner2.setAdapter(adapter1);

        spinner3  = findViewById(R.id.spinner2);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names2);
        spinner3.setAdapter(adapter2);


        database = FirebaseDatabase.getInstance();
        Students= database.getReference("Students");




        save = (Button) findViewById(R.id.save);
        view = (Button) findViewById(R.id.view);
        recyclerview = (RecyclerView) findViewById(R.id.rview);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                String spinner = (spinner1.getSelectedItem().toString());
                String email = (spinner2.getSelectedItem().toString());
                String address = (spinner3.getSelectedItem().toString());



                String key = myRef.push().getKey();
                Userdetails userdetails = new Userdetails();

                userdetails.setSpinner(spinner);


                userdetails.setEmail(email);
                userdetails.setAddress(address);

                myRef.child(key).setValue(userdetails);




                spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected (AdapterView <?> parent , View view , int position , long id) {


                        switch (position)

                        {

                            case 0:

                                record = "A";

                                break;

                            case 1:

                                record = "B";

                                break;


                            case 2:

                                record = "C";

                                break;


                            case 3:

                                record = "D";

                                break;





                        }



                    }

                    @Override
                    public void onNothingSelected (AdapterView <?> parent) {

                    }
                });





                spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected (AdapterView <?> parent , View view , int position , long id) {


                        switch (position)

                        {

                            case 0:

                                record = "Present";

                                break;

                            case 1:

                                record = "Absent";

                                break;





                        }



                    }

                    @Override
                    public void onNothingSelected (AdapterView <?> parent) {

                    }
                });


                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected (AdapterView <?> parent , View view , int position , long id) {


                        switch (position)

                        {

                            case 0:

                                record = "Ram Yadav";

                                break;

                            case 1:

                                record = "Madhav Sapkota";

                                break;


                            case 2:

                                record = "Mahima Sapkota";

                                break;

                            case 3:

                                record = "Radha Krishna";

                                break;

                            case 4:

                                record = "Mohan Yadav";

                                break;



                        }



                    }

                    @Override
                    public void onNothingSelected (AdapterView <?> parent) {

                    }
                });







                }
        });




            view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        list = new ArrayList<>();
                        // StringBuffer stringbuffer = new StringBuffer();
                        for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                            Userdetails userdetails = dataSnapshot1.getValue(Userdetails.class);
                            Listdata listdata = new Listdata();
                            String name=userdetails.getSpinner();
                            String email=userdetails.getEmail();
                            String address=userdetails.getAddress();
//                            String  present = userdetails.getPresent();
//                            String absent = userdetails.getAbsent();



                            listdata.setSpinner(name);
                            listdata.setEmail(email);
                            listdata.setAddress(address);
//                            listdata.setAbsent(absent);
//                            listdata.setPresent(present);

                            list.add(listdata);
                            // Toast.makeText(MainActivity.this,""+name,Toast.LENGTH_LONG).show();

                        }

                        RecyclerviewAdapter recycler = new RecyclerviewAdapter(list);
                        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(attendanceAdmin.this);
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
        });


    }

        @Override
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case android.R.id.home:
                    Intent homeIntent = new Intent(attendanceAdmin.this, teacherData.class);
                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(homeIntent);
                    finish();
            }
            return (super.onOptionsItemSelected(menuItem));

        }


}





