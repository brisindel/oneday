package com.example.android.oneday;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
//import android.widget.ProgressBar;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {


    //Variables corresponding to the views.
    private RadioGroup radioGroup;
    private RadioButton radioQ1Ans1, radioQ1Ans2, radioQ1Ans3, radioQ1Ans4;
    private RadioButton radioQ2Ans1, radioQ2Ans2, radioQ2Ans3, radioQ2Ans4;
    private RadioButton radioQ3Ans1, radioQ3Ans2, radioQ3Ans3, radioQ3Ans4;
    private RadioButton radioQ4Ans1, radioQ4Ans2, radioQ4Ans3, radioQ4Ans4;
    private RadioButton radioQ5Ans1, radioQ5Ans2, radioQ5Ans3, radioQ5Ans4;
    private CheckBox chkBoxQ6Ans1, chkBoxQ6Ans2, chkBoxQ6Ans3, chkBoxQ6Ans4;
    private boolean gameStarted;
    private TextView letter1, letter2, letter3, letter4, letter5, letter6;
    private EditText userName;
    private ImageView mapQ1, mapQ2, mapQ3, mapQ4, mapQ5;
    private int progressStatus = 1;
    private TextView textProgress;
    //  private ProgressBar progressBar;
    // private Handler handler = new Handler();


    /**
     * If user set username in editText, cipher is set to default - "*****"
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        letter1 = findViewById(R.id.letter1);
        letter2 = findViewById(R.id.letter2);
        letter3 = findViewById(R.id.letter3);
        letter4 = findViewById(R.id.letter4);
        letter5 = findViewById(R.id.letter5);
        letter6 = findViewById(R.id.letter6);
        userName = findViewById(R.id.user_name);
        gameStarted = false;


        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!gameStarted) {
                    gameStarted = true;
                    letter1.setText("*");
                    letter1.setTextColor(getResources().getColor(R.color.colorGold));
                    letter2.setText("*");
                    letter2.setTextColor(getResources().getColor(R.color.colorGold));
                    letter3.setText("*");
                    letter3.setTextColor(getResources().getColor(R.color.colorGold));
                    letter4.setText("*");
                    letter4.setTextColor(getResources().getColor(R.color.colorGold));
                    letter5.setText("*");
                    letter5.setTextColor(getResources().getColor(R.color.colorGold));
                    letter6.setText("*");
                    letter6.setTextColor(getResources().getColor(R.color.colorGold));
                }
            }

        });


        /**
         * Question 1 - Toast message which answer is correct (4th answer is correct)
         */

        radioGroup = (RadioGroup) findViewById(R.id.radioQuestion_1);
        radioQ1Ans4 = (RadioButton) findViewById(R.id.radioQ1Ans4);
        textProgress = (TextView) findViewById(R.id.textProgress);
        //  progressBar = (ProgressBar) findViewById(R.id.progressBar);

        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.radioQ1Ans4) {

                    //Set textColor for true answer
                    radioQ1Ans4.setTextColor(getResources().getColor(R.color.colorGold));

                    //Toast information
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.true_answ),
                            Toast.LENGTH_SHORT).show();

                    //Set letter to cipher
                    letter2.setText("L");
                    letter2.setTextColor(getResources().getColor(R.color.colorCipher));

                    //Get progress count of finished questions
                    textProgress.setText(progressStatus++ + "/6");


                    /**
                     * Progressbar change on correct answer


                     new Thread(new Runnable() {
                    @Override public void run() {
                    while (progressStatus <= 0) {
                    handler.post(new Runnable() {
                    @Override public void run() {
                    progressBar.setProgress(progressStatus);
                    textProgress.setText(progressStatus + "/6");
                    }
                    });
                    progressStatus++;
                    }
                    }
                    }).start();
                     */


                } else if (checkedId == R.id.radioQ1Ans1) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.false_answ),
                            Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.false_answ),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        /**
         * Question 2 - Toast message which answer is correct (1st answer is correct)
         */

        radioGroup = (RadioGroup) findViewById(R.id.radioQuestion_2);
        radioQ2Ans1 = (RadioButton) findViewById(R.id.radioQ2Ans1);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.radioQ2Ans1) {

                    //Set textColor for true answer
                    radioQ2Ans1.setTextColor(getResources().getColor(R.color.colorGold));

                    //Toast information
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.true_answ),
                            Toast.LENGTH_SHORT).show();

                    //Set letter to cipher
                    letter5.setText("V");
                    letter5.setTextColor(getResources().getColor(R.color.colorCipher));

                    //Get progress count of finished questions
                    textProgress.setText(progressStatus++ + "/6");

                } else if (checkedId == R.id.radioQ2Ans2) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.false_answ),
                            Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.false_answ),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        /**
         * Question 3 - Toast message which answer is correct (3rd answer is correct)
         */

        radioGroup = (RadioGroup) findViewById(R.id.radioQuestion_3);
        radioQ3Ans3 = (RadioButton) findViewById(R.id.radioQ3Ans3);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.radioQ3Ans3) {
                    //Set textColor for true answer
                    radioQ3Ans3.setTextColor(getResources().getColor(R.color.colorGold));

                    //Toast information
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.true_answ),
                            Toast.LENGTH_SHORT).show();

                    //Set letter to cipher
                    letter4.setText("A");
                    letter4.setTextColor(getResources().getColor(R.color.colorCipher));

                    //Get progress count of finished questions
                    textProgress.setText(progressStatus++ + "/6");

                } else if (checkedId == R.id.radioQ3Ans1) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.false_answ),
                            Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.false_answ),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        /**
         * Question 4 - Toast message which answer is correct (first answer is correct)
         */

        radioGroup = (RadioGroup) findViewById(R.id.radioQuestion_4);
        radioQ4Ans1 = (RadioButton) findViewById(R.id.radioQ4Ans1);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.radioQ4Ans1) {
                    //Set textColor for true answer
                    radioQ4Ans1.setTextColor(getResources().getColor(R.color.colorGold));

                    //Toast information
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.true_answ),
                            Toast.LENGTH_SHORT).show();

                    //Set letter to cipher
                    letter6.setText("A");
                    letter6.setTextColor(getResources().getColor(R.color.colorCipher));

                    //Get progress count of finished questions
                    textProgress.setText(progressStatus++ + "/6");

                } else if (checkedId == R.id.radioQ4Ans2) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.false_answ),
                            Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.false_answ),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        /**
         * Question 5 - Toast message which answer is correct (2nd answer is correct)
         */

        radioGroup = (RadioGroup) findViewById(R.id.radioQuestion_5);
        radioQ5Ans2 = (RadioButton) findViewById(R.id.radioQ5Ans2);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.radioQ5Ans2) {

                    //Set textColor for true answer
                    radioQ5Ans2.setTextColor(getResources().getColor(R.color.colorGold));

                    //Toast information
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.true_answ),
                            Toast.LENGTH_SHORT).show();

                    //Set letter to cipher
                    letter3.setText("T");
                    letter3.setTextColor(getResources().getColor(R.color.colorCipher));

                    //Get progress count of finished questions
                    textProgress.setText(progressStatus++ + "/6");

                } else if (checkedId == R.id.radioQ5Ans2) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.false_answ),
                            Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.false_answ),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        /**
         * Question 6 - Toast message which answer is correct (first 3 answers are correct)
         */

        chkBoxQ6Ans1 = findViewById(R.id.chkBoxQ6Ans1);
        chkBoxQ6Ans2 = findViewById(R.id.chkBoxQ6Ans2);
        chkBoxQ6Ans3 = findViewById(R.id.chkBoxQ6Ans3);
        chkBoxQ6Ans4 = findViewById(R.id.chkBoxQ6Ans4);

        CompoundButton.OnCheckedChangeListener checkBoxListener = new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton button, boolean isChecked) {

                // find which checkbox is selected

                if (chkBoxQ6Ans1.isChecked() && (chkBoxQ6Ans2.isChecked() && chkBoxQ6Ans3.isChecked() && !chkBoxQ6Ans4.isChecked())) {

                    //Set textColor for true answer
                    chkBoxQ6Ans1.setTextColor(getResources().getColor(R.color.colorGold));
                    chkBoxQ6Ans2.setTextColor(getResources().getColor(R.color.colorGold));
                    chkBoxQ6Ans3.setTextColor(getResources().getColor(R.color.colorGold));

                    //Toast information
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.true_answ),
                            Toast.LENGTH_SHORT).show();

                    //Set letter to cipher
                    letter1.setText("V");
                    letter1.setTextColor(getResources().getColor(R.color.colorCipher));

                    //Get progress count of finished questions
                    textProgress.setText(progressStatus++ + "/6");

                } else {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.false_answ),
                            Toast.LENGTH_SHORT).show();
                }
            }
        };

        chkBoxQ6Ans1.setOnCheckedChangeListener(checkBoxListener);
        chkBoxQ6Ans2.setOnCheckedChangeListener(checkBoxListener);
        chkBoxQ6Ans3.setOnCheckedChangeListener(checkBoxListener);
        chkBoxQ6Ans4.setOnCheckedChangeListener(checkBoxListener);

    }

    /**
     * Show Dialog when game is finished
     */


    /**
     * ImageView question 1 map Intent Vaclavske namesti
     */

    public void showMapQ1(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:<" + 50.0797778 + ">,<" + 14.4297314 + ">?q=<" + 50.0797778 + ">,<" + 14.4297314 + ">(" + getResources().getString(R.string.question_1_place) + ")"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     * ImageView question 2 map Intent Staromestske namesti
     */

    public void showMapQ2(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:<" + 50.0869922 + ">,<" + 14.4207228 + ">?q=<" + 50.0869922 + ">,<" + 14.4207228 + ">(" + getResources().getString(R.string.question_2_place) + ")"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * ImageView question 3 map Intent Karluv most
     */

    public void showMapQ3(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:<" + 50.0865831 + ">,<" + 14.4102561 + ">?q=<" + 50.0865831 + ">,<" + 14.4102561 + ">(" + getResources().getString(R.string.question_3_place) + ")"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * ImageView question 4 map Intent Prazsky hrad
     */

    public void showMapQ4(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:<" + 50.0898689 + ">,<" + 14.4000936 + ">?q=<" + 50.0898689 + ">,<" + 14.4000936 + ">(" + getResources().getString(R.string.question_4_place) + ")"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * ImageView question 5 map Intent Kampa
     */

    public void showMapQ5(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:<" + 50.0862247 + ">,<" + 14.4067961 + ">?q=<" + 50.0862247 + ">,<" + 14.4067961 + ">(" + getResources().getString(R.string.question_5_place) + ")"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * ImageView question 6 map Intent Kavarna Slavia
     */

    public void showMapQ6(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:<" + 50.0815244 + ">,<" + 14.4134222 + ">?q=<" + 50.0815244 + ">,<" + 14.4134222 + ">(" + getResources().getString(R.string.question_6_place) + ")"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     * Hide soft keyboard after click outside EditText
     */

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

}
