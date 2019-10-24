package com.example.d_icebreakers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int diceNum;
    private String[] diceBreakerQuestion;
    private TextView diceNumLabel;
    private TextView diceBreakerQuestionLabel;
    private Button dicerollButton = findViewById(R.id.diceRollButton);
    private Button dicebreakerButton = findViewById(R.id.diceBreakerButton);

    public MainActivity() {
        diceNumLabel = findViewById(R.id.diceNum);
        diceBreakerQuestionLabel = findViewById(R.id.dicebreaker_question);
        diceNum = 0;
        diceBreakerQuestion = new String[6];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dicerollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll_dice();
                String dicenum_string = String.valueOf(diceNum);
                diceNumLabel.setText(dicenum_string);
            }
        });
    }

    private void roll_dice() {
        Random randomDice = new Random();
        diceNum = randomDice.nextInt(6+1);
    }
}
