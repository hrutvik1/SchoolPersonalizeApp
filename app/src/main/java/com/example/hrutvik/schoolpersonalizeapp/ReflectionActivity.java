package com.example.hrutvik.schoolpersonalizeapp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReflectionActivity extends Activity {
    private EditText mEditTextDesiredMark;
    private EditText mEditTextCurrentMark;
    private EditText mEditTextTestWorth;
    private TextView mTextViewMarkNeeded;
    private TextView mTextViewMsg;
    private Button mBtnCalculateMarkNeeded;

    double markNeeded;
    double testWorth;
    double currentMark;
    double desiredMark;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ReflectionActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_reflection);

        mEditTextDesiredMark = (EditText) findViewById(R.id.editTextDesiredMark);
        mEditTextCurrentMark = (EditText) findViewById(R.id.editTextCurrentMark);
        mEditTextTestWorth = (EditText) findViewById(R.id.editTextTestWorth);
        mTextViewMarkNeeded = (TextView) findViewById(R.id.textViewMarkNeeded);
        mBtnCalculateMarkNeeded = (Button) findViewById(R.id.btnCalculateMarkNeeded);
        mTextViewMsg = (TextView) findViewById(R.id.textViewMsg);

        mBtnCalculateMarkNeeded.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                currentMark = Double.parseDouble(mEditTextCurrentMark.getText().toString())/100;
                testWorth= Double.parseDouble(mEditTextTestWorth.getText().toString())/100;
                desiredMark= Double.parseDouble(mEditTextDesiredMark.getText().toString())/100;

                markNeeded= (1*desiredMark-(1-testWorth)*currentMark)/testWorth*100;

                mTextViewMarkNeeded.setText(((Double) markNeeded).toString() + "%");


                if(markNeeded<80) {
                    mTextViewMsg.setText("YOU'LL GET IT EASILY!");
                }
                if(markNeeded>80 && markNeeded<90){
                    mTextViewMsg.setText("YOU GOT THIS!");
                }
                if(markNeeded>90 && markNeeded<100){
                    mTextViewMsg.setText("YOU BETTER START OPENING UP YOUR BOOKS, GOOD LUCK!");
                }
                if(markNeeded>100){
                    mTextViewMsg.setText("HARD LUCK, THIS IS IMPOSSIBLE, LET'S JUST HOPE YOUR TEST HAS BONUSES!");
                }

            }
        });

    }
}
