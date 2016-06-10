package com.example.hrutvik.schoolpersonalizeapp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    public double kWeight;
    public double cWeight;
    public double aWeight;
    public double tWeight;

    private TextView mTextViewOverallAverage;


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


        // Bundle extras = getIntent().getExtras();
        // if (extras != null) {
        // }

        // mTextViewOverallAverage.setText(getIntent().getExtras().getString("tWeight"));
        //  mTextViewOverallAverage.setText(getIntent().getExtras().getString("cWeight"));
        //   mTextViewOverallAverage.setText(getIntent().getExtras().getString("aWeight"));


        mBtnCalculateWeightedAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            /*double e1,e2,e3,e4;
            Intent receiveIntent = this.getIntent();
            e1 = intent.getDoubleExtra("doubleValue_e1", defaultValue)
            e2 = intent.getDoubleExtra("doubleValue_e2", defaultValue)
            e3 = intent.getDoubleExtra("doubleValue_e3", defaultValue)
            e4 = intent.getDoubleExtra("doubleValue_e4", defaultValue)*/


                double kWeight= getIntent().getDoubleExtra("kWeight",30);  //key name , defualt value
                double cWeight= getIntent().getDoubleExtra("cWeight",20);
                double tWeight= getIntent().getDoubleExtra("tWeight",20);
                double aWeight= getIntent().getDoubleExtra("aWeight",30);

                //  if(TextUtils.isEmpty(mEditTextA.getText().toString())){
                //      mEditTextA.setError("fill in categories before continuing");
                // }


                kMark = Double.parseDouble((mEditTextK.getText().toString())) * kWeight*0.01;
                cMark = Double.parseDouble((mEditTextC.getText().toString())) * cWeight*0.01;
                aMark = Double.parseDouble((mEditTextA.getText().toString())) * aWeight*0.01;
                tMark = Double.parseDouble((mEditTextT.getText().toString())) * tWeight*0.01;

                totalMarks = kMark + cMark + aMark + tMark;

                mTextViewOverallAverage.setText(String.valueOf(totalMarks));

            }

        });




        //if(mEditTextA.getText().toString().matches("") ){
        //    Toast.makeText(this, "Enter marks before continuing", Toast.LENGTH_LONG).show();
        //}



        mBtnResetMarks.setOnClickListener(new View.OnClickListener() {
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
