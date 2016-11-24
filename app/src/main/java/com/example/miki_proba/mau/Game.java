package com.example.miki_proba.mau;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {


    private Boolean exit = false;
    private TextView tv;
    private TextView question;
    private TextView topic;
    private Button btnNext;
    private Button btnExit;
    private RadioGroup rg;
    private RadioButton rb1,rb2,rb3,rb4;

    private ImageView life1;
    private ImageView life2;
    private ImageView life3;
    private ImageView life4;
    private ImageView life5;

    private ImageView kategoria;

    private String topics[]={"Art","Geography","Maths","Music","Enviroment","Architecture","Astronomy","Informatics"};
    /*
    private String questions[]={"Julian already have one apple and bought two. How many apple he has?",     //első kérdés
                                "How much 5 + 5 ?",                                                         //második kérdés
                                "How many questions do you already answered?",                              //harmadik kérdés
                                "How much 5 * 295 / 6 ?",                                                   //negyedik kérdés
                                "How much 294871 - 5123 ?",                                                  //ötödik kérdés
                                "What is the height of a giraffe?(m)",                                      //hatodik kérdés
                                "Given: the triangle ABC with vertices A=(-1, 0), B=(1, -1) and C=(1, 2). The centre of gravity of this triangle is the point of coordinates:",
                                "Is the 528th element of Fibonacci sequence an even number? ",
                                "How do we determine the centre of gravity of a body with a irregular shape?",
                                "How do you explain that the candle swings while it burns?"};

    private String ans[]={"3","10","3","245","289748","5","S=(2/3 , 2/3)","Yes","with the help of a pin and with plumb","trying to keep the same moments of the rotation"};


    private String opt[]={"2","5","6","3",      //első válasz lehetőségek
                                    "10","20","30","40",  //második válasz lehetőségek
                                    "1","2","3","4",   //harmadik válasz lehetőségek
                                    "124","20","245","9091",    //negyedik válasz lehetőségek
                                    "223448","289748","222748","289438",       //ötödik válasz lehetőségek
                                    "100","50","5","10",       //hatodik válasz lehetőségek
                                    "S=(1/3 , 2/3)","S=(1/3 , 1/3)","S=(2/3 , 2/3)","S=(2/3 , 1/3)",
                                    "Yes","No","Yes","No",
                                    "with the help of a pin and with plumb","with the spirit -level","with the ruler","all answer is correct",
                                    "trying to find the balance","trying to keep the same moments of the rotation","trying to find the center of the gravity","all answer is correct"};
    */

    private String questions[];
    private String ans[];
    private String opt[];

    private int flag=0;
    private int correct,wrong;
    private int elet=5;
    private int kerdesek = 1;
    private int kategoriak =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        questions = getResources().getStringArray(R.array.questions);
        ans = getResources().getStringArray(R.array.ans);
        opt = getResources().getStringArray(R.array.opt);

        tv = (TextView)findViewById(R.id.textView1);
        question = (TextView)findViewById(R.id.textView3);
        topic = (TextView)findViewById(R.id.textView4);
        btnNext = (Button)findViewById(R.id.button1);
        btnExit = (Button)findViewById(R.id.button2);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        rb1 = (RadioButton)findViewById(R.id.radio0);
        rb2 = (RadioButton)findViewById(R.id.radio1);
        rb3 = (RadioButton)findViewById(R.id.radio2);
        rb4 = (RadioButton)findViewById(R.id.radio3);

        life1 = (ImageView) findViewById(R.id.Life1);
        life2 = (ImageView) findViewById(R.id.Life2);
        life3 = (ImageView) findViewById(R.id.Life3);
        life4 = (ImageView) findViewById(R.id.Life4);
        life5 = (ImageView) findViewById(R.id.Life5);

        kategoria = (ImageView) findViewById(R.id.kategoria);

        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        question.setText("(" + kerdesek + "/" + questions.length + ")");

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert1 = new AlertDialog.Builder(Game.this, R.style.AppCompatAlertDialogStyle);
                alert1.setMessage("Do you want to leave game?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                Intent tomenu = new Intent(Game.this,ThirdActivity.class);
                                startActivity(tomenu);
                            }
                        })
                        .setNegativeButton("No", null)
                        .setIcon(R.drawable.icon1)
                        .create();
                alert1.show();
            }
        });

        topic();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb1.isChecked()==true || rb2.isChecked()==true || rb3.isChecked()==true || rb4.isChecked()==true)
                {
                    topic();
                    Intent towin = new Intent(Game.this,Win.class);
                    Intent tolose = new Intent(Game.this,Lose.class);
                    RadioButton uans =(RadioButton)findViewById(rg.getCheckedRadioButtonId());
                    String ansText="";
                    ansText = uans.getText().toString();
                    if (ansText.equalsIgnoreCase(ans[flag]))
                    {
                        correct++;
                    }
                    else
                    {
                        wrong++;
                        elet--;
                    }
                    flag++;
                    kerdesek++;
                    switch(elet){
                        case 4:
                            life5.setBackgroundResource(R.drawable.heart1);
                            break;
                        case 3:
                            life5.setBackgroundResource(R.drawable.heart1);
                            life4.setBackgroundResource(R.drawable.heart1);
                            break;
                        case 2:
                            life5.setBackgroundResource(R.drawable.heart1);
                            life4.setBackgroundResource(R.drawable.heart1);
                            life3.setBackgroundResource(R.drawable.heart1);
                            break;
                        case 1:
                            life5.setBackgroundResource(R.drawable.heart1);
                            life4.setBackgroundResource(R.drawable.heart1);
                            life3.setBackgroundResource(R.drawable.heart1);
                            life2.setBackgroundResource(R.drawable.heart1);
                            break;
                        case 0:
                            startActivity(tolose);
                            break;
                    }
                    if (flag<questions.length)
                    {
                        tv.setText(questions[flag]);
                        rg.clearCheck();
                        rb1.setText(opt[flag*4]);
                        rb2.setText(opt[(flag*4)+1]);
                        rb3.setText(opt[(flag*4)+2]);
                        rb4.setText(opt[(flag*4)+3]);
                        question.setText("(" + kerdesek + "/" + questions.length + ")");
                    }
                    else
                    {
                        startActivity(towin);
                    }
                }else{
                    Toast.makeText(Game.this, "Please check answer(s)", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Log.d("LOG_game","Start");

    }

    public int topic()
    {

        Random rand = new Random();
        kategoriak = rand.nextInt(topics.length);
        switch (kategoriak)
        {
            case 0 :
                topic.setText(topics[kategoriak]);
                kategoria.setBackgroundResource(R.drawable.denmark_happy);
                break;
            case 1 :
                topic.setText(topics[kategoriak]);
                kategoria.setBackgroundResource(R.drawable.greece_happy);
                break;
            case 2 :
                topic.setText(topics[kategoriak]);
                kategoria.setBackgroundResource(R.drawable.hungary_happy);
                break;
            case 3 :
                topic.setText(topics[kategoriak]);
                kategoria.setBackgroundResource(R.drawable.italy_happy);
                break;
            case 4 :
                topic.setText(topics[kategoriak]);
                kategoria.setBackgroundResource(R.drawable.lithuania_happy_);
                break;
            case 5 :
                topic.setText(topics[kategoriak]);
                kategoria.setBackgroundResource(R.drawable.polonia_happy);
                break;
            case 6 :
                topic.setText(topics[kategoriak]);
                kategoria.setBackgroundResource(R.drawable.portugal_happy);
                break;
            case 7 :
                topic.setText(topics[kategoriak]);
                kategoria.setBackgroundResource(R.drawable.romania_happy);
                break;
        }
        return kategoriak;
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
        Log.d("LOG_game","Start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LOG_game","Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LOG_game","Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LOG_game","Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LOG_game", "Destroy");
    }
}
