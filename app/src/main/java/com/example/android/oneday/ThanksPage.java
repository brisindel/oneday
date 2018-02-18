package com.example.android.oneday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThanksPage extends AppCompatActivity {

    //variables
    private TextView solution;
    public EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks_page);

        //Set salutation and text in first line below Vltava image
        String solution1 = getResources().getString(R.string.cipher);
        TextView solution = findViewById(R.id.solutionTextView);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("USER_NAME");
        solution.setText(userName + " " + solution1);

        //Finish game, get back on start
        final Button button = findViewById(R.id.resetBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}