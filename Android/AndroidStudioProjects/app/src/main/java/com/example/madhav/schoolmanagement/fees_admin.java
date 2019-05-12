package com.example.madhav.schoolmanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.madhav.schoolmanagement.Model.Exam;
import com.example.madhav.schoolmanagement.Model.Fees;
import com.example.madhav.schoolmanagement.Model.Notice;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class fees_admin extends AppCompatActivity {

    private EditText studentName,pathway,standard,totalFee,paidFee,remainingFee,message;
    private DatePicker datePicker;
    private Button submit;
    FirebaseDatabase database;
    DatabaseReference admin;
    Fees fee;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_admin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        studentName = findViewById(R.id.editText9);
        pathway = findViewById(R.id.editText7);
        standard = findViewById(R.id.editText5);
        totalFee = findViewById(R.id.editText11);
        paidFee = findViewById(R.id.editText13);
        remainingFee = findViewById(R.id.editText15);
        message = findViewById(R.id.editText18);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        submit = findViewById(R.id.button1);


        database = FirebaseDatabase.getInstance();
        admin = database.getReference("Fees");
        fee = new Fees();


        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {

                String stNa = studentName.getText().toString();
                if(TextUtils.isEmpty(stNa)) {
                    studentName.setError("Insert Student Name");
                    return;
                }

                String stPt = pathway.getText().toString();
                if(TextUtils.isEmpty(stPt)) {
                    pathway.setError("InsertPathway");
                    return;
                }

                String stD = standard.getText().toString();
                if(TextUtils.isEmpty(stD)) {
                    standard.setError("Insert Student Standard");
                    return;
                }

                String tF = totalFee.getText().toString();
                if(TextUtils.isEmpty(tF)) {
                    totalFee.setError("Insert Total Fee");
                    return;
                }

                String pFe = paidFee.getText().toString();
                if(TextUtils.isEmpty(pFe)) {
                    paidFee.setError("Insert Paid Fee");
                    return;
                }

                String rFee = remainingFee.getText().toString();
                if(TextUtils.isEmpty(rFee)) {
                    remainingFee.setError("Insert Remaining Fee");
                    return;
                }

                String Ms = message.getText().toString();
                if(TextUtils.isEmpty(Ms)) {
                    message.setError("Insert Message");
                    return;
                }


//                btnInsert();
                String studentName1 = studentName.getText().toString();
                String pathway1 = pathway.getText().toString();
                String standard1 = standard.getText().toString();
                String totalFee1 = totalFee.getText().toString();
                String paidFee1 = paidFee.getText().toString();
                String remainingFee1 = remainingFee.getText().toString();
                String message1 = message.getText().toString();

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String datePicker1 = sdf.format(new Date(datePicker.getMonth()));

                String key = admin.push().getKey();
//                exam = new Exam();
                fee = new Fees();

                fee.setStudentName(studentName1);
                fee.setPathway(pathway1);
                fee.setStandard(standard1);
                fee.setTotalFee(totalFee1);
                fee.setPaidFee(paidFee1);
                fee.setRemainingFee(remainingFee1);
                fee.setMessage(message1);

                admin.child(key).setValue(fee);
                studentName.setText("");
                pathway.setText("");
                standard.setText("");
                totalFee.setText("");
                paidFee.setText("");
                remainingFee.setText("");
                message.setText("");
                datePicker.setMaxDate(2019);


                Toast.makeText(fees_admin.this,"Database Inserted...",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(fees_admin.this,adminDashBoard.class);
                startActivity(intent);
                finish();






            }
        });

    }



//        private void getValues(){
//            fee.setStudentName(studentName.getText().toString());
//            fee.setPathway(pathway.getText().toString());
//            fee.setStandard(standard.getText().toString());
//            fee.setTotalFee(totalFee.getText().toString());
//            fee.setPaidFee(paidFee.getText().toString());
//            fee.setRemainingFee(remainingFee.getText().toString());
//            fee.setMessage(message.getText().toString());
//
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            fee.setDatePicker(sdf.format(new Date(datePicker.getMonth())));
//    }
//
//    public void btnInsert(){
//        admin.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange (@NonNull DataSnapshot dataSnapshot) {
//                getValues();
//                admin.child("Admin").setValue(fee);
//                //Toast.makeText(teacher_admin_panel.this , "Data Inserted...",Toast.LENGTH_SHORT.show());
//                Toast.makeText(fees_admin.this,"Database Inserted...",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(fees_admin.this,adminDashBoard.class);
//                startActivity(intent);
//                finish();
//            }
//
//            @Override
//            public void onCancelled (@NonNull DatabaseError databaseError) {
//                Toast.makeText(fees_admin.this,"Database Error",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }






    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(fees_admin.this, adminDashBoard.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
