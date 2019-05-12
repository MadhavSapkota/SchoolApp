//This is the teacherPanel for the Homework.
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
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class teacherPanelHomework extends AppCompatActivity {

    TextView ename,eemail,eaddress;
    Button save,view;
    FirebaseDatabase database;
    DatabaseReference myRef;
    List<HomeworkList> list;
    RecyclerView recyclerview;
    private Spinner spinner1;

    String names[] = {"Select Status","English","Nepali","Mathematics","Science"};
    ArrayAdapter<String> adapter;
    String record= "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_panel_homework);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        spinner1  = findViewById(R.id.spinner);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        spinner1.setAdapter(adapter);



        eaddress = (TextView) findViewById(R.id.eaddress);
        save = (Button) findViewById(R.id.save);
        view = (Button) findViewById(R.id.view);
        recyclerview = (RecyclerView) findViewById(R.id.rview);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Homework");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                String name = (spinner1.getSelectedItem().toString());
                String address = eaddress.getText().toString();


                String key = myRef.push().getKey();
                Userdetails userdetails = new Userdetails();


                userdetails.setSpinner(name);
                userdetails.setAddress(address);

                myRef.child(key).setValue(userdetails);


                eaddress.setText("");
                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected (AdapterView <?> parent , View view , int position , long id) {


                        switch (position)

                        {

                            case 0:

                                record = "English";

                                break;

                            case 1:

                                record = "Nepali";

                                break;


                            case 2:

                                record = "Mathematics";

                                break;


                            case 3:

                                record = "Science";

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

                        for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                            Userdetails userdetails = dataSnapshot1.getValue(Userdetails.class);
                            HomeworkList listdata = new HomeworkList();
                            String name=userdetails.getSpinner();
                            String email=userdetails.getEmail();
                            String address=userdetails.getAddress();
                            listdata.setName(name);
                            listdata.setEmail(email);
                            listdata.setAddress(address);

                            list.add(listdata);


                        }

                        HomeworkRecyclerviewAdapter recycler = new HomeworkRecyclerviewAdapter(list);
                        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(teacherPanelHomework.this);
                        recyclerview.setLayoutManager(layoutmanager);
                        recyclerview.setItemAnimator( new DefaultItemAnimator());
                        recyclerview.setAdapter(recycler);

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                });

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(teacherPanelHomework.this, teacherData.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));

    }


}





