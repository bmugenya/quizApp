package com.example.mistybuilder.quiz_app;

import java.io.Serializable;
import java.util.ArrayList;

public class QuizData implements  Serializable{
    private String name = "";
    private int q1;
    private int q2;
    private int q3;
    public ArrayList<Integer> q4 = new ArrayList<Integer>(5);
    private int q5;

    public int getQ1() {
        return q1;
    }

    public int getQ2() {
        return q2;
    }

    public int getQ3() {
        return q3;
    }

    public ArrayList<Integer> getQ4() {
        return q4;
    }

    public int getQ5() { return q5; }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int setQAnswer(int q_number, int value){
        switch (q_number){
            case 1:
                this.q1 = value;
                break;
            case 2:
                this.q2 = value;
                break;
            case 3:
                this.q3 = value;
                break;
            case 5:
                this.q5 = value;
                break;
            default:
                return -1;
        }
        return 0;
        // Won't check if the values have been changed!
    }

}