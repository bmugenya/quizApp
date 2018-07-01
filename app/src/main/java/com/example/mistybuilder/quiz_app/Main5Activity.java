package com.example.mistybuilder.quiz_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class Main5Activity extends Activity {

    QuizData quizData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        Button next = (Button) findViewById(R.id.next);

        Bundle prevBundle = getIntent().getExtras();
        quizData = (QuizData) prevBundle.getSerializable("quiz_data");
        final Bundle bundle = new Bundle();
        final Intent intent = new Intent(Main5Activity.this, Main6Activity.class);

        final ArrayList<CheckBox> CheckBoxList = new ArrayList<CheckBox>(4);
        CheckBox one = (CheckBox) findViewById(R.id.one);
        CheckBoxList.add(one);
        CheckBox two = (CheckBox) findViewById(R.id.two);
        CheckBoxList.add(two);
        CheckBox three = (CheckBox) findViewById(R.id.three);
        CheckBoxList.add(three);
        CheckBox four = (CheckBox) findViewById(R.id.four);
        CheckBoxList.add(four);
        final CheckBox five = (CheckBox) findViewById(R.id.five);
        CheckBoxList.add(five);
        // Could've used an loop, but eh!

        for(int i=0; i<4; i++){
            final int num = i;
            CheckBoxList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(CheckBoxList.get(4).isChecked()){
                        CheckBoxList.get(4).toggle();
                    }
                }
            });
        }

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(five.isChecked()){
                    for(int i = 0; i<4; i++){
                        if(CheckBoxList.get(i).isChecked()) {
                            CheckBoxList.get(i).toggle();
                        }
                    }
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Integer> checkedBoxes = new ArrayList<>(5);
                for (int i = 0; i < CheckBoxList.size(); i++){
                    if (CheckBoxList.get(i).isChecked()){
                        checkedBoxes.add(i);
                        quizData.q4.add(i);
                    }
                }
                Log.d("!!!!!!", checkedBoxes.toString());
                quizData.q4 = checkedBoxes;
                for (int i = 0; i < checkedBoxes.size(); i++){
                    Log.d("Inserted", Integer.toString(quizData.q4.get(i)));
                    Log.d("Checkboxes checked:", Integer.toString(checkedBoxes.get(i)));
                }

                bundle.putSerializable("quiz_data", quizData);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}