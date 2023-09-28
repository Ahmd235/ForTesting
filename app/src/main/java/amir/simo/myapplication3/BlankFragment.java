package amir.simo.myapplication3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class BlankFragment extends Fragment {

    TextView t;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        t=view.findViewById(R.id.txtfragment);
        t.setText(getArguments().getString("info"));

       // Toast.makeText(view.getContext(), ""+getArguments().getString("info"), Toast.LENGTH_SHORT).show();
        return view;
    }
}