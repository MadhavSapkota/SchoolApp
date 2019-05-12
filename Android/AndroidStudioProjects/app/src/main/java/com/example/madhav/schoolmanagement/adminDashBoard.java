//For the adminDashBoard
package com.example.madhav.schoolmanagement;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class adminDashBoard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public Button course,vehicle,student,teacher,notice,communication,examfee;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        course = findViewById(R.id.button8);
        vehicle  = findViewById(R.id.button12);
        student = findViewById(R.id.button15);
        teacher = findViewById(R.id.button13);
        notice = findViewById(R.id.button6);
        communication = findViewById(R.id.button9);
        examfee = findViewById(R.id.button3);




        course.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(adminDashBoard.this,exam_panel_admin.class);
                startActivity(intent);
                finish();




            }

        });


        vehicle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(adminDashBoard.this,vehicleActivity.class);
                startActivity(intent);
                finish();

            }

        });

        student.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(adminDashBoard.this,Student_AdminPanel.class);

                startActivity(intent);
                finish();

            }

        });

        teacher.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(adminDashBoard.this,teacher_admin_panel.class);
                startActivity(intent);
                finish();
            }

        });
        notice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(adminDashBoard.this,notice_admin_panel.class);
                startActivity(intent);
                finish();

            }

        });

        communication.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(adminDashBoard.this,fees_admin.class);
                startActivity(intent);
                finish();

            }

        });








//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View view) {
//                Snackbar.make(view , "Replace with your own action" , Snackbar.LENGTH_LONG)
//                        .setAction("Action" , null).show();
//            }
//        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this , drawer , toolbar , R.string.navigation_drawer_open , R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed ( ) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.admin_dash_board , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            Logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //[Github.2019.epicodus-lessons/restaurants]
    private void Logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(adminDashBoard.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected (MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            //For the StudentData
            Intent intent = new Intent(adminDashBoard.this,adminteacherData.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_gallery) {
            //For the fees
            Intent intent = new Intent(adminDashBoard.this,fee_data_admin.class);

            startActivity(intent);
            finish();



        } else if (id == R.id.nav_slideshow) {
            //For the teacherData
            Intent intent = new Intent(adminDashBoard.this,dataTeacherAdmin.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_manage) {
            //For the exam data
            Intent intent = new Intent(adminDashBoard.this,exam_data_admin.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_share) {
            //For the notice data
            Intent intent = new Intent(adminDashBoard.this,admin_notice_data.class);
            startActivity(intent);
            finish();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}
