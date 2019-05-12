//package com.example.madhav.schoolmanagement;
////
////public class UserCustomAdapter {
////}
//import java.util.ArrayList;
//import java.util.List;
//
//import com.example.madhav.schoolmanagement.studentLeave;
//import com.google.firebase.database.ValueEventListener;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.TextView;
//
//public class UserCustomAdapter extends ArrayAdapter<studentLeave> {
//    Context context;
//    int layoutResourceId;
//    ArrayList<studentLeave> list = new ArrayList<studentLeave>();
//
//    public UserCustomAdapter(ValueEventListener context, int layoutResourceId,
//                             List <studentLeave> list) {
//        super((Context) context , layoutResourceId, list);
//        this.layoutResourceId = layoutResourceId;
//
//        this.list = (ArrayList <studentLeave>) list;
//    }
//
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        View row = convertView;
//        UserHolder holder = null;
//
//        if (row == null) {
//            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
//            row = inflater.inflate(layoutResourceId, parent, false);
//            holder = new UserHolder();
//
//           holder.student_fullname = (TextView) row.findViewById(R.id.editText26);
//           holder.student_RollNumber = (TextView) row.findViewById(R.id.editText24);
//           holder.studentDivision = (TextView) row.findViewById(R.id.editText22);
//           holder.student_Standard = (TextView) row.findViewById(R.id.editText18);
//           holder.leave_Type = (TextView) row.findViewById(R.id.editText16);
//           holder.from_date = (TextView) row.findViewById(R.id.editText14);
//           holder.to_date = (TextView) row.findViewById(R.id.editText12);
//           holder.message_details = (TextView) row.findViewById(R.id.editText10);
//           holder.submit = (Button) row.findViewById(R.id.button1);
//           holder.textName = (TextView) row.findViewById(R.id.editText26);
//           holder.textAddress = (TextView) row.findViewById(R.id.textView2);
//           holder.textLocation = (TextView) row.findViewById(R.id.textView3);
//
//
//
//
//
//
//
//            row.setTag(holder);
//        } else {
//            holder = (UserHolder) row.getTag();
//        }
//        studentLeave user = list.get(position);
//        holder.student_fullname.setText(user.getStudent_fullname());
//        holder.student_RollNumber.setText(user.getStudent_RollNumber());
//        holder.studentDivision.setText(user.getStudentDivision());
//        holder.student_Standard.setText(user.getStudent_Standard());
//        holder.leave_Type.setText(user.getLeave_Type());
//        holder.from_date.setText(user.getFrom_date());
//        holder.to_date.setText(user.getTo_date());
//        holder.textLocation.setText("");
//
//
//
//
//
//        holder.submit.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                studentLeave user = list.get(position);
//                ((studentLeave) user).setStudent_fullname(user.getStudent_fullname());
//                ((studentLeave) user).setStudent_RollNumber(user.getStudent_RollNumber());
//                ((studentLeave) user).setStudentDivision(user.getStudentDivision());
//                ((studentLeave) user).setStudent_Standard(user.getStudent_Standard());
//                ((studentLeave) user).setLeave_Type(user.getLeave_Type());
//                ((studentLeave) user).setFrom_date(user.getFrom_date());
//                ((studentLeave) user).setTo_date(user.getTo_date());
//                ((studentLeave) user).setMessage_details(user.getMessage_details());
//                Intent intent = new Intent(context, leaveDetails.class);
//                context.startActivity(intent);
//            }
//        });
//        return row;
//
//    }
//
//    static class UserHolder {
//        public TextView student_fullname;
//        public TextView student_RollNumber;
//        public TextView studentDivision;
//        public TextView student_Standard;
//        public TextView leave_Type;
//        public TextView from_date;
//        public TextView to_date;
//        public TextView message_details;
//        TextView textName;
//        TextView textAddress;
//        TextView textLocation;
//        Button submit;
//
//    }
//
//}
//
package com.example.madhav.schoolmanagement;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//https://www.mytrendin.com/receive-data-firebase-display-recyclerview-android/
import com.example.madhav.schoolmanagement.Model.Students;
import com.example.madhav.schoolmanagement.Model.Teacher;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TeacherCustomAdapter<S> extends RecyclerView.Adapter<TeacherCustomAdapter.MyHolder>{
    public Context mContext;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();


    List<Teacher> list;

    public TeacherCustomAdapter ( Context context) {
        mContext = context;
    }

    public void setData(List<Teacher> list) {
        list.clear();
        list.addAll(list);
        notifyDataSetChanged();
    }

    public TeacherCustomAdapter (List <Teacher> list , dataTeacherAdmin dataTeacherAdmin) {
        this.list = list;

    }


    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacherdata1,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(TeacherCustomAdapter.MyHolder holder, final int position) {
        final  Teacher data = list.get(position);

        holder.teacherId.setText(data.getTeacherId());
        holder.teacher_fullname.setText(data.getTeacherFullName());
        holder.teacher_CodeNumber.setText(data.getTeacherCodeNumber());
        holder.Department.setText(data.getDepartment());
        holder.Email.setText(data.getEmail());
        holder.qualificationStandard.setText(data.getQualificationStandard());
        holder.teacherLoginUser.setText(data.getTeacherLoginUsername());
        holder.teacherLoginPassword.setText(data.getTeacherLoginPassword());
        holder.teacherBirthDate.setText(data.getTeacherBirthDate());
        holder.teacherAddress.setText(data.getTeacherAddress());
        holder.teacherPhone.setText(data.getTeacherContact());
        holder.numberOfClass.setText(data.getNumberOfClass());
        holder.teacherBatch.setText(data.getTeacherBatch());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, " " + list.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {

                databaseReference.child("Teacher").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Teacher userTemp = snapshot.getValue(Teacher.class);
                            if (data.getTeacherId().equals(userTemp.getTeacherId())) {
                                databaseReference.child("Teacher").child(snapshot.getKey().toString()).removeValue();
                                list.remove(position);
                                notifyDataSetChanged();


//                                if (listdata.size() == 0)
// {
//                                    MainActivity.textViewEmptyView.setVisibility(View.VISIBLE);
//                                }
                                break;

                            }

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }





        });


        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent homeIntent =  new Intent(view.getContext(), teacher_admin_panel.class);
                view.getContext().startActivity(homeIntent);


//                Intent homeIntent = new Intent(view.getContext(),fees_admin.class);
//                mContext.startActivity(homeIntent);







                //                    mContext.startActivity(new Intent(mContext, fees_admin.class));
//
//                    try {
//                        finalize();
//                    } catch (Throwable throwable) {
//                        throwable.printStackTrace();
//                    }


//                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
//                    final String examId = rootRef.child("Exam").push().getKey();
//                    final String studentName = "Hari";
//
//                    Map <String, Object> map = new HashMap <>();
//                    map.put("subject" , examId);
//                    map.put("message" , studentName);
////                            rootRef.child("Students").child(studentId).updateChildren(map);
//                    rootRef.child("Exam").child(studentName).updateChildren(map);

//                    if(mContext instanceof IMethodCaller){
//                        ((IMethodCaller)mContext).yourDesiredMethod();
//                    }


















//                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                            FirebaseDatabase database;
//                            DatabaseReference users;
//                            database = FirebaseDatabase.getInstance();
//                            users = database.getReference("Students");
//                            String key = users.push().getKey();
//                            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Students").child(key);

//                        }


//                    });


            }
        });


//
//        public TextView student_id;
//        public TextView student_fullname;
//        public TextView student_RollNumber;
//        public TextView student_Division;
//        public TextView studentEnrollmentNumber;
//        public TextView student_Standard;
//        public TextView studentLoginUser;
//        public TextView studentloginPassword;
//        public TextView student_BirthDate;
//        public TextView studentAddress;
//        public TextView studentParentPhone;
//        public TextView student_Semester;
//        public TextView student_batch;




    }

    @Override
    public int getItemCount() {
        return list.size();
    }


   public class MyHolder extends RecyclerView.ViewHolder{
        //        TextView vname , vaddress,vemail,textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8;
        private TextView teacherId,teacher_fullname,teacher_CodeNumber,Department,Email,
                qualificationStandard,teacherLoginUser,teacherLoginPassword,teacherBirthDate,teacherAddress,
                teacherPhone,numberOfClass,teacherBatch;
        Button delete,update,edit;



        public MyHolder(View itemView) {
            super(itemView);
            teacherId = itemView.findViewById(R.id.editText28);
            teacher_fullname =itemView. findViewById(R.id.editText26);
            teacher_CodeNumber = itemView.findViewById(R.id.editText24);
            Department = itemView.findViewById(R.id.editText22);
            Email = itemView.findViewById(R.id.editText20);
            qualificationStandard = itemView.findViewById(R.id.editText18);
            teacherLoginUser = itemView.findViewById(R.id.editText16);
            teacherLoginPassword =itemView. findViewById(R.id.editText14);
            teacherBirthDate = itemView.findViewById(R.id.editText12);
            teacherAddress = itemView.findViewById(R.id.editText10);
            teacherPhone = itemView.findViewById(R.id.editText8);
            numberOfClass =itemView. findViewById(R.id.editText6);
            teacherBatch =itemView. findViewById(R.id.editText4);

            delete = itemView.findViewById(R.id.button7);

            update = itemView.findViewById(R.id.button20);

            edit = itemView.findViewById(R.id.button19);








//
//            update.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick (View view) {
//
//
//                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
//                    final String teacherId = rootRef.child("Teacher").push().getKey();
//                    final String TeacherFullName = "Hari";
//
//                    Map <String, Object> map = new HashMap <>();
//                    map.put("teacherId" , teacherId);
//                    map.put("steacherFullName" , TeacherFullName);
////                            rootRef.child("Students").child(studentId).updateChildren(map);
//                    rootRef.child("Teacher").child(TeacherFullName).updateChildren(map);
//
//
//
//
////                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
////                            FirebaseDatabase database;
////                            DatabaseReference users;
////                            database = FirebaseDatabase.getInstance();
////                            users = database.getReference("Students");
////                            String key = users.push().getKey();
////                            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Students").child(key);
//
////                        }
//
//
////                    });
//
//
//                }
//            });

        }}}

