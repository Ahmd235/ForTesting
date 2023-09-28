package amir.simo.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private RecyclerView rec;
    private Button btn;
    private Button btn2;
    private ArrayList<Nom> listVide=new ArrayList<Nom>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rec=findViewById(R.id.RecSingleSelect2);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        rec.setLayoutManager(linearLayoutManager);
        List<Nom> name=new ArrayList<>();
        for (int i=0;i<30;i++){
            Nom nom=new Nom("nombre "+i);
            name.add(nom);
        }
        SingleAdapter singleAdapter=new SingleAdapter(this,name);
        rec.setAdapter(singleAdapter);
        btn=findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity3.this,MainActivitySingleSelect.class);
                startActivity(it);
            }
        });
        btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences= getSharedPreferences("sharedSaved", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();

                Gson gson=new Gson ();
                String json=gson.toJson(listVide);
                editor.putString("tasklist",json);
                editor.apply();
            }
        });
    }
}