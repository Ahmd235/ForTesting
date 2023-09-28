package amir.simo.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BlankFragment blankFragment=new BlankFragment();
        Bundle args=new Bundle();
        args.putString("info","Hello success");
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();

    }
}