package com.example.madhav.schoolmanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button; // this was missing earlier
import android.widget.EditText;
import android.widget.Toast;

import com.example.madhav.schoolmanagement.Model.Students;
import com.example.madhav.schoolmanagement.Model.Teacher;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class teacher_admin_panel extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference users1;
    Teacher teacher;

    private Button submit;
    private EditText teacherId,teacher_fullname,teacher_CodeNumber,Department,Email,
            qualificationStandard,teacherLoginUser,teacherLoginPassword,teacherBirthDate,teacherAddress,
            teacherPhone,numberOfClass,teacherBatch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher1_admin_panel);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        teacherId = findViewById(R.id.editText28);
        teacher_fullname = findViewById(R.id.editText26);
        teacher_CodeNumber = findViewById(R.id.editText24);
        Department = findViewById(R.id.editText22);
        Email = findViewById(R.id.editText20);
        qualificationStandard = findViewById(R.id.editText18);
        teacherLoginUser = findViewById(R.id.editText16);
        teacherLoginPassword = findViewById(R.id.editText14);
        teacherBirthDate = findViewById(R.id.editText12);
        teacherAddress = findViewById(R.id.editText10);
        teacherPhone = findViewById(R.id.editText8);
        numberOfClass = findViewById(R.id.editText6);
        teacherBatch = findViewById(R.id.editText4);
        submit = findViewById(R.id.button1);

        //Database connection
        database = FirebaseDatabase.getInstance();
        users1 = database.getReference("Teacher");


        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String userN = teacherId.getText().toString();
                if(TextUtils.isEmpty(userN)) {
                    teacherId.setError("Insert TeacherId");
                    return;
                }

                String fullN = teacher_fullname.getText().toString();
                if(TextUtils.isEmpty(fullN)) {
                    teacher_fullname.setError("Insert TeacherFullName");
                    return;
                }

                String TC = teacher_CodeNumber.getText().toString();
                if(TextUtils.isEmpty(TC)) {
                    teacher_CodeNumber.setError("Insert TeacherCodeNumber");
                    return;
                }

                String Dept = Department.getText().toString();
                if(TextUtils.isEmpty(Dept)) {
                    Department.setError("Insert TeacherId");
                    return;
                }

                String Em = Email.getText().toString();
                if(TextUtils.isEmpty(Em)) {
                    Email.setError("Insert Teacher Email");
                    return;
                }

                String QS = qualificationStandard.getText().toString();
                if(TextUtils.isEmpty(QS)) {
                    qualificationStandard.setError("Insert Teacher Qualification");
                    return;
                }

                String TLU = teacherLoginUser.getText().toString();
                if(TextUtils.isEmpty(TLU)) {
                    teacherLoginUser.setError("Insert TeacherLoginUser");
                    return;
                }

                String TLP = teacherLoginPassword.getText().toString();
                if(TextUtils.isEmpty(TLP)) {
                    teacherLoginPassword.setError("Insert Password");
                    return;
                }

                String TBD = teacherBirthDate.getText().toString();
                if(TextUtils.isEmpty(TBD)) {
                    teacherBirthDate.setError("Insert TeacherBirthdate");
                    return;
                }

                String tAa = teacherAddress.getText().toString();
                if(TextUtils.isEmpty(tAa)) {
                    teacherAddress.setError("Insert TeacherAddress");
                    return;
                }

                String tePh = teacherPhone.getText().toString();
                if(TextUtils.isEmpty(tePh)) {
                    teacherPhone.setError("Insert Teacher Phone");
                    return;
                }
                String nC = numberOfClass.getText().toString();
                if(TextUtils.isEmpty(nC)) {
                    numberOfClass.setError("Insert Class Number");
                    return;
                }

                String teP = teacherPhone.getText().toString();
                if(TextUtils.isEmpty(teP)) {
                    teacherPhone.setError("Insert TeacherPhone");
                    return;
                }
                String tB = teacherBatch.getText().toString();
                if(TextUtils.isEmpty(tB)) {
                    teacherBatch.setError("Insert TeacherBatch");
                    return;
                }



                String id = teacherId.getText().toString() ;
                String fullname = teacher_fullname.getText().toString();
                String  codeNumber = teacher_CodeNumber.getText().toString();
                String department = Department.getText().toString();
                String email = Email.getText().toString();
                String qualification = qualificationStandard.getText().toString();
                String loginUser = teacherLoginUser.getText().toString();
                String loginPassword = teacherLoginPassword.getText().toString();
                String dateofBirth = teacherBirthDate.getText().toString();
                String taddress = teacherAddress.getText().toString();
                String tPhone = teacherPhone.getText().toString();
                String ClassesNumber = numberOfClass.getText().toString();
                String Batch = teacherBatch.getText().toString();


                String key = users1.push().getKey();
                teacher = new Teacher();

                teacher.setTeacherFullName(fullname);
                teacher.setTeacherId(id);
                teacher.setTeacherCodeNumber(codeNumber);
                teacher.setDepartment(department);
                teacher.setEmail(email);
                teacher.setQualificationStandard(qualification);
                teacher.setTeacherLoginUsername(loginUser);
                teacher.setTeacherLoginPassword(loginPassword);
                teacher.setTeacherBirthDate(dateofBirth);
                teacher.setTeacherAddress(taddress);
                teacher.setTeacherContact(tPhone);
                teacher.setNumberOfClass(ClassesNumber);
                teacher.setTeacherBatch(Batch);



                users1.child(key).setValue(teacher);
                teacherId.setText("");
                teacher_fullname.setText("");
                teacher_CodeNumber.setText("");
                Department.setText("");
                Email.setText("");
                qualificationStandard.setText("");
                teacherLoginUser.setText("");
                teacherLoginPassword.setText("");
                teacherBirthDate.setText("");
                teacherAddress.setText("");
                teacherPhone.setText("");
                teacher.setNumberOfClass("");
                teacher.setTeacherBatch("");


                Toast.makeText(teacher_admin_panel.this,"TeacherData Inserted...",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(teacher_admin_panel.this,adminDashBoard.class);
                startActivity(intent);
                finish();








//                teacher.setTeacherId(teacherId.getText().toString());
//                teacher.setTeacherFullName(teacher_fullname.getText().toString());
//                teacher.setTeacherCodeNumber(teacher_CodeNumber.getText().toString());
//                teacher.setDepartment(Department.getText().toString());
//                teacher.setEmail(Email.getText().toString());
//                teacher.setQualificationStandard(qualificationStandard.getText().toString());
//                teacher.setTeacherLoginUsername(teacherLoginUser.getText().toString());
//                teacher.setTeacherLoginPassword(teacherLoginPassword.getText().toString());
//                teacher.setTeacherBirthDate(teacherBirthDate.getText().toString());
//                teacher.setTeacherAddress(teacherAddress.getText().toString());
//                teacher.setTeacherContact(teacherPhone.getText().toString());
//                teacher.setNumberOfClass(numberOfClass.getText().toString());
//                teacher.setTeacherBatch(teacherBatch.getText().toString());


            }
        });

    }

//    private void getValues(){
//    teacher.setTeacherId(teacherId.getText().toString());
//    teacher.setTeacherFullName(teacher_fullname.getText().toString());
//    teacher.setTeacherCodeNumber(teacher_CodeNumber.getText().toString());
//    teacher.setDepartment(Department.getText().toString());
//    teacher.setEmail(Email.getText().toString());
//    teacher.setQualificationStandard(qualificationStandard.getText().toString());
//    teacher.setTeacherLoginUsername(teacherLoginUser.getText().toString());
//    teacher.setTeacherLoginPassword(teacherLoginPassword.getText().toString());
//    teacher.setTeacherBirthDate(teacherBirthDate.getText().toString());
//    teacher.setTeacherAddress(teacherAddress.getText().toString());
//    teacher.setTeacherContact(teacherPhone.getText().toString());
//    teacher.setNumberOfClass(numberOfClass.getText().toString());
//    teacher.setTeacherBatch(teacherBatch.getText().toString());
//
//
//    }



//      public void btnInsert ( ){
//        users1.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange (@NonNull DataSnapshot dataSnapshot) {
//                getValues();
//                users1.child("Admin").setValue(teacher);
//                //Toast.makeText(teacher_admin_panel.this , "Data Inserted...",Toast.LENGTH_SHORT.show());
//                Toast.makeText(teacher_admin_panel.this,"Database Inserted...",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(teacher_admin_panel.this,adminDashBoard.class);
//                startActivity(intent);
//                finish();
//
//            }
//
//            @Override
//            public void onCancelled (@NonNull DatabaseError databaseError) {
//                Toast.makeText(teacher_admin_panel.this,"Database Error",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//      }

//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              final Students stu = new Students( studentId.getText().toString(),
//                                      student_fullname.getText().toString(),
//                                      student_RollNumber.getText().toString(),
//                                      studentDivision.getText().toString(),
//                                      studentEnrollNumber.getText().toString(),
//                                      student_Standard.getText().toString(),
//                                      student_LoginUser.getText().toString(),
//                                      student_LoginPassword.getText().toString(),
//                                      student_BirthDate.getText().toString(),
//                                      student_Address.getText().toString(),
//                                      student_ParentPhone.getText().toString(),
//                                      student_Semester.getText().toString(),
//                                      student_batch.getText().toString());
//
//              users1.addListenerForSingleValueEvent(new ValueEventListener() {
//                  @Override
//                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                      if (dataSnapshot.child(stu.getStudentName()).exists())
//                          Toast.makeText(teacher_admin_panel.this , "Please Enter the form." , Toast.LENGTH_SHORT).show();
//
//                      else {
//                          users1.child(stu.getStudentName()).setValue(stu);
//                          Toast.makeText(teacher_admin_panel.this , "Sucess Registered" , Toast.LENGTH_SHORT).show();
//                          Intent intent = new Intent(teacher_admin_panel.this , LoginPage.class);
//                      }
//                  }
//                    @Override
//                     public void onCancelled(@NonNull DatabaseError databaseError) {
//                              Toast.makeText(teacher_admin_panel.this, "Database Error", Toast.LENGTH_SHORT).show();
//
//                  }
//
//
//        });
//
//         }
//            });







//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            // Respond to the action bar's Up/Home button
//            case android.R.id.home:
//                Intent upIntent = NavUtils.getParentActivityIntent(this);
//                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
//                    // This activity is NOT part of this app's task, so create a new task
//                    // when navigating up, with a synthesized back stack.
//                    TaskStackBuilder.create(this)
//                            // Add all of this activity's parents to the back stack
//                            .addNextIntentWithParentStack(upIntent)
//                            // Navigate up to the closest parent
//                            .startActivities();
//                } else {
//                    // This activity is part of this app's task, so simply
//                    // navigate up to the logical parent activity.
//                    NavUtils.navigateUpTo(this, upIntent);
//                }
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }



//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(teacher_admin_panel.this, adminDashBoard.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
 //https://stackoverflow.com/questions/16150205/android-action-bar-home-button


      }






