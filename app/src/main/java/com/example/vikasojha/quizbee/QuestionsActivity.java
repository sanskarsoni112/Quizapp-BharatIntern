package com.example.vikasojha.quizbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
                            "Number of primitive data types in Java are??",
                            "What is the size of float and double in java??",
                            "Automatic type conversion is possible in which of the possible cases?",
                            "Select the valid statement.",
                            "When an array is passed to a method, what does the method receive?",
                            "Select the valid statement to declare and initialize an array",
                            "Arrays in java are-",
                            "When is the object created with new keyword?",
                            "compareTo() returns",
                            "In which of the following is toString() method defined?"
                         };
    String answers[] = {"8","32 and 64","int to long","char ch[] = new char[5]","The reference of array","int[] A={1,2,3}","objects","At run time","An int value","java.lang.string"};
    String opt[] = {
                    "6","7","8","9",
                    "32 and 64","32 and 48","48 and 56","48 and 86",
                    "byte to int","int to long","long to int","short to int",
                    "char ch[] = new char[5]","char ch= new char(5)","char ch[]= new char[]","char ch[]= new char()",
                    "Length of array","A copy of array","Copy of first element","The reference of array",
                    "int[] A={}","int[] A={1,2,3}","int[] A=()","int[][] A = {1,2,3}",
                    "objects","objects reference","primitive data type","None of the mentioned",
                    "Depends on code","At compile time","At run time","All of the above",
                    "True","False","An int value","None",
                    "java.util.string","java.lang.string","java.lang.obj","java.lang.obj"
                   };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
        textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.btn_next);
        quitbutton=(Button)findViewById(R.id.btn_quit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.opt_1);
        rb2=(RadioButton)findViewById(R.id.opt_2);
        rb3=(RadioButton)findViewById(R.id.opt_3);
        rb4=(RadioButton)findViewById(R.id.opt_4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}