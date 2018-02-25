package com.example.android.oneday;

import android.app.AlertDialog;
import android.app.MediaRouteButton;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Variables corresponding to the views.
    private RadioGroup radioGroup;
    private RadioButton radioQ1Ans4;
    private RadioButton radioQ2Ans1;
    private RadioButton radioQ4Ans1;
    private RadioButton radioQ5Ans2;
    private CheckBox chkBoxQ6Ans1, chkBoxQ6Ans2, chkBoxQ6Ans3, chkBoxQ6Ans4;
    private boolean gameStarted;
    private boolean letters;
    private List<Boolean> executedList = new ArrayList<>();
    private List<TextView> letterList = new ArrayList<>();
    public EditText userName;
    public EditText noPillars;
    private int progressStatus = 1;
    private TextView textProgress;
    private Resources resources;
    int scoreAll = 0;
    int scoreTrue = 0;

    //Localisation of quiz places
    private static final double VACLAVAK_LAT = 50.0797778;
    private static final double VACLAVAK_LONG = 14.4297314;
    private static final double STAROMAK_LAT = 50.0869922;
    private static final double STAROMAK_LONG = 14.4207228;
    private static final double KARLUV_MOST_LAT = 50.0865831;
    private static final double KARLUV_MOST_LONG = 14.4102561;
    private static final double HRAD_LAT = 50.0898689;
    private static final double HRAD_LONG = 14.4000936;
    private static final double KAMPA_LAT = 50.0862247;
    private static final double KAMPA_LONG = 14.4067961;
    private static final double SLAVIA_LAT = 50.0815244;
    private static final double SLAVIA_LONG = 14.4134222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resources = getResources();

        letterList.add((TextView) findViewById(R.id.letter1));
        letterList.add((TextView) findViewById(R.id.letter2));
        letterList.add((TextView) findViewById(R.id.letter3));
        letterList.add((TextView) findViewById(R.id.letter4));
        letterList.add((TextView) findViewById(R.id.letter5));
        letterList.add((TextView) findViewById(R.id.letter6));

        executedList.add(false);
        executedList.add(false);
        executedList.add(false);
        executedList.add(false);
        executedList.add(false);
        executedList.add(false);

        userName = findViewById(R.id.user_name);
        gameStarted = false;
        letters = false;

        /**
         * If user set username in editText, cipher is set to default - "*****"
         */
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

                    for (TextView letter : letterList) {
                        letter.setText("*");
                        letter.setTextColor(getResources().getColor(R.color.colorGold));
                    }
                }
            }
        });

        /**
         * Places on map - VACLAVAK, STAROMAK, KARLŮV MOST, HRAD, KAMPA, SLAVIA
         */
        ImageView mapQ1 = findViewById(R.id.mapQ1);
        mapQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMap(v, VACLAVAK_LAT, VACLAVAK_LONG, R.string.question_1_place);
            }
        });
        ImageView mapQ2 = findViewById(R.id.mapQ2);
        mapQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMap(v, STAROMAK_LAT, STAROMAK_LONG, R.string.question_2_place);
            }
        });
        ImageView mapQ3 = findViewById(R.id.mapQ3);
        mapQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMap(v, KARLUV_MOST_LAT, KARLUV_MOST_LONG, R.string.question_3_place);
            }
        });
        ImageView mapQ4 = findViewById(R.id.mapQ4);
        mapQ4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMap(v, HRAD_LAT, HRAD_LONG, R.string.question_4_place);
            }
        });
        ImageView mapQ5 = findViewById(R.id.mapQ5);
        mapQ5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMap(v, KAMPA_LAT, KAMPA_LONG, R.string.question_5_place);
            }
        });
        ImageView mapQ6 = findViewById(R.id.mapQ6);
        mapQ6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMap(v, SLAVIA_LAT, SLAVIA_LONG, R.string.question_6_place);
            }
        });

        /**
         * Submit button - open Thanks Page and visualise "all number question attempt and correct attempt"
         */
        final Button submitBtn = findViewById(R.id.submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Are all answers true
                if (areAllAnswersCorrect()) {

                    // Dialog box
                    dialogBox();

                } else {
                    Toast.makeText(getApplicationContext(), (resources.getString(R.string.correct_no)),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        /**
         * Question 1 - Toast message which answer is correct (4th answer is correct)
         */
        radioGroup = findViewById(R.id.radioQuestion_1);
        radioQ1Ans4 = findViewById(R.id.radioQ1Ans4);
        textProgress = findViewById(R.id.textProgress);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // check if user fill his name and if not, set cipher to "*"
                startTheGame(letterList);

                // find which radio button is selected
                if (checkedId == R.id.radioQ1Ans4 && !executedList.get(0)) {

                    //Set textColor for true answer
                    radioQ1Ans4.setTextColor(getResources().getColor(R.color.colorGold));

                    //Toast message correct answer
                    showCorrectAnswToast();

                    //Set letter to cipher
                    letterList.get(1).setText("L");
                    letterList.get(1).setTextColor(getResources().getColor(R.color.colorCipher));

                    //Get progress count of finished questions
                    textProgress.setText(progressStatus++ + "/6");

                    // Mark the question as executed
                    executedList.set(0, true);

                } else

                {
                    // Toast message wrong answer
                    showFalseAnswToast();
                }
            }
        });

        /**
         * Question 2 - Toast message which answer is correct (1st answer is correct)
         */
        radioGroup = findViewById(R.id.radioQuestion_2);
        radioQ2Ans1 = findViewById(R.id.radioQ2Ans1);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // check if user fill his name and if not, set cipher to "*"
                startTheGame(letterList);

                // find which radio button is selected

                if (checkedId == R.id.radioQ2Ans1 && !executedList.get(1)) {

                    //Set textColor for true answer
                    radioQ2Ans1.setTextColor(getResources().getColor(R.color.colorGold));

                    //Toast message correct answer
                    showCorrectAnswToast();

                    //Set letter to cipher
                    letterList.get(4).setText("V");
                    letterList.get(4).setTextColor(getResources().getColor(R.color.colorCipher));

                    //Get progress count of finished questions
                    textProgress.setText(progressStatus++ + "/6");

                    // Mark the question as executed
                    executedList.set(1, true);

                } else {
                    // Toast message wrong answer
                    showFalseAnswToast();
                }
            }
        });

        /**
         * Question 3 - Toast message which answer is correct (correct 15)
         */

        noPillars = (EditText) findViewById(R.id.edt_pillars);

        noPillars.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!gameStarted) {
                    gameStarted = true;

                    for (TextView letter : letterList) {
                        letter.setText("*");
                        letter.setTextColor(getResources().getColor(R.color.colorGold));
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int pillarsNo = Integer.parseInt(noPillars.getText().toString());
                countPillars(pillarsNo);

            }
        });

        /**
         * Question 4 - Toast message which answer is correct (first answer is correct)
         */
        radioGroup = findViewById(R.id.radioQuestion_4);
        radioQ4Ans1 = findViewById(R.id.radioQ4Ans1);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // check if user fill his name and if not, set cipher to "*"
                startTheGame(letterList);

                // find which radio button is selected

                if (checkedId == R.id.radioQ4Ans1 && !executedList.get(3)) {
                    //Set textColor for true answer
                    radioQ4Ans1.setTextColor(getResources().getColor(R.color.colorGold));

                    //Toast message correct answer
                    showCorrectAnswToast();

                    //Set letter to cipher
                    letterList.get(5).setText("A");
                    letterList.get(5).setTextColor(getResources().getColor(R.color.colorCipher));

                    //Get progress count of finished questions
                    textProgress.setText(progressStatus++ + "/6");

                    // Mark the question as executed
                    executedList.set(3, true);

                } else {
                    //Toast message wrong answer
                    showFalseAnswToast();
                }
            }
        });

        /**
         * Question 5 - Toast message which answer is correct (2nd answer is correct)
         */
        radioGroup = findViewById(R.id.radioQuestion_5);
        radioQ5Ans2 = findViewById(R.id.radioQ5Ans2);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // check if user fill his name and if not, set cipher to "*"
                startTheGame(letterList);

                // find which radio button is selected
                if (checkedId == R.id.radioQ5Ans2 && !executedList.get(4)) {

                    //Set textColor for true answer
                    radioQ5Ans2.setTextColor(getResources().getColor(R.color.colorGold));

                    //Toast message correct answer
                    showCorrectAnswToast();

                    //Set letter to cipher
                    letterList.get(2).setText("T");
                    letterList.get(2).setTextColor(getResources().getColor(R.color.colorCipher));

                    //Get progress count of finished questions
                    textProgress.setText(progressStatus++ + "/6");

                    // Mark the question as executed
                    executedList.set(4, true);

                } else {
                    //Toast message wrong answer
                    showFalseAnswToast();
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

                // check if user fill his name and if not, set cipher to "*"
                startTheGame(letterList);

                // find which checkbox is selected

                if (chkBoxQ6Ans1.isChecked() && chkBoxQ6Ans2.isChecked() && chkBoxQ6Ans3.isChecked()
                        && !chkBoxQ6Ans4.isChecked() && !executedList.get(5)) {

                    //Set textColor for true answer
                    chkBoxQ6Ans1.setTextColor(getResources().getColor(R.color.colorGold));
                    chkBoxQ6Ans2.setTextColor(getResources().getColor(R.color.colorGold));
                    chkBoxQ6Ans3.setTextColor(getResources().getColor(R.color.colorGold));

                    //Toast message show correct answer
                    showCorrectAnswToast();

                    //Set letter to cipher
                    letterList.get(0).setText("V");
                    letterList.get(0).setTextColor(getResources().getColor(R.color.colorCipher));

                    //Get progress count of finished questions
                    textProgress.setText(progressStatus++ + "/6");

                    // Mark the question as executed
                    executedList.set(5, true);

                } else {

                    //Toast message wrong answer
                    showFalseAnswToast();
                }
            }
        };

        chkBoxQ6Ans1.setOnCheckedChangeListener(checkBoxListener);
        chkBoxQ6Ans2.setOnCheckedChangeListener(checkBoxListener);
        chkBoxQ6Ans3.setOnCheckedChangeListener(checkBoxListener);
        chkBoxQ6Ans4.setOnCheckedChangeListener(checkBoxListener);
    }

    /**
     * Already executed - do only one time
     */

    private boolean areAllAnswersCorrect() {
        for (Boolean check : executedList) {
            if (!check) {
                return false;
            }
        }
        return true;
    }

    /**
     * Show place on map
     */
    private void showMap(View view, double lat, double lon, int place) {
        String uri = buildUri(lat, lon, place);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String buildUri(double latitude, double longitude, int placeResource) {
        return String.format("geo:<%f>,<%f>?q=<%f>,<%f>(%s)", latitude, longitude, latitude, longitude, resources.getString(placeResource));
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

    /**
     * Save userName and open Thanks Page
     */
    public void openThanksPage() {
        EditText userName = findViewById(R.id.user_name);
        Intent intent = new Intent(this, ThanksPage.class);
        String name = userName.getText().toString();
        intent.putExtra("USER_NAME", name);
        startActivity(intent);
    }

    /**
     * If answer is correct, show Toast message.
     * Count +1 for number of attempt
     * Count +1 fot correct number
     */

    public void showCorrectAnswToast() {
        String userName1 = userName.getText().toString();
        Toast.makeText(getApplicationContext(), userName1 + " " + getResources().getString(R.string.true_answ),
                Toast.LENGTH_SHORT).show();

        //Add ++ to number of all attempt and ++ to right answered question
        ++scoreAll;
        ++scoreTrue;
    }

    /**
     * If answer is wrong, show Toast message.
     * Count +1 for number of attempt
     */

    private void showFalseAnswToast() {
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.false_answ),
                Toast.LENGTH_SHORT).show();

        //Add ++ to number of all attempt
        ++scoreAll;
    }

    /**
     * Initiation of the quiz
     */

    private void startTheGame(List<TextView> letterList) {
        if (!gameStarted) {
            gameStarted = true;

            //Toast information if user name missed
            Toast.makeText(getApplicationContext(), resources.getString(R.string.miss_user_name),
                    Toast.LENGTH_SHORT).show();

            //Set "*" on cipher
            for (TextView letter : letterList) {
                letter.setText("*");
                letter.setTextColor(getResources().getColor(R.color.colorGold));
            }
        }
    }

    /**
     * Question 3 - validation EditText input - correct is 15
     */

    public void countPillars(int pillarsNo) {

        // check correct answer 15 in EditText
        if (pillarsNo == 15 && !executedList.get(2)) {

            //Toast message correct answer
            showCorrectAnswToast();

            //Set letter to cipher
            letterList.get(3).setText("A");
            letterList.get(3).setTextColor(getResources().getColor(R.color.colorCipher));

            //Get progress count of finished questions
            textProgress.setText(progressStatus++ + "/6");

            // Mark the question as executed
            executedList.set(2, true);

            //Stop edit after correct answer
            noPillars.setEnabled(false);

        } else {
            // Toast message wrong answer
            showFalseAnswToast();
        }
    }

    public void dialogBox() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage((resources.getString(R.string.thanks_dialog) + "\n" + "\n" + (resources.getString(R.string.allAttempt)
                + " " + scoreAll + "\n" + (resources.getString(R.string.correctAttempt)) + " "
                + scoreTrue) + "\n" + "\n" + (resources.getString(R.string.dialog_next))));
        alertDialogBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        // Open Thanks page whit USER_NAME intent
                        openThanksPage();
                    }
                });

        alertDialogBuilder.setNegativeButton("cancel",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}