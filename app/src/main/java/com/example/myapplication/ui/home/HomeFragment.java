package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tys.cachepreference.MyCachePref;

import com.example.myapplication.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    EditText edt_name;
    Button btn_save;
    TextView tv_save_data;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        tv_save_data = root.findViewById(R.id.tv_save_data);
        btn_save = root.findViewById(R.id.btn_save);
        edt_name = root.findViewById(R.id.edt_name);
        btn_save.setOnClickListener(SaveClick);
        String data = MyCachePref.loadPrefsString("name",getActivity());
        if(data != null){
            edt_name.setText(data);
        }
        return root;
    }

    private View.OnClickListener SaveClick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            MyCachePref.savePrefsString("name",edt_name.getText().toString(), getActivity());
        }
    };


}