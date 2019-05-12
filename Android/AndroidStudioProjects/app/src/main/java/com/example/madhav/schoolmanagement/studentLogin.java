//Login Page for all types of users.
//[Android Studio - Login Page using Firebase Tutorial,Angaa Risky]
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madhav.schoolmanagement.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class studentLogin extends AppCompatActivity {

    //https://www.youtube.com/watch?v=oEKUMW4_2GA --For SignUp
    //https://www.youtube.com/watch?v=JxA5pDVkqWw --For Login



    //Firebase
    FirebaseDatabase database;
    DatabaseReference student;

    private Button loginButton;
    private EditText userText, passwordText;
    private TextView signIn;
    private FirebaseAuth auth;
    private  ProgressDialog mProgress;

    private Spinner user_type ;
    String names[] = {"UserType","admin","teacher","student"};


    //defining array adpater of string type
    ArrayAdapter<String> adapter;
    String record= "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Getting instance of firebaseauth
        database = FirebaseDatabase.getInstance();
        student = database.getReference("LoginStudent");


        loginButton = findViewById(R.id.button1);
        userText = findViewById(R.id.textView2);


        user_type = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        user_type.setAdapter(adapter);


        passwordText = findViewById(R.id.textView3);
        signIn = findViewById(R.id.textView4);

        user_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected (AdapterView <?> parent , View view , int position , long id) {


                switch (position)

                {

                    case 0:

                        record = "admin";

                        break;

                    case 1:

                        record = "teacher";

                        break;

                    case 2:

                        record = "student";

                        break;


                }



            }

            @Override
            public void onNothingSelected (AdapterView <?> parent) {

            }
        });

        //[how to add a progress bar to the login activity while logging in?,Georges Badra]
        mProgress =new ProgressDialog(this);
        String titleId="Logging in...";
        mProgress.setTitle(titleId);
        mProgress.setMessage("Please Wait...");







        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(studentLogin.this,studentSignIn.class);
                startActivity(intent);
                finish();
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String userN = userText.getText().toString();
                if(TextUtils.isEmpty(userN)) {
                    userText.setError("InsertUsername");
                    return;
                }

                String passT = passwordText.getText().toString();
                if(TextUtils.isEmpty(passT)) {
                    passwordText.setError("InsertPassword");
                    return;
                }



                mProgress.show();


                signIn(
                        userText.getText().toString(),
                        passwordText.getText().toString(),




                        user_type.getSelectedItem().toString()

                );



            }
        });
    }
    private void signIn(final String username,final String password,final String user_type){
        student.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(username).exists()){
                    if (!username.isEmpty()){
                        User login = dataSnapshot.child(username).getValue(User.class);

                        if (login.getPassword().equals(password)){

                            switch (user_type){
                                case "teacher":

                                    Intent intent = new Intent(studentLogin.this,teacherDashboard.class);
                                    //TeacherDashBboard
                                    startActivity(intent);
                                    break;

                                case "student":
                                    Intent intent1 = new Intent(studentLogin.this,StudentPanel1.class);
                                    //StudentDashBoard
                                    startActivity(intent1);
                                    break;

                                case "admin":
                                    Intent intent2 = new Intent(studentLogin.this,adminDashBoard.class);
                                    //AdminDashBoard
                                    startActivity(intent2);
                                    break;

                                 default:
                                     Intent intent3 = new Intent(studentLogin.this,StudentPanel1.class);
                                     startActivity(intent3);


                                     }


                            if(login !=null)
                                mProgress.dismiss();





                        }
                        else{

                            Toast.makeText(studentLogin.this,"UnSucessfully",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else {
                    mProgress.dismiss();
                    Toast.makeText(studentLogin.this,"User is not registered",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                mProgress.dismiss();
                Toast.makeText(studentLogin.this,"Database Error",Toast.LENGTH_SHORT).show();

            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(studentLogin.this, MainActivity .class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }




}