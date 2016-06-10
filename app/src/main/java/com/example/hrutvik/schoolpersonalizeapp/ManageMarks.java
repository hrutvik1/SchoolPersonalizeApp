package com.example.hrutvik.schoolpersonalizeapp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This activity class is launched upon applying changes to the SettingActivity class or through the title screen.
 * If the user chooses not to change anything and directly opens this activity through the title screen,
 * default values for the category weights are used (knowledge-30, thinking-20, communication-20, application-30).
 * This activity obtains marks per category from the user and computes a weighted average using
 * the weights of each category
 */
public class ManageMarks extends Activity {

    private Button mBtnCalculateWeightedAverage;

    private Button mBtnResetMarks;

    private EditText mEditTextK;
    private EditText mEditTextT;
    private EditText mEditTextC;
    private EditText mEditTextA;
    double totalMarks;
    double kMark;
    double cMark;
    double aMark;
    double tMark;

    private TextView mTextViewOverallAverage;

    /**
     * This is an auto generated method by android studio
     * It is made as the app gets created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ManageMarks.this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.marks_manage);

        //casting widgets
        mBtnCalculateWeightedAverage= (Button) findViewById(R.id.btnCalculateWeightedAverage);

        mBtnResetMarks= (Button) findViewById(R.id.btnResetMarks);

        mEditTextK= (EditText) findViewById(R.id.editTextK) ;
        mEditTextT= (EditText) findViewById(R.id.editTextT);
        mEditTextC= (EditText) findViewById(R.id.editTextC);
        mEditTextA= (EditText) findViewById(R.id.editTextA);

        mTextViewOverallAverage= (TextView) findViewById(R.id.textViewOverallAverage);

        mBtnCalculateWeightedAverage.setOnClickListener(new View.OnClickListener() {
            /**
             * This method is done when the user clicks the calculate weight button
             * This method parses the editTexts and applies the category weights to determine a weighted average
             * @param view
             */
            @Override
            public void onClick(View view) {

                double kWeight= getIntent().getDoubleExtra("kWeight",30);  //key name , defualt value
                double cWeight= getIntent().getDoubleExtra("cWeight",20);
                double tWeight= getIntent().getDoubleExtra("tWeight",20);
                double aWeight= getIntent().getDoubleExtra("aWeight",30);

                kMark = Double.parseDouble((mEditTextK.getText().toString())) * kWeight*0.01;
                cMark = Double.parseDouble((mEditTextC.getText().toString())) * cWeight*0.01;
                aMark = Double.parseDouble((mEditTextA.getText().toString())) * aWeight*0.01;
                tMark = Double.parseDouble((mEditTextT.getText().toString())) * tWeight*0.01;

                totalMarks = kMark + cMark + aMark + tMark;

                mTextViewOverallAverage.setText(String.valueOf(totalMarks));
            }
        });

        mBtnResetMarks.setOnClickListener(new View.OnClickListener() {
            /**
             * This method is done when the user clicks the reset marks button
             * This method resets the marks on the editText
             * @param view
             */
            @Override
            public void onClick(View view) {
                mEditTextK.setText("");
                mEditTextC.setText("");
                mEditTextA.setText("");
                mEditTextT.setText("");
            }
        });
    }
}
