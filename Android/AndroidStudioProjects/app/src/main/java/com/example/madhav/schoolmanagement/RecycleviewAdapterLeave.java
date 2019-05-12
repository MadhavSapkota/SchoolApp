package com.example.madhav.schoolmanagement;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
//https://www.mytrendin.com/receive-data-firebase-display-recyclerview-android/
import java.util.List;

/**
 * Created by csa on 3/6/2017.
 */

public class RecycleviewAdapterLeave extends RecyclerView.Adapter<RecycleviewAdapterLeave.MyHolder>{

    private List<studentLeave> list;

    public RecycleviewAdapterLeave(List <studentLeave> list) {
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myview1,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(MyHolder holder, int position) {
        studentLeave data = new studentLeave();

        holder.student_fullname.setText(data.getStudent_fullname());
        holder.student_RollNumber.setText(data.getStudent_RollNumber());
        holder.studentDivision.setText(data.getStudentDivision());
        holder.student_Standard.setText(data.getStudent_Standard());
        holder.leave_Type.setText(data.getLeave_Type());
        holder.from_date.setText(data.getFrom_date());
        holder.to_date.setText(data.getTo_date());
        holder.message_details.setText(data.getMessage_details());

//
//        studentLeave.setStudent_fullname(fullname);
//        studentLeave.setStudent_RollNumber(rollNumber);
//        studentLeave.setStudentDivision(division);
//        studentLeave.setStudent_Standard(standard);
//        studentLeave.setLeave_Type(leaveType);
//        studentLeave.setFrom_date(from_date);
//        studentLeave.setTo_date(to_date);
//        studentLeave.setMessage_details(message_details);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
//        TextView vname , vaddress,vemail;
TextView student_fullname,student_RollNumber,studentDivision,
        student_Standard,leave_Type,from_date,to_date,message_details;

        public MyHolder(View itemView) {
            super(itemView);
//            vname = (TextView) itemView.findViewById(R.id.vname);
//            vemail = (TextView) itemView.findViewById(R.id.vemail);
//            vaddress = (TextView) itemView.findViewById(R.id.vaddress);

            student_fullname = (TextView) itemView.findViewById(R.id.editText26);
            student_RollNumber = (TextView)itemView.findViewById(R.id.editText24);
            studentDivision = (TextView) itemView.findViewById(R.id.editText22);
            student_Standard = (TextView) itemView.findViewById(R.id.editText18);
            leave_Type = (TextView) itemView.findViewById(R.id.editText16);
            from_date = (TextView) itemView.findViewById(R.id.editText14);
            to_date =  (TextView) itemView.findViewById(R.id.editText12);
            message_details = (TextView) itemView.findViewById(R.id.editText10);


        }
    }


}
