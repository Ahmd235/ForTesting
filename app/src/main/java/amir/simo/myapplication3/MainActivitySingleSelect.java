package amir.simo.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivitySingleSelect extends AppCompatActivity implements SingleAdapter.Myinterface {

    private RecyclerView rec;
    private Button btn;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_single_select);
        rec=findViewById(R.id.RecSingleSelect);
        txt=findViewById(R.id.txtSize);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        rec.setLayoutManager(linearLayoutManager);
        List<Nom> name=new ArrayList<>();
        for (int i=0;i<30;i++){
            Nom nom=new Nom("Name "+i);
            name.add(nom);
        }
        SingleAdapter singleAdapter=new SingleAdapter(this,name);
        singleAdapter.setMyinterface(this::CallbackItem);
        rec.setAdapter(singleAdapter);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent (MainActivitySingleSelect.this,MainActivity3.class);
                startActivity(it);
            }
        });
    }


    @Override
    public void CallbackItem(String data) {
        txt.setText(data);
    }
}