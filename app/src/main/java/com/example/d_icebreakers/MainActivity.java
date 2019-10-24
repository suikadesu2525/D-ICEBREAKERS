package com.example.d_icebreakers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int diceNum;
    private TextView diceNumLabel;
    private Button dicerollButton;
    private ArrayList<String> diceBreakerQuestions;
    public MainActivity() {
        diceNum = 0;
        diceBreakerQuestions = new ArrayList<>();
        initialiseDefaultQuestions();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button diceBreakerButton = findViewById(R.id.diceBreakerButton);
        Button addRuleButton = findViewById(R.id.addRule);
        dicerollButton = findViewById(R.id.diceRollButton);
        diceNumLabel = findViewById(R.id.diceNum);
        final TextView diceBreakerQuestionLabel = findViewById(R.id.dicebreaker_question);
        dicerollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diceNum_string = "Dice rolled, and number is " + roll_the_dice(6);
                diceNumLabel.setText(diceNum_string);
            }
        });
        diceBreakerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceBreakerQuestionLabel.setText(diceBreakerQuestions.get(roll_the_dice(diceBreakerQuestions.size()-1)));
            }
        });
        addRuleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQuestion();
            }
        });
    }

    private int roll_the_dice(int value) {
        Random randomDice = new Random();
        diceNum = randomDice.nextInt(value)+1;
        return diceNum;
    }

    private void initialiseDefaultQuestions() {
        diceBreakerQuestions.add("If you could go anywhere in the world," +
                                    " where would you go?");
        diceBreakerQuestions.add("If you were stranded on a desert island," +
                                    " what three things would you want to take with you?");
        diceBreakerQuestions.add("If you could eat only one food for the rest of your life," +
                                    " what would that be?");
        diceBreakerQuestions.add("If you won a million dollars, " +
                                    "what is the first thing you would buy?");
        diceBreakerQuestions.add("If you could spend the day with one fictional character," +
                                    " who would it be?");
        diceBreakerQuestions.add("If you found a magic lantern and a genie gave you three wishes," +
                                    " what would you wish?");
    }
    private void addQuestion() {
        Intent intent = new Intent(this, AddQuestion.class);
        startActivityForResult(intent, 1);
    }
         @Override
        protected void onActivityResult (int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode,resultCode,data);
            if(requestCode == 1 && resultCode == RESULT_OK) {
                diceBreakerQuestions.add(data.getStringExtra("new_question"));
        }
    }
}
