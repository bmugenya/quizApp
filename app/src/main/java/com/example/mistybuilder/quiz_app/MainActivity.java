package com.example.mistybuilder.quiz_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    QuizData quizData = new QuizData();
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView name = (TextView) findViewById(R.id.name);
        Button nextBtn = (Button) findViewById(R.id.startBtn);
        Button exit = (Button) findViewById(R.id.exit);

        quizData.setName(name.getText().toString());
        bundle.putSerializable("quiz_data", quizData);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quitApp();
            }
        });
    }

    public void quitApp(){
        finish();
        System.exit(0);
    }
}
