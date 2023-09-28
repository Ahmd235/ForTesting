package amir.simo.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView rv2;
    RecyclerView rv3;
    FrameLayout fl;
    TextView txt;
    Button btnstart;
    Button btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.test);
       // txt.setBackgroundColor(Color.rgb(127, 255, 212));
        btnstart=findViewById(R.id.btnstart);
        btnStop=findViewById(R.id.btnstop);
        txt.setBackgroundColor(Color.parseColor("#FF6200EE"));

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,TestSeervice.class);
                startService(it);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Thread.sleep(5000);
                    Intent it=new Intent(MainActivity.this,TestSeervice.class);
                    stopService(it);
                }
                catch (Exception e){

                }

            }
        });
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(it);
            }
        });

        //  BlankFragment blankFragment=new BlankFragment();
       // fl=findViewById(R.id.frameLayout);
      /*  Bundle args=new Bundle();
        args.putString("info","Hello success");
        blankFragment.setArguments(args);
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout,blankFragment);
        ft.commit();*/
        rv=findViewById(R.id.recycleview1);
      //  rv2=findViewById(R.id.recycleview2);
        rv3=findViewById(R.id.recycleview3);
        List<String> name=new ArrayList<>();
        ArrayList<Nom> list=new ArrayList<Nom>();
        for (int i=0;i<30;i++){
            name.add("Name "+i);
            Nom nom=new Nom("Name"+i);
            list.add(nom);
        }



        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
         rv.setLayoutManager(gridLayoutManager);
        MyAdapter adapter=new MyAdapter(this,name);
        rv.setAdapter(adapter);
       // rv2.setLayoutManager(new LinearLayoutManager(this));


        SingleAdapter adapter1=new SingleAdapter(this,list);
       // rv2.setAdapter(adapter1);

        SingleAdapter adapter3=new SingleAdapter(this,list);


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rv3.setLayoutManager(linearLayoutManager);
        rv3.setAdapter(adapter3);


    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "Stoped", Toast.LENGTH_SHORT).show();
        super.onStop();
    }
}