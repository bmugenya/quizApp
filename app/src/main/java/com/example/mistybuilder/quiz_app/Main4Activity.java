package com.example.mistybuilder.quiz_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    QuizData quizData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        Button next = findViewById(R.id.next);

        Bundle prevBundle = getIntent().getExtras();
        quizData = (QuizData) prevBundle.getSerializable("quiz_data");
        final Bundle bundle = new Bundle();
        final Intent intent = new Intent(Main4Activity.this, Main5Activity.class);

        ArrayList<Button> buttonList = new ArrayList<>(4);
        Button one = findViewById(R.id.one);
        buttonList.add(one);
        Button two =  findViewById(R.id.two);
        buttonList.add(two);
        Button three =  findViewById(R.id.three);
        buttonList.add(three);
        Button four =  findViewById(R.id.four);
        buttonList.add(four);

        for (int i=0; i< buttonList.size(); i++){
            final int q_num = i;
            buttonList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (q_num){
                        case 0:
                            quizData.setQAnswer(3, q_num);
                            break;
                        case 1:
                            quizData.setQAnswer(3, q_num);
                            break;
                        case 2:
                            quizData.setQAnswer(3, q_num);
                            break;
                        case 3:
                            quizData.setQAnswer(3, q_num);
                            break;
                        case 4:
                            quizData.setQAnswer(3, q_num);
                            break;
                    }

                    Log.d("Button pressed index", Integer.toString(q_num));

                    bundle.putSerializable("quiz_data", quizData);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
    }
}