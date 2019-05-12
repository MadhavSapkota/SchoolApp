//package com.example.madhav.schoolmanagement;
//
//public class HomeworkRecyclerviewAdapter {
//}
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

public class HomeworkRecyclerviewAdapter extends RecyclerView.Adapter<HomeworkRecyclerviewAdapter.MyHolder>{

    List<HomeworkList> listdata;

    public HomeworkRecyclerviewAdapter(List<HomeworkList> listdata) {
        this.listdata = listdata;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homeworkview,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(MyHolder holder, int position) {
        HomeworkList data = listdata.get(position);
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

        }
    }


}
