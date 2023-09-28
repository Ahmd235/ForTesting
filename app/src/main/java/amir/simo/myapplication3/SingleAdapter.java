package amir.simo.myapplication3;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.SingleViewHolder> {

    Context context;
    List<Nom> data;
    int CheckPosition=-1;
    ArrayList<Nom> SelectedItems;
    SharedPreferences sharedSave;
    private Myinterface myinterface;



    public SingleAdapter(Context context,List<Nom> data){
        this.context=context;
        this.data=data;
    }
    public SingleAdapter(){

    }

    public void setMyinterface(Myinterface myinterface) {
        this.myinterface = myinterface;
    }

    public void setSelectedItems(ArrayList<Nom> selectedItems) {
        SelectedItems = selectedItems;
    }

    @NonNull
    @Override
    public SingleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recyvle_layout2,parent,false);
        return new SingleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleViewHolder holder, int position) {
        holder.bind("hgh");

    }

    @Override
    public int getItemCount() {
        return data.size(); //Important to be set!
    }

    public class SingleViewHolder extends RecyclerView.ViewHolder {
        TextView  txtName;
        ImageView Image;
        public SingleViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.textV);
            Image=itemView.findViewById(R.id.Imag);
        }

        //getting the selected Item
        void bind(final String name){

            if(CheckPosition==-1){
                Image.setVisibility(View.INVISIBLE);
            }else{
                if(CheckPosition==getAdapterPosition()){

                    Image.setVisibility(View.VISIBLE);
                }
                else{
                    Image.setVisibility(View.INVISIBLE);
                }
            }
            txtName.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    CheckPosition=getAdapterPosition();

                    notifyItemChanged(CheckPosition);
                    notifyDataSetChanged();

                }
            });
        }

        void showSelectedItems (){
            ArrayList<Nom> List=new ArrayList<Nom>();
            SharedPreferences spp= context.getSharedPreferences("sharedSaved",Context.MODE_PRIVATE);
            Gson gson=new Gson();

            String json=spp.getString("tasklist",null);
            Type type=new TypeToken<ArrayList<Nom>>(){}.getType();
            List=gson.fromJson(json,type);
            Toast.makeText(context, "Here "+List.size(), Toast.LENGTH_SHORT).show();
            for (Nom nom:List)
                  {
                    // Toast.makeText(context, "Here "+List.size()+"  "+nom.getString(), Toast.LENGTH_SHORT).show();
            }
            myinterface.CallbackItem("Here is the size: "+List.size());

        }
        void bindMutiple (final Nom name){
            Image.setVisibility(name.isChecked() ? View.VISIBLE : View.INVISIBLE);
            txtName.setText(name.getString());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try{
                        name.setChecked(!name.isChecked());
                        Image.setVisibility(name.isChecked() ? View.VISIBLE : View.INVISIBLE);

                        SharedPreferences spp= context.getSharedPreferences("sharedSaved",Context.MODE_PRIVATE);
                        Gson gson1=new Gson();

                        String json1=spp.getString("tasklist",null);
                        Type type=new TypeToken<ArrayList<Nom>>(){}.getType();
                        setSelectedItems(gson1.fromJson(json1,type));

                        SelectedItems.add(name);
                        sharedSave= context.getSharedPreferences("sharedSaved",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= sharedSave.edit();

                        Gson gson=new Gson ();
                        String json=gson.toJson(SelectedItems);
                        editor.putString("tasklist",json);
                        editor.apply();
                        Toast.makeText(context, "Saved ", Toast.LENGTH_SHORT).show();
                    }
                    catch(Exception ex){

                        Nom n=new Nom(name.getString());
                        SelectedItems=new ArrayList<Nom>();
                        SelectedItems.add(n);
                        sharedSave= context.getSharedPreferences("sharedSaved",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= sharedSave.edit();

                        Gson gson=new Gson ();
                        String json=gson.toJson(SelectedItems);
                        editor.putString("tasklist",json);
                        editor.apply();
                        Toast.makeText(context, "Here "+SelectedItems.size(), Toast.LENGTH_SHORT).show();

                    }

                    }



            });
            txtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showSelectedItems();
                }
            });
        }
    }
    public interface Myinterface{
        void CallbackItem(String data);
    }
}
