

package com.example.madhav.schoolmanagement;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
//https://www.mytrendin.com/receive-data-firebase-display-recyclerview-android/
import java.util.List;

/**
 * Created by csa on 3/6/2017.
 */

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.MyHolder>{

    List<studentLeave> listdata;

    public PersonListAdapter(List <studentLeave> listdata) {
        this.listdata = listdata;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myview1,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(MyHolder holder, int position) {
        studentLeave data = listdata.get(position);
        holder.student_fullname.setText(data.getStudent_fullname());
        holder.student_RollNumber.setText(data.getStudent_RollNumber());
        holder.studentDivision.setText(data.getStudentDivision());
        holder.student_Standard.setText(data.getStudent_Standard());
        holder.leave_Type.setText(data.getLeave_Type());
        holder.from_date.setText(data.getFrom_date());
        holder.to_date.setText(data.getTo_date());
        holder.message_details.setText(data.getMessage_details());
//
//        holder.student_fullname = (TextView) convertView.findViewById(R.id.textView1);
//        holder.student_RollNumber = (TextView) convertView.findViewById(R.id.textView2);
//        holder.studentDivision = (TextView) convertView.findViewById(R.id.textView3);
//        holder.student_Standard = (TextView) convertView.findViewById(R.id.textView4);
//        holder.leave_Type = (TextView) convertView.findViewById(R.id.textView5);
//        holder.from_date = (TextView) convertView.findViewById(R.id.textView6);
//        holder.to_date = (TextView) convertView.findViewById(R.id.textView7);
//        holder.message_details = (TextView) convertView.findViewById(R.id.textView8);


    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        TextView vname , vaddress,vemail;
        TextView student_fullname;
        TextView student_RollNumber;
        TextView studentDivision;
        TextView student_Standard;
        TextView leave_Type;
        TextView from_date;
        TextView to_date;
        TextView message_details;
        TextView textName;
        TextView textAddress;
        TextView textLocation;

        public MyHolder(View itemView) {
            super(itemView);
           student_fullname = (TextView) itemView.findViewById(R.id.textView1);
            student_RollNumber = (TextView) itemView.findViewById(R.id.textView2);
            studentDivision = (TextView) itemView.findViewById(R.id.textView3);
            student_Standard = (TextView) itemView.findViewById(R.id.textView4);
            leave_Type = (TextView) itemView.findViewById(R.id.textView5);
            from_date = (TextView) itemView.findViewById(R.id.textView6);
            to_date = (TextView) itemView.findViewById(R.id.textView7);
            message_details = (TextView) itemView.findViewById(R.id.textView8);

//
//            holder.student_fullname = (TextView) convertView.findViewById(R.id.textView1);
//            holder.student_RollNumber = (TextView) convertView.findViewById(R.id.textView2);
//            holder.studentDivision = (TextView) convertView.findViewById(R.id.textView3);
//            holder.student_Standard = (TextView) convertView.findViewById(R.id.textView4);
//            holder.leave_Type = (TextView) convertView.findViewById(R.id.textView5);
//            holder.from_date = (TextView) convertView.findViewById(R.id.textView6);
//            holder.to_date = (TextView) convertView.findViewById(R.id.textView7);
//            holder.message_details = (TextView) convertView.findViewById(R.id.textView8);

        }
    }


}
