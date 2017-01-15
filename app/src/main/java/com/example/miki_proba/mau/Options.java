package com.example.miki_proba.mau;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Options extends AppCompatActivity {

    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private List<String> list;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);


        spinner = (Spinner) findViewById(R.id.spinner);
        back = (ImageView) findViewById(R.id.image_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tothird = new Intent(Options.this, ThirdActivity.class);
                startActivity(tothird);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        list = new ArrayList<String>();
        list.add("Hungary");
        list.add("Portuguese");
        list.add("Italian");
        list.add("Denmark");
        list.add("Poland");
        list.add("Romania");
        list.add("Lithuania");
        list.add("Greece");
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        Log.d("LOG_Options","Create");
    }
}
