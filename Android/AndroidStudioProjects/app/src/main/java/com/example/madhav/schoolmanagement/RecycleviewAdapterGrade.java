package com.example.madhav.schoolmanagement;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
//https://www.mytrendin.com/receive-data-firebase-display-recyclerview-android/
import java.util.List;


public class RecycleviewAdapterGrade extends RecyclerView.Adapter<RecycleviewAdapterGrade.MyHolder>{

    List<Listdata> listdata;

    public RecycleviewAdapterGrade(List <Listdata> listdata) {
        this.listdata = listdata;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gradeview,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(MyHolder holder, int position) {

        Listdata data = listdata.get(position);
//         String s1 = data.getName();
//
//        switch(s1) {
//            case "Present":
//                holder.vname.setText(data.getName());
//                break;
//
//
//            case "Absent":
//            holder.vname3.setText(data.getName1());
//            break;
//
//        }

//        holder.vname3.setText(data.getName1());
        holder.vname.setText(data.getName());
        holder.vemail.setText(data.getEmail());
        holder.vaddress.setText(data.getAddress());


    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        TextView vname , vaddress,vemail;

        public MyHolder(View itemView) {
            super(itemView);
            vname = (TextView) itemView.findViewById(R.id.vname);
            vemail = (TextView) itemView.findViewById(R.id.vemail);
            vaddress = (TextView) itemView.findViewById(R.id.vaddress);
//            vname3 = (TextView) itemView.findViewById(R.id.vname3);

        }
    }


}
