package com.example.madhav.schoolmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.model.Dash;
import com.google.firebase.auth.FirebaseAuth;

public class DashBoardActivity extends AppCompatActivity {

    public Button course,vehicle,student,teacher,virtual_class,communication,examfee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);



        course = findViewById(R.id.button8);
        vehicle  = findViewById(R.id.button12);
        student = findViewById(R.id.button15);
        teacher = findViewById(R.id.button13);
        virtual_class = findViewById(R.id.button6);
        communication = findViewById(R.id.button9);
        examfee = findViewById(R.id.button3);




        course.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashBoardActivity.this,exam_panel_admin.class);
                // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();




            }

        });


        vehicle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashBoardActivity.this,MapsActivity_admin.class);
                // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

            }

        });

        student.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(DashBoardActivity.this,Student_AdminPanel.class);
                // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

            }

        });

        teacher.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               /*Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(DashBoardActivity.this,teacher_admin_panel.class);
                // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }

        });
        virtual_class.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashBoardActivity.this,notice_admin_panel.class);
                // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

            }

        });

        communication.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardActivity.this,fees_admin.class);
                // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

            }

        });

        examfee.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashBoardActivity.this,exam_panel_admin.class);
                // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();


            }

        });


    }

    //https://www.learnhowtoprogram.com/android/data-persistence/logging-out-and-overflow-menus
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            signout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void signout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(DashBoardActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


}
