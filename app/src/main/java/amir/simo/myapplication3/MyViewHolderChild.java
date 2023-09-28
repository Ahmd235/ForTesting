package amir.simo.myapplication3;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolderChild extends RecyclerView.ViewHolder {
    TextView tct;
    RecyclerView rec;
    public MyViewHolderChild(@NonNull View itemView) {
        super(itemView);
        tct=(itemView).findViewById(R.id.txtTitles);
        rec=(itemView).findViewById(R.id.recycleitem);

    }
}
