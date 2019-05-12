package com.example.madhav.schoolmanagement;
//https://www.mytrendin.com/receive-data-firebase-display-recyclerview-android/
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.madhav.schoolmanagement.Model.Students;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//import com.example.jdagnogo.soccerleagueviewlib.SoccerLeagueView;
//import com.example.jdagnogo.soccerleagueviewlib.models.Match;
//import com.example.jdagnogo.soccerleagueviewlib.models.Team;

import java.util.ArrayList;
import java.util.List;

public class adminteacherData extends AppCompatActivity {

    TextView ename,eemail,eaddress;
    public TextView student_id;
    public TextView student_fullname;
    public TextView student_RollNumber;
    public TextView student_Division;
    public TextView studentEnrollmentNumber;
    public TextView student_Standard;
    public TextView studentLoginUser;
    public TextView studentloginPassword;
    public TextView student_BirthDate;
    public TextView studentAddress;
    public TextView studentParentPhone;
    public TextView student_Semester;
    public TextView student_batch;
    Button delete;


    Button save,view;
    FirebaseDatabase database;
    DatabaseReference Students;
    List<Students> list;

    RecyclerView recyclerview;
//    TableLayout table;
//    TableRow tr;
//    TextView prefixTv,maskTv,hostTv;

//    private static final String[] header = {  "Student_id", "student_fullname", "RollNumber", "Division" ,
//            "EnrollNumber", "Standard", "loginUsername", "Password","Date of birth","address","Phone","Semester","Batch"  };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminteacher_data);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


//        SoccerLeagueView soccerLeagueView = (SoccerLeagueView) findViewById(R.id.soccer);


//       final TableView<String[]> tableView = (TableView<String[]>) findViewById(R.id.tableView);
//
//////        SET PROP
//       tableView.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));
//       tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,header));
//        tableView.setColumnCount(13);






        student_id = (TextView) findViewById(R.id.editText28);
        student_fullname = (TextView) findViewById(R.id.editText26);
        student_RollNumber = (TextView) findViewById(R.id.editText24);
        studentEnrollmentNumber = (TextView)findViewById(R.id.editText20);

        student_Division = (TextView)findViewById(R.id.editText22);
        student_Standard = (TextView)findViewById(R.id.editText18);
        studentLoginUser = (TextView) findViewById(R.id.editText16);
        studentloginPassword = (TextView) findViewById(R.id.editText14);
        student_BirthDate = (TextView) findViewById(R.id.editText12);
        studentAddress = (TextView)findViewById(R.id.editText10);
        studentParentPhone = (TextView) findViewById(R.id.editText8);
        student_Semester = (TextView) findViewById(R.id.editText6);
        student_batch = (TextView) findViewById(R.id.editText4);

        delete = (Button) findViewById(R.id.button7);








        save = (Button) findViewById(R.id.save);
        view = (Button) findViewById(R.id.view);
        recyclerview = (RecyclerView) findViewById(R.id.rview);


        //Database Connection
        database = FirebaseDatabase.getInstance();
        Students= database.getReference("Students");







        Students.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<>();

                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    Students userdetails = dataSnapshot1.getValue(Students.class);
                    Students listdata = new Students();
                    String student_id =userdetails.getStudentId();
                    String student_fullname =userdetails.getStudentName();
                    String student_RollNumber =userdetails.getRollNumber();
                    String studentEnrollmentNumber =userdetails.getEnrollNumber();
                    String student_Division=userdetails.getDivision();
                    String student_Standard =userdetails.getStandard();
                    String studentLoginUser =userdetails.getLoginUser();
                    String studentloginPassword =userdetails.getLoginPassword();
                    String student_BirthDate =userdetails.getBirthDate();
                    String  studentAddress =userdetails.getAddress();
                    String studentParentPhone =userdetails.getParentPhone();
                    String student_batch =userdetails.getBatch();




                    listdata.setStudentId(student_id);
                    listdata.setStudentName(student_fullname);
                    listdata.setRollNumber(student_RollNumber);
                    listdata.setEnrollNumber(studentEnrollmentNumber);
                    listdata.setDivision(student_Division);
                    listdata.setStandard(student_Standard);
                    listdata.setLoginUser(studentLoginUser);
                    listdata.setLoginPassword(studentloginPassword);
                    listdata.setBirthDate(student_BirthDate);
                    listdata.setAddress(studentAddress);
                    listdata.setParentPhone(studentParentPhone);
                    listdata.setBatch(student_batch);
                    list.add(listdata);


                }

//               for(int j=0;j<list.size();j++){
//                  UserCustomAdapter clubAdapter = new UserCustomAdapter(list,adminteacherData.this );
//                  }



//                Displaying values in the ListView
                UserCustomAdapter recycler = new UserCustomAdapter(list , adminteacherData.this);
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(adminteacherData.this);
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
//    public void addHeaders(){
//
//        /** Create a TableRow dynamically **/
//        tr = new TableRow(this);
//        tr.setLayoutParams(new TableLayout.LayoutParams(
//                TableLayout.LayoutParams.MATCH_PARENT,
//                TableLayout.LayoutParams.WRAP_CONTENT));
//
//        /** Prefix Heading **/
//        TextView prefixHead = new TextView(this);
//        prefixHead.setText("Class");
//        prefixHead.setTextSize(18);
//        prefixHead.setTextColor(getResources().getColor(android.R.color.darker_gray));
//        prefixHead.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        prefixHead.setPadding(5, 5, 5, 0);
//        tr.addView(prefixHead);  // Adding textView to tablerow.
//
//        /** Mask Heading **/
//        TextView maskHead = new TextView(this);
//        maskHead.setText("StudentName");
//        maskHead.setTextSize(18);
//        maskHead.setTextColor(getResources().getColor(android.R.color.holo_green_light));
//        maskHead.setPadding(5, 5, 5, 0);
//        maskHead.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        tr.addView(maskHead); // Adding textView to tablerow.
//
//        /** Creating another textview **/
//        TextView hostHead = new TextView(this);
//        hostHead.setText("Leave Details");
//        hostHead.setTextSize(18);
//        hostHead.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
//        hostHead.setPadding(5, 5, 5, 0);
//        hostHead.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        tr.addView(hostHead); // Adding textView to tablerow.
//
//
//        // Add the TableRow to the TableLayout
//        table.addView(tr, new TableLayout.LayoutParams(
//                TableLayout.LayoutParams.MATCH_PARENT,
//                TableLayout.LayoutParams.WRAP_CONTENT));
//
//        // we are adding two textviews for the divider because we have two columns
//        tr = new TableRow(this);
//        tr.setLayoutParams(new TableLayout.LayoutParams(
//                TableLayout.LayoutParams.MATCH_PARENT,
//                TableLayout.LayoutParams.WRAP_CONTENT));
//
//        /** Divider Color **/
//        TextView divider = new TextView(this);
//        divider.setText("********");
//        divider.setTextColor(getResources().getColor(android.R.color.darker_gray));
//        divider.setPadding(5, 0, 0, 0);
//        divider.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        tr.addView(divider); // Adding textView to tablerow.
//
//        TextView divider2 = new TextView(this);
//        divider2.setText("*****************");
//        divider2.setTextColor(getResources().getColor(android.R.color.holo_green_light));
//        divider2.setPadding(5, 0, 0, 0);
//        divider2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        tr.addView(divider2); // Adding textView to tablerow.
//
//        TextView divider3 = new TextView(this);
//        divider3.setText("***************");
//        divider3.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
//        divider3.setPadding(5, 0, 0, 0);
//        divider3.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        tr.addView(divider3); // Adding textView to tablerow.
//
//        // Add the TableRow to the TableLayout
//        table.addView(tr, new TableLayout.LayoutParams(
//                TableLayout.LayoutParams.MATCH_PARENT,
//                TableLayout.LayoutParams.WRAP_CONTENT));
//    }
//        });

//    public void addData(){
//
//        for (int i = 0; i < list.size(); i++)
//        {
//            /** Create a TableRow dynamically **/
//            tr = new TableRow(this);
//            tr.setLayoutParams(new TableLayout.LayoutParams(
//                    TableLayout.LayoutParams.MATCH_PARENT,
//                    TableLayout.LayoutParams.WRAP_CONTENT));
//
//            /** Prefix Value **/
//            prefixTv = new TextView(this);
//            prefixTv.setText((CharSequence) list.get(i));
//            prefixTv.setTextSize(16);
//            prefixTv.setTextColor(getResources().getColor(android.R.color.darker_gray));
//            prefixTv.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//            prefixTv.setPadding(5, 5, 5, 5);
//            tr.addView(prefixTv);  // Adding textView to tablerow.
//
//            /** Mask Value**/
//            maskTv = new TextView(this);
//            maskTv.setText(mask[i]);
//            maskTv.setTextSize(16);
//            maskTv.setTextColor(getResources().getColor(android.R.color.holo_green_light));
//            maskTv.setPadding(5, 5, 5, 5);
//            maskTv.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//            tr.addView(maskTv); // Adding textView to tablerow.
//
//            /** Host Value**/
//            hostTv = new TextView(this);
//            hostTv.setText(host[i]);
//            hostTv.setTextSize(16);
//            hostTv.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
//            hostTv.setPadding(5, 5, 5, 5);
//            hostTv.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//            tr.addView(hostTv); // Adding textView to tablerow.
//
//
//            // Add the TableRow to the TableLayout
//            table.addView(tr, new TableLayout.LayoutParams(
//                    TableLayout.LayoutParams.MATCH_PARENT,
//                    TableLayout.LayoutParams.WRAP_CONTENT));
//        }
//    }
//


    //    //    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(adminteacherData.this, adminDashBoard.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));

    }
}
