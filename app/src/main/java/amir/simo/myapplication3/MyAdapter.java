package amir.simo.myapplication3;

import static android.R.color.darker_gray;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    List<String> mdata;
    int CheckedPosition =0;
   static MainActivity mainActivity;



    public MyAdapter(Context c,List<String> mdata){
        this.c=c;
        this.mdata=mdata;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(c).inflate(R.layout.recyvle_layout2,parent,false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt.setText(mdata.get(position));
            holder.bind(mdata.get(position));
       //

/*
        holder.txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // SharedPreferences sharedPreferences= c.getSharedPreferences("Testing",Context.MODE_PRIVATE);
                holder.txt.setTypeface(null, Typeface.BOLD);
                holder.txt.setBackgroundColor(Color.parseColor("#FF6200EE"));

            //    holder.txt.setBackgroundTintList(ColorStateList.valueOf(darker_gray));

             *//*   if(holder.getAdapterPosition()==3) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    BlankFragment blankFragment = new BlankFragment();
                    Bundle args = new Bundle();
                    args.putString("info", "Hello success");
                    blankFragment.setArguments(args);
                    FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
                //    ft.replace(R.id.frameLayout, blankFragment);
                    ft.commit();
                }
                else {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    BlankFragment blankFragment = new BlankFragment();
                    Bundle args = new Bundle();
                    args.putString("info", "Hello success 1");
                    blankFragment.setArguments(args);
                    FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
                  //  ft.replace(R.id.frameLayout, blankFragment);
                    ft.commit();
                }*//*




            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }
}
