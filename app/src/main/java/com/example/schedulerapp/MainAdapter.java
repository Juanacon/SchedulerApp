package com.example.schedulerapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    //Initalize variable
    Activity activity;
    ArrayList<String> arrayList;

    //Create constructor
    public MainAdapter(Activity activity, ArrayList<String> arrayList){
    this.activity =activity;
    this.arrayList =arrayList;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //initalize view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_main,parent,false);
        //return holder view
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //set text on text view
        holder.textView.setText(arrayList.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get clicked item position
                int position = holder.getAdapterPosition();
                //check condition
                switch (position){
                    case 0:
                        //when position is equal to zero redirect to homepage
                        activity.startActivity(new Intent(activity,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 1:
                        //when position is 1 go to dashboard
                        activity.startActivity(new Intent(activity,Dashboard.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 2:
                        //when position is equal to 2 go to edit
                        activity.startActivity(new Intent(activity,view.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 3:
                        //when its position 3 initalize alert dialog
                        activity.startActivity(new Intent(activity,Edit.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                }
            }

        });

    }

    @Override
    public int getItemCount() {
        //Return array list size
        int size = arrayList.size();
        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //initalize variable
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //assign variables
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
