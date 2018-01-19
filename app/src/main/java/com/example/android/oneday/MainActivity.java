package com.example.android.oneday;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
//import android.widget.CheckBox.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //Variables corresponding to the views.
    private RadioGroup radioGroup;
    private RadioButton radio_question_1_ans_1, radio_question_1_ans_2, radio_question_1_ans_3, radio_question_1_ans_4;
    private RadioButton radio_question_2_ans_1, radio_question_2_ans_2, radio_question_2_ans_3, radio_question_2_ans_4;
    private RadioButton radio_question_3_ans_1, radio_question_3_ans_2, radio_question_3_ans_3, radio_question_3_ans_4;
    private RadioButton radio_question_4_ans_1, radio_question_4_ans_2, radio_question_4_ans_3, radio_question_4_ans_4;
    private RadioButton radio_question_5_ans_1, radio_question_5_ans_2, radio_question_5_ans_3, radio_question_5_ans_4;
    private CheckBox checkBox;
    private CheckBox chkBoxQ6Ans1, chkBoxQ6Ans2, chkBoxQ6Ans3, chkBoxQ6Ans4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Question 1 - Toast message which answer is correct (4th answer is correct)
         */

        radioGroup = (RadioGroup) findViewById(R.id.radioQuestion_1);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.radio_question_1_ans_4) {

                    Toast.makeText(getApplicationContext(), "Ano, to je správně, protože... Získáváš písmeno do tajenky. Pokračuj k dalšímu místu.",
                            Toast.LENGTH_SHORT).show();

                } else if (checkedId == R.id.radio_question_1_ans_1) {

                    Toast.makeText(getApplicationContext(), "Bohužel, zkus na tomto místě objevit další indicie, které Ti mohou odhalit správnou odpověd.",
                            Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), "Bohužel, zkus na tomto místě objevit další indicie, které Ti mohou odhalit správnou odpověd.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });



    /**
     * Question 2 - Toast message which answer is correct (1st answer is correct)
     */

    radioGroup = (RadioGroup) findViewById(R.id.radioQuestion_2);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {


        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            // find which radio button is selected

            if (checkedId == R.id.radio_question_2_ans_1) {

                Toast.makeText(getApplicationContext(), "Ano, to je správně, protože... Získáváš písmeno do tajenky. Pokračuj k dalšímu místu.",
                        Toast.LENGTH_SHORT).show();

            } else if (checkedId == R.id.radio_question_2_ans_2) {

                Toast.makeText(getApplicationContext(), "Bohužel, zkus na tomto místě objevit další indicie, které Ti mohou odhalit správnou odpověd.",
                        Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(getApplicationContext(), "Bohužel, zkus na tomto místě objevit další indicie, které Ti mohou odhalit správnou odpověd.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    });

        /**
         * Question 3 - Toast message which answer is correct (3rd answer is correct)
         */

        radioGroup = (RadioGroup) findViewById(R.id.radioQuestion_3);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.radio_question_3_ans_3) {

                    Toast.makeText(getApplicationContext(), "Ano, to je správně, protože... Získáváš písmeno do tajenky. Pokračuj k dalšímu místu.",
                            Toast.LENGTH_SHORT).show();

                } else if (checkedId == R.id.radio_question_3_ans_1) {

                    Toast.makeText(getApplicationContext(), "Bohužel, zkus na tomto místě objevit další indicie, které Ti mohou odhalit správnou odpověd.",
                            Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), "Bohužel, zkus na tomto místě objevit další indicie, které Ti mohou odhalit správnou odpověd.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        /**
         * Question 4 - Toast message which answer is correct (first answer is correct)
         */

        radioGroup = (RadioGroup) findViewById(R.id.radioQuestion_4);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.radio_question_4_ans_1) {

                    Toast.makeText(getApplicationContext(), "Ano, to je správně, protože... Získáváš písmeno do tajenky. Pokračuj k dalšímu místu.",
                            Toast.LENGTH_SHORT).show();

                } else if (checkedId == R.id.radio_question_4_ans_2) {

                    Toast.makeText(getApplicationContext(), "Bohužel, zkus na tomto místě objevit další indicie, které Ti mohou odhalit správnou odpověd.",
                            Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), "Bohužel, zkus na tomto místě objevit další indicie, které Ti mohou odhalit správnou odpověd.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        /**
         * Question 5 - Toast message which answer is correct (2nd answer is correct)
         */

        radioGroup = (RadioGroup) findViewById(R.id.radioQuestion_5);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.radio_question_5_ans_2) {

                    Toast.makeText(getApplicationContext(), "Ano, to je správně, protože... Získáváš písmeno do tajenky. Pokračuj k dalšímu místu.",
                            Toast.LENGTH_SHORT).show();

                } else if (checkedId == R.id.radio_question_5_ans_1) {

                    Toast.makeText(getApplicationContext(), "Bohužel, zkus na tomto místě objevit další indicie, které Ti mohou odhalit správnou odpověd.",
                            Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), "Bohužel, zkus na tomto místě objevit další indicie, které Ti mohou odhalit správnou odpověd.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });















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
