package amir.simo.myapplication3;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MychildAdapter extends RecyclerView.Adapter<MyViewHolderChild> {

    Context cc;
    List<Categories> mlist;

    public MychildAdapter(Context cc,List<Categories> mlist){
        this.cc=cc;
        this.mlist=mlist;
    }
    @NonNull
    @Override
    public MyViewHolderChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(cc).inflate(R.layout.listmere_item,parent,false);
        return new MyViewHolderChild(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderChild holder, int position) {
        holder.tct.setText(mlist.get(position).Titles);
      
       // holder.rec.setAdapter();


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
