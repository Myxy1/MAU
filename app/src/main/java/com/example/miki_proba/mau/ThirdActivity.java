package com.example.miki_proba.mau;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private TextView name2;
    private String name;
    private Boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);


        name2 = (TextView) findViewById(R.id.name2);

        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        name = sharedPreferences.getString("name","N/A");

        name2.setText(name);
        Log.d("LOG_third","Create");
    }
    public void start(View view){
        Intent intent = new Intent(ThirdActivity.this,Game.class);
        startActivity(intent);
    }

    public void credits(View view){
        AlertDialog.Builder alert1 = new AlertDialog.Builder(this);
        alert1.setMessage("Developers:\n\tMerényi Miklós\n\tPuskás Dávid"+"\nInventor:\n\tMiguel Rodrigues")
                .setPositiveButton("Close", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        dialog.dismiss();
                    }
                })
                .setTitle("Developers and Inventor:")
                .setIcon(R.drawable.icon1)
                .create();
        alert1.show();
    }


    @Override
    public void onBackPressed() {
        if (exit) {

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LOG_third","Start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LOG_third","Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LOG_third","Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LOG_third","Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LOG_third", "Destroy");
    }
}
