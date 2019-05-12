
package com.example.madhav.schoolmanagement;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
//https://www.mytrendin.com/receive-data-firebase-display-recyclerview-android/
import com.example.madhav.schoolmanagement.Model.Notice;
import com.example.madhav.schoolmanagement.Model.Students;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class studentNoticeCustomAdapter<S> extends RecyclerView.Adapter<studentNoticeCustomAdapter.MyHolder>{
    public Context mContext;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    List<Notice> listdata;

    public studentNoticeCustomAdapter (Context context) {
        mContext = context;
    }

    public void setData(List<Notice> listdata) {
        listdata.clear();
        listdata.addAll(listdata);
        notifyDataSetChanged();
    }

    public studentNoticeCustomAdapter (List <Notice> listdata , studentDisplayNoticeData studentDisplayNoticeData) {
        this.listdata = listdata;

    }


    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_view_notice_data,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(studentNoticeCustomAdapter.MyHolder holder, final int position) {
        final  Notice data = listdata.get(position);


//
//        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            private String record;
//
//            @Override
//            public void onItemSelected (AdapterView <?> parent , View view , int position , long id) {
//
//
//                switch (position)
//
//                {
//
//                    case 0:
//
//                        record = "A";
//
//                        break;
//
//                    case 1:
//
//                        record = "B";
//
//                        break;
//
//                    case 2:
//
//                        record = "C";
//
//                        break;
//
//                    case 3:
//
//                        record = "D";
//
//                        break;
//
//                }
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected (AdapterView <?> parent) {
//
//            }
//        });


//
//
//        holder.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            private String record;
//
//            @Override
//
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                //use postion value
//
//                switch (position)
//
//                {
//
//                    case 0:
//
//                        record = "1";
//
//                        break;
//
//                    case 1:
//
//                        record = "2";
//
//                        break;
//
//                    case 2:
//
//                        record = "3";
//
//                        break;
//
//                    case 3:
//
//                        record = "4";
//
//                        break;
//
//                    case 4:
//
//                        record = "5";
//
//                        break;
//
//                    case 5:
//
//                        record = "6";
//
//                        break;
//
//                    case 6:
//
//                        record = "7";
//
//                        break;
//
//                    case 7:
//
//                        record = "8";
//
//                        break;
//
//                    case 8:
//
//                        record = "9";
//
//                        break;
//
//                    case 9:
//
//                        record = "10";
//
//                        break;
//
//
//                }
//
//            }
//
//            @Override
//
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//
//        });



        holder.Subject.setText(data.getSubject());
        holder.board.setText(data.getBoard());
        holder.noticeHead.setText(data.getNoticeHead());
        holder.AdditionalInformation.setText(data.getAdditionalInformation());
        holder.studentWise.setText(data.getStudentWise());
        holder.classWise.setText(data.getClassWise());
        holder.datePicker.setText(data.getCalendar());
//        setMaxDate(2019);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, " " + listdata.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });


//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View view) {
//
//                databaseReference.child("Notice").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                            Students userTemp = snapshot.getValue(Students.class);
//                            if (data.getNoticeHead().equals(userTemp.getStudentId())) {
//                                databaseReference.child("Notice").child(snapshot.getKey().toString()).removeValue();
//                                listdata.remove(position);
//                                notifyDataSetChanged();
//
//
////                                if (listdata.size() == 0)
//// {
////                                    MainActivity.textViewEmptyView.setVisibility(View.VISIBLE);
////                                }
//                                break;
//
//                            }
//
//                        }
//
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
//
//            }
//
//
//
//
//
//        });
//


//        holder.update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View view) {
//                Intent homeIntent =  new Intent(view.getContext(), admin_notice_data.class);
//                view.getContext().startActivity(homeIntent);


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


//            }
//        });




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
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        //        TextView vname , vaddress,vemail,textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8;
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

        private TextView spinner ;
        private TextView spinner1;
        private TextView Subject,board ,noticeHead,AdditionalInformation;
        private TextView datePicker;
        private TextView studentWise,classWise;


//        Button delete,update,edit;



        public MyHolder(View itemView) {
            super(itemView);
            spinner = itemView.findViewById(R.id.editText28);
            spinner1 = itemView.findViewById(R.id.editText26);
            Subject = itemView.findViewById(R.id.editText24);
            board = itemView.findViewById(R.id.editText20);

            noticeHead = itemView.findViewById(R.id.editText22);
            AdditionalInformation = itemView.findViewById(R.id.editText18);
            studentWise= itemView.findViewById(R.id.editText16);
            classWise = itemView.findViewById(R.id.editText14);
            datePicker = itemView.findViewById(R.id.editText12);
//            studentAddress = itemView.findViewById(R.id.editText10);
//            studentParentPhone = itemView.findViewById(R.id.editText8);
//            student_Semester = (TextView) itemView.findViewById(R.id.editText6);
//            student_batch = itemView.findViewById(R.id.editText4);

//            delete = itemView.findViewById(R.id.button7);
//
//            update = itemView.findViewById(R.id.button20);
//
//            edit = itemView.findViewById(R.id.button19);








//
//            update.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick (View view) {
//
//
//                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
//                    final String studentId = rootRef.child("Students").push().getKey();
//                    final String studentName = "Hari";
//
//                    Map <String, Object> map = new HashMap <>();
//                    map.put("studentId" , studentId);
//                    map.put("studentName" , studentName);
////                            rootRef.child("Students").child(studentId).updateChildren(map);
//                    rootRef.child("Students").child(studentName).updateChildren(map);
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

