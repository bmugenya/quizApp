package com.example.mistybuilder.quiz_app;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    QuizData quizData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Bundle prevBundle = getIntent().getExtras();
        quizData = (QuizData) prevBundle.getSerializable("quiz_data");
        final Bundle bundle = new Bundle();
        final Intent intent = new Intent(Main3Activity.this, Main4Activity.class);

        Button next = (Button) findViewById(R.id.next);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioG);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checked = radioGroup.getCheckedRadioButtonId();
                RadioButton radio = radioGroup.findViewById(checked);
                int index = radioGroup.indexOfChild(radio);
                Log.d("Checked Radio: ","findme" + Integer.toString(checked));
                switch (index){
                    case 0:
                        quizData.setQAnswer(2,index);
                        break;
                    case 1:
                        quizData.setQAnswer(2,index);
                        break;
                    case 2:
                        quizData.setQAnswer(2,index);
                        break;
                }
                Log.d("Checked Radio: ","q2->" + quizData.getQ2());

                bundle.putSerializable("quiz_data", quizData);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}