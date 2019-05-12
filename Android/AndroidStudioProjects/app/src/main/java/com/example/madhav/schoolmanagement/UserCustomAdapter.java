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
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
//https://www.mytrendin.com/receive-data-firebase-display-recyclerview-android/
import com.example.madhav.schoolmanagement.Model.Students;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserCustomAdapter<S> extends RecyclerView.Adapter<UserCustomAdapter.MyHolder>{
    public Context mContext;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    List<Students> listdata;

    public UserCustomAdapter (Context context) {
        mContext = context;
    }

    public void setData(List<Students> listdata) {
        listdata.clear();
        listdata.addAll(listdata);
        notifyDataSetChanged();
    }

    public UserCustomAdapter (List <Students> listdata , adminteacherData adminteacherData) {
        this.listdata = listdata;

    }


    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacherdataview,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(UserCustomAdapter.MyHolder holder, final int position) {
        final  Students data = listdata.get(position);

        holder.student_id.setText(data.getStudentId());
        holder.student_fullname.setText(data.getStudentName());
        holder.student_RollNumber.setText(data.getRollNumber());
        holder.student_Division.setText(data.getDivision());
        holder.studentEnrollmentNumber.setText(data.getEnrollNumber());
        holder.student_Standard.setText(data.getStandard());
        holder.studentLoginUser.setText(data.getLoginUser());
        holder.studentloginPassword.setText(data.getLoginPassword());
        holder.student_BirthDate.setText(data.getBirthDate());
        holder.studentAddress.setText(data.getAddress());
        holder.studentParentPhone.setText(data.getParentPhone());
        holder.student_batch.setText(data.getBatch());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {

                databaseReference.child("Students").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Students userTemp = snapshot.getValue(Students.class);
                            if (data.getStudentId().equals(userTemp.getStudentId())) {

                                databaseReference.child("Students").child(snapshot.getKey().toString()).removeValue();
                                listdata.remove(position);
                                notifyDataSetChanged();



                            }

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }





        });







    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        public TextView student_id;
        public TextView student_fullname;
        public TextView student_RollNumber;
        public TextView student_Division;
        public TextView studentEnrollmentNumber;
        public TextView student_Standard;
        public TextView studentLoginUser;
        public TextView studentloginPassword;
        public TextView student_BirthDate;
        public TextView studentAddress;
        public TextView studentParentPhone;
        public TextView student_Semester;
        public TextView student_batch;
        Button delete,update,edit;



        public MyHolder(View itemView) {
            super(itemView);
            student_id = itemView.findViewById(R.id.editText28);
            student_fullname = itemView.findViewById(R.id.editText26);
            student_RollNumber = itemView.findViewById(R.id.editText24);
            studentEnrollmentNumber = itemView.findViewById(R.id.editText20);

            student_Division = itemView.findViewById(R.id.editText22);
            student_Standard = itemView.findViewById(R.id.editText18);
            studentLoginUser = itemView.findViewById(R.id.editText16);
            studentloginPassword = itemView.findViewById(R.id.editText14);
            student_BirthDate = itemView.findViewById(R.id.editText12);
            studentAddress = itemView.findViewById(R.id.editText10);
            studentParentPhone = itemView.findViewById(R.id.editText8);
//            student_Semester = (TextView) itemView.findViewById(R.id.editText6);
            student_batch = itemView.findViewById(R.id.editText4);

            delete = itemView.findViewById(R.id.button7);

            update = itemView.findViewById(R.id.button20);

            edit = itemView.findViewById(R.id.button19);









        }}}

