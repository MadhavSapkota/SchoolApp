//This is the teacherPage which contains the student grades details.
//Team Mytrendin. 2017. Receive Data from Firebase and display in recyclerview in android. [ONLINE]
// Available at: https://www.mytrendin.com/receive-data-firebase-display-recyclerview-android/. [Accessed 22 February 2019].

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

public class studentGradeTeacher extends AppCompatActivity {
   //This is the textView
    TextView ename,eemail,eaddress;
    //This is the button
    Button save,view;
    FirebaseDatabase database;
    DatabaseReference myRef;
    //List
    List<Listdata> list;
    //RecycleView
    RecyclerView recyclerview;

    private Spinner spinner2;
    String names1[] = {"Select Student","Ram Yadav","Madhav Sapkota","Mahima Sapkota","Radha Krishna","Mohan Yadav"};
    ArrayAdapter<String> adapter1;
    String record1= "";

    private Spinner spinner3;
    String names2[] = {"Select Section","A","B","C","D"};
    ArrayAdapter<String> adapter2;
    String record2= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_grade_teacher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        spinner2  = findViewById(R.id.spinner1);
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names1);
        spinner2.setAdapter(adapter1);


        spinner3  = findViewById(R.id.spinner2);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names2);
        spinner3.setAdapter(adapter2);



        ename = (TextView) findViewById(R.id.etname);
        save = (Button) findViewById(R.id.save);
        view = (Button) findViewById(R.id.view);
        recyclerview = (RecyclerView) findViewById(R.id.rview);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("grade");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                String name = ename.getText().toString();
                String email = (spinner2.getSelectedItem().toString());
                String address = (spinner3.getSelectedItem().toString());


                String key = myRef.push().getKey();
                Userdetails userdetails = new Userdetails();

                userdetails.setName(name);
                userdetails.setEmail(email);
                userdetails.setAddress(address);

                myRef.child(key).setValue(userdetails);
                ename.setText("");


                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected (AdapterView <?> parent , View view , int position , long id) {


                        switch (position)

                        {

                            case 0:

                                record1 = "Ram Yadav";

                                break;

                            case 1:

                                record1 = "Madhav Sapkota";

                                break;


                            case 2:

                                record1 = "Mahima Sapkota";

                                break;

                            case 3:

                                record1 = "Radha Krishna";

                                break;

                            case 4:

                                record1 = "Mohan Yadav";

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

                                record2 = "A";

                                break;

                            case 1:

                                record2 = "B";

                                break;


                            case 2:

                                record2 = "C";

                                break;


                            case 3:

                                record2 = "D";

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
                            String name=userdetails.getName();
                            String email=userdetails.getEmail();
                            String address=userdetails.getAddress();
                            listdata.setName(name);
                            listdata.setEmail(email);
                            listdata.setAddress(address);
                            list.add(listdata);


                        }
                        //Displaying data using the recycleAdapter
                        RecycleviewAdapterGrade recycler = new RecycleviewAdapterGrade(list);
                        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(studentGradeTeacher.this);
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
                Intent homeIntent = new Intent(studentGradeTeacher.this, teacherData.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));

    }


}





