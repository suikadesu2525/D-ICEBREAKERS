package com.example.d_icebreakers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        Button saveButton = findViewById(R.id.saveButton);
        Button cancelButton = findViewById(R.id.cancelButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveQuestion();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity(2);
            }
        });
    }

    private void saveQuestion() {
        EditText questionBox = findViewById(R.id.newQuestion);
        TextView alertText = (findViewById(R.id.displayBox));
        if (questionBox.getText().toString().isEmpty()) {
            alertText.setText(R.string.emptyquestion_text);
        }
        else {
            Intent question = new Intent();
            question.putExtra("new_question", questionBox.getText().toString());
            setResult(Activity.RESULT_OK, question);
            finishActivity(1);
            finish();
        }
    }
}
