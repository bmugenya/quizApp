package com.example.mistybuilder.quiz_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class Main6Activity extends Activity {

    QuizData quizData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        Bundle prevBundle = getIntent().getExtras();
        quizData = (QuizData) prevBundle.getSerializable("quiz_data");
        final Bundle bundle = new Bundle();
        final Intent intent = new Intent(Main6Activity.this, Main7Activity.class);

        Log.d("Check Box:", Integer.toString(0));

        final ArrayList<CheckBox> CheckBoxList = new ArrayList<CheckBox>(4);
        CheckBox one = (CheckBox) findViewById(R.id.one);
        CheckBoxList.add(one);
        CheckBox two = (CheckBox) findViewById(R.id.two);
        CheckBoxList.add(two);

        Button next = (Button) findViewById(R.id.next);

        for (int i=0; i<2; i++){
            final int num = i;
            CheckBoxList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch(num){
                        case 0:
                            if (CheckBoxList.get(1).isChecked()) {
                                CheckBoxList.get(1).toggle();
                            }
                            break;
                        case 1:
                            if (CheckBoxList.get(0).isChecked()){
                                CheckBoxList.get(0).toggle();
                            }
                            break;
                    }
                }
            });
        }


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CheckBoxList.get(0).isChecked()){
                    Log.d("Check Box:", Integer.toString(0));
                    quizData.setQAnswer(5, 0);
                }
                if(CheckBoxList.get(1).isChecked()){
                    Log.d("Check Box:", Integer.toString(1));
                    quizData.setQAnswer(5, 1);
                }
                Log.d("Check Box from QD:", Integer.toString(quizData.getQ5()));
                bundle.putSerializable("quiz_data", quizData);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}