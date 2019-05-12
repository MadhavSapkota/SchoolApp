package com.example.madhav.schoolmanagement;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madhav.schoolmanagement.Model.Notice;
import com.example.madhav.schoolmanagement.Model.Students;
import com.example.madhav.schoolmanagement.Model.Teacher;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class notice_admin_panel extends AppCompatActivity {
    //http://www.codersinc.in/2017/05/android-example-2-use-spinner-to-select.html

    //Defining Spinner
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


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_admin_panel);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Getting values from the xml files
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner2);
        Subject = findViewById(R.id.editText7);
        board = findViewById(R.id.editText5);
        noticeHead = findViewById(R.id.editText);
        AdditionalInformation = findViewById(R.id.editText18);
        studentWise = findViewById(R.id.checkBox2);
        classWise = findViewById(R.id.checkBox);
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        submit = findViewById(R.id.button1);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name1);
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter1);



        //Database Connection
        //Database connection
       database = FirebaseDatabase.getInstance();
        users = database.getReference("Notice");



        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String Sub = Subject.getText().toString();
                if(TextUtils.isEmpty(Sub)) {
                    Subject.setError("Insert SubjectName");
                    return;
                }

                String stBd = board.getText().toString();
                if(TextUtils.isEmpty(stBd)) {
                    board.setError("Insert BoardName");
                    return;
                }

                String ntH = noticeHead.getText().toString();
                if(TextUtils.isEmpty(ntH)) {
                    noticeHead.setError("Insert NoticeHead");
                    return;
                }

                String aIf = AdditionalInformation.getText().toString();
                if(TextUtils.isEmpty(aIf)) {
                    AdditionalInformation.setError("Insert AdditionalInformation");
                    return;
                }


                String spinnera = (spinner.getSelectedItem().toString());
                String spinnerb =(spinner1.getSelectedItem().toString());
                String subject = (Subject.getText().toString());
                String board1 =  (board.getText().toString());
                String NoticeHead = (noticeHead.getText().toString());
                String AdditionalInformation1 = (AdditionalInformation.getText().toString());
                String StudentWise = (studentWise.getText().toString());
                String ClassWise = (classWise.getText().toString());

                String key = users.push().getKey();
                notice = new Notice();



                notice.setSpinner(spinnera);
                notice.setSpinner(spinnerb);
                notice.setSubject(subject);
                notice.setBoard(board1);
                notice.setNoticeHead(NoticeHead);
                notice.setAdditionalInformation(AdditionalInformation1);
                notice.setStudentWise(StudentWise);
                notice.setClassWise(ClassWise);

                // https://stackoverflow.com/questions/22461258/how-to-get-date-from-calendarview-oncreate-with-a-specific-format-e-g-dd-mm
                //Setting the value of calendar
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                notice.setCalendar(sdf.format(new Date(datePicker.getMonth())));


                users.child(key).setValue(notice);
                Subject.setText("");
                noticeHead.setText("");
                board.setText("");
                AdditionalInformation.setText("");
                studentWise.setText("");
                classWise.setText("");
                datePicker.setMaxDate(2019);


                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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


                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override

                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        //use postion value

                        switch (position)

                        {

                            case 0:

                                record = "1";

                                break;

                            case 1:

                                record = "2";

                                break;

                            case 2:

                                record = "3";

                                break;

                            case 3:

                                record = "4";

                                break;

                            case 4:

                                record = "5";

                                break;

                            case 5:

                                record = "6";

                                break;

                            case 6:

                                record = "7";

                                break;

                            case 7:

                                record = "8";

                                break;

                            case 8:

                                record = "9";

                                break;

                            case 9:

                                record = "10";

                                break;


                        }

                    }

                    @Override

                    public void onNothingSelected(AdapterView<?> parent) {

                    }

                });
//                if(studentWise.isChecked()) {
//                    users.child("1").setValue("studentWise");
//                }
//
//                if(classWise.isChecked()) {
//                    users.child("2").setValue("classWise");
//                }


                Toast.makeText(notice_admin_panel.this,"Database Inserted...",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(notice_admin_panel.this,adminDashBoard.class);
                startActivity(intent);
                finish();







            }
        });







//        spinner = (Spinner)findViewById(R.id.spinner2);
//        spinner1 =(Spinner)findViewById(R.id.spinner);





        //set spinner method


    }

//    private void getValues(){
//        notice.setSpinner(spinner.getSelectedItem().toString());
//        notice.setSpinner1(spinner1.getSelectedItem().toString());
//        notice.setSubject(Subject.getText().toString());
//        notice.setBoard(board.getText().toString());
//        notice.setNoticeHead(noticeHead.getText().toString());
//        notice.setAdditionalInformation(AdditionalInformation.getText().toString());
//        notice.setStudentWise(studentWise.getText().toString());
//        notice.setClassWise(classWise.getText().toString());
//       // notice.setCalendar(datePicker.getMonth()));
//
//
//
//       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        notice.setCalendar(sdf.format(new Date(datePicker.getMonth())));
//
//
//
//
//
//    }




//
//    public void btnInsert ( ){
//        users.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange (@NonNull DataSnapshot dataSnapshot) {
//
//                if(studentWise.isChecked()) {
//                    users.child("1").setValue("studentWise");
//                }
//
//                if(classWise.isChecked()) {
//                    users.child("2").setValue("classWise");
//                }
//
//
//                users.child("Admin").setValue(notice);
//                //Toast.makeText(teacher_admin_panel.this , "Data Inserted...",Toast.LENGTH_SHORT.show());
//                Toast.makeText(notice_admin_panel.this,"Database Inserted...",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(notice_admin_panel.this,adminDashBoard.class);
//                startActivity(intent);
//                finish();
//
//            }
//
//            @Override
//            public void onCancelled (@NonNull DatabaseError databaseError) {
//                Toast.makeText(notice_admin_panel.this,"Database Error",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }






    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(notice_admin_panel.this, adminDashBoard.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
