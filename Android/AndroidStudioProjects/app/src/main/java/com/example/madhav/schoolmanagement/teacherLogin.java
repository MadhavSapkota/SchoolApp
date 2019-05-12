package com.example.madhav.schoolmanagement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madhav.schoolmanagement.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class teacherLogin extends AppCompatActivity {

    //https://www.youtube.com/watch?v=oEKUMW4_2GA --For SignUp
    //https://www.youtube.com/watch?v=JxA5pDVkqWw --For Login



    //Firebase
    FirebaseDatabase database;
    DatabaseReference TeacherLogin;

    private Button loginButton;
    private EditText userText, passwordText;
    private TextView signIn;
    private FirebaseAuth auth;
    private ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Getting the instance of firebaseauth
        database = FirebaseDatabase.getInstance();
        TeacherLogin = database.getReference("LoginTeacher");


        loginButton = findViewById(R.id.button1);
        userText = findViewById(R.id.textView2);
        passwordText = findViewById(R.id.textView3);
        signIn = findViewById(R.id.textView4);


//        https://stackoverflow.com/questions/27551292/how-to-add-a-progress-bar-to-the-login-activity-while-logging-in

        mProgress =new ProgressDialog(this);
        String titleId="Logging in...";
        mProgress.setTitle(titleId);
        mProgress.setMessage("Please Wait...");

        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                 Intent intent = new Intent(LoginPage.this,SignInActivity.class);
//                 startActivity(intent);
//                 finish();

                Intent intent = new Intent(teacherLogin.this,teacherSignIn.class);
                startActivity(intent);
                finish();
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mProgress.show();
                signIn(userText.getText().toString(),
                        passwordText.getText().toString());

            }
        });
    }
    private void signIn(final String username,final String password){
        TeacherLogin.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(username).exists()){
                    if (!username.isEmpty()){
                        User login = dataSnapshot.child(username).getValue(User.class);
                        if (login.getPassword().equals(password)){

                            if(login !=null)
                                mProgress.dismiss();
                            // Toast.makeText(LoginPage.this,"Sucessfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(teacherLogin.this,teacherDashboard.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            mProgress.dismiss();
                            Toast.makeText(teacherLogin.this,"UnSucessfully",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else {
                    mProgress.dismiss();
                    Toast.makeText(teacherLogin.this,"User is not registered",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                mProgress.dismiss();
                Toast.makeText(teacherLogin.this,"Database Error",Toast.LENGTH_SHORT).show();

            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(teacherLogin.this, MainActivity .class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }







//        b1.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                String email = t1.getText().toString();
//                final String password = t2.getText().toString();
//
//                if (TextUtils.isEmpty(email)) {
//                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                if (TextUtils.isEmpty(password)) {
//                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                progressBar.setVisibility(View.VISIBLE);
//
//                //authenticate user
//                auth.signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                // If sign in fails, display a message to the user. If sign in succeeds
//                                // the auth state listener will be notified and logic to handle the
//                                // signed in user can be handled in the listener.
//                                progressBar.setVisibility(View.GONE);
//                                if (!task.isSuccessful()) {
//                                    // there was an error
//                                    if (password.length() < 6) {
//                                        t1.setError(getString(R.string.minimum_password));
//                                    } else {
//                                        Toast.makeText(LoginPage.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
//                                    }
//                                } else {
//                                    Intent intent = new Intent(LoginPage.this, DashBoardActivity.class);
//                                    startActivity(intent);
//                                    finish();
//                                }

/*
                String email = t1.getText().toString().trim();
                final String password = t2.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        t2.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(LoginPage.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(LoginPage.this, DashBoardActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
*/


//                if (t1.getText().toString().equals("admin") &&
//                 t2.getText().toString().equals("admin")) {
//
//                Intent intent = new Intent(LoginPage.this,DashBoardActivity.class);
//                // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//                 finish();
//
//                //Toast.makeText(LoginPage.this, "Yes", Toast.LENGTH_SHORT).show();
//
//
//                 } else {
//                   Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
//
//                }
//
//
    //    }});
//
//




}