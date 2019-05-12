package com.example.madhav.schoolmanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
//https://www.mytrendin.com/receive-data-firebase-display-recyclerview-android/
import com.example.madhav.schoolmanagement.Model.Students;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csa on 3/6/2017.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyHolder>{

    List<Listdata> listdata;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    public String  value;

    public RecyclerviewAdapter(List <Listdata> listdata) {
        this.listdata = listdata;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myview,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(final MyHolder holder, final int position) {

        final Listdata data = listdata.get(position);


        holder.vname3.setText(data.getName1());
        holder.vname.setText(data.getName());
        holder.vemail.setText(data.getEmail());
        holder.vaddress.setText(data.getAddress());








//                databaseReference.child("message").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        listdata = new ArrayList<>();
//                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                            Userdetails userdetails = snapshot.getValue(Userdetails.class);
//                            String value = userdetails.getSpinner();
//
//
//                            try {
//
//                                switch (value){
//                                    case "Present":
//                                        holder.vname.setText(data.getName());
//
//                                        break;
//
//                                    case "Absent":
//                                        holder.vname3.setText(data.getName1());
//
//                                        break;
//                                }
////
//
//                            }
//
//                            catch (NullPointerException e) {
//                                System.out.println("NullPinter Exception caught: in the value");
//                            }
//
//                            finally {
//                                holder.vname3.setText(data.getName1());
//                                holder.vname.setText(data.getName());
//                            }
//
//
//
//
//
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





            }







    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        TextView vname , vaddress,vemail,vname3;


        public MyHolder(View itemView) {
            super(itemView);
            vname = (TextView) itemView.findViewById(R.id.vname);
            vemail = (TextView) itemView.findViewById(R.id.vemail);
            vaddress = (TextView) itemView.findViewById(R.id.vaddress);
            vname3 = (TextView) itemView.findViewById(R.id.vname3);

        }
    }


}
