package com.example.madhav.schoolmanagement;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//https://www.mytrendin.com/receive-data-firebase-display-recyclerview-android/
import com.example.madhav.schoolmanagement.Model.Exam;
import com.example.madhav.schoolmanagement.Model.Fees;
import com.example.madhav.schoolmanagement.Model.Students;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FeeAdapter<S> extends RecyclerView.Adapter<FeeAdapter.MyHolder>{
    public Context mContext;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    List<Fees> list;
    public MainActivity activity;

    public FeeAdapter (Context context) {
        mContext = context;
    }

    public void setData(List<Fees> list) {
        list.clear();
        list.addAll(list);
        notifyDataSetChanged();
    }

    public FeeAdapter (List <Fees> list , fee_data_admin fee_data_admin) {
        this.list = list;

    }


    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feesdataview,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(FeeAdapter.MyHolder  holder, final int position) {
        final  Fees data = list.get(position);

        holder.studentName.setText(data.getStudentName());
        holder.pathway.setText(data.getPathway());
        holder.standard.setText(data.getStandard());
        holder.totalFee.setText(data.getTotalFee());
        holder.paidFee.setText(data.getPaidFee());
        holder.remainingFee.setText(data.getRemainingFee());
        holder.message.setText(data.getMessage());
        holder.datePicker.setText((data.getDatePicker()));


//        holder.student_Standard.setText(data.getStandard());
//        holder.studentLoginUser.setText(data.getLoginUser());
//        holder.studentloginPassword.setText(data.getLoginPassword());
//        holder.student_BirthDate.setText(data.getBirthDate());
//        holder.studentAddress.setText(data.getAddress());
//        holder.studentParentPhone.setText(data.getParentPhone());
//        holder.student_batch.setText(data.getBatch());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(mContext, "Look" + list.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {

                databaseReference.child("Fees").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Fees userTemp = snapshot.getValue(Fees.class);
                            if (data.getStudentName().equals(userTemp.getStudentName())) {
                                databaseReference.child("Fees").child(snapshot.getKey().toString()).removeValue();
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
                Intent homeIntent =  new Intent(view.getContext(), fees_admin.class);
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
        Button delete,update,edit;



        private TextView studentName ,pathway,standard,totalFee,paidFee,remainingFee,message,datePicker;
//        private DatePicker



        public MyHolder(View itemView) {
            super(itemView);
            studentName= itemView.findViewById(R.id.editText18);
            pathway= itemView.findViewById(R.id.editText17);
            standard = itemView.findViewById(R.id.editText19);
            totalFee = itemView.findViewById(R.id.editText23);
            paidFee = itemView.findViewById(R.id.editText5);
            remainingFee = itemView.findViewById(R.id.editText7);
            message = itemView.findViewById(R.id.editText21);
            datePicker = itemView.findViewById(R.id.editText25);



//            student_id = itemView.findViewById(R.id.editText28);
//            student_fullname = itemView.findViewById(R.id.editText26);
//            student_RollNumber = itemView.findViewById(R.id.editText24);
//            studentEnrollmentNumber = itemView.findViewById(R.id.editText20);
//
//            student_Division = itemView.findViewById(R.id.editText22);
//            student_Standard = itemView.findViewById(R.id.editText18);
//            studentLoginUser = itemView.findViewById(R.id.editText16);
//            studentloginPassword = itemView.findViewById(R.id.editText14);
//            student_BirthDate = itemView.findViewById(R.id.editText12);
//            studentAddress = itemView.findViewById(R.id.editText10);
//            studentParentPhone = itemView.findViewById(R.id.editText8);
////            student_Semester = (TextView) itemView.findViewById(R.id.editText6);
//            student_batch = itemView.findViewById(R.id.editText4);

            delete = itemView.findViewById(R.id.button7);

            update = itemView.findViewById(R.id.button20);

            edit = itemView.findViewById(R.id.button19);











//
//           holder.update.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick (View view) {
//
//                    Intent homeIntent = new Intent(mContext,fees_admin.class);
//                    mContext.startActivity(homeIntent);
//


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


//                }
//            });
        }}}
