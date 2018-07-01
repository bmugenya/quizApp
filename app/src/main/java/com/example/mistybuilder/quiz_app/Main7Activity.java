package com.example.mistybuilder.quiz_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main7Activity extends Activity {

    QuizData quizData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        Bundle prevBundle = getIntent().getExtras();
        quizData = (QuizData) prevBundle.getSerializable("quiz_data");

        Button exitButton = findViewById(R.id.exit);

        TextView name = findViewById(R.id.results);
        TextView res1 = findViewById(R.id.results1);
        TextView res2 = findViewById(R.id.results2);
        TextView res3 = findViewById(R.id.results3);
        TextView res4 = findViewById(R.id.results4);

//        String  ansName = quizData.getName();
//        Integer ans1 = quizData.getQ1();
//        Integer ans2 = quizData.getQ2();
//        Integer ans3 = quizData.getQ3();
//        ArrayList<Integer> ans4 = new ArrayList<>();
//        for (int i = 0; i < quizData.q4.size(); i++) {
//            ans4.add(quizData.q4.get(i));
//        }
//        ans4.addAll(quizData.q4);
//        String ans5 = Integer.toString(quizData.getQ5());


        name.append(quizData.getName());
        res1.append(Integer.toString(quizData.getQ1()));
        res2.append(Integer.toString(quizData.getQ2()));
        res3.append(Integer.toString(quizData.getQ3()));
        for (int i = 0; i < quizData.q4.size(); i++) {
            res4.append(Integer.toString(quizData.q4.get(i)));
        }
        res4.append(Integer.toString(quizData.getQ5()));


        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                System.exit(0);
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);             }
        });
    }
}