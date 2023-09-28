package amir.simo.myapplication3;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    int ChekPos=0;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txt=itemView.findViewById(R.id.textV);
    }
    void bind(final String string){
        if (ChekPos==-1){

            txt.setBackgroundColor(Color.parseColor("#FF03DAC5"));
        }
        else {
            if(ChekPos==getAdapterPosition()){
                txt.setBackgroundColor(Color.parseColor("#FF6200EE"));
            }
            else{
                txt.setBackgroundColor(Color.parseColor("#FF03DAC5"));

            }
            
        }
              txt.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      txt.setBackgroundColor(Color.parseColor("#FF6200EE"));
                      if(ChekPos!=getAdapterPosition()){
                          ChekPos=getAdapterPosition();
                      }
                  }
              });
    }
}
