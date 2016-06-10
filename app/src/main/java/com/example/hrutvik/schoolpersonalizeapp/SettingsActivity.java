package com.example.hrutvik.schoolpersonalizeapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;


public class SettingsActivity extends Activity {

    private EditText mEditTextKWeight;
    private EditText mEditTextTWeight;
    private EditText mEditTextCWeight;
    private EditText mEditTextAWeight;
    private ImageButton mBtnChangeWeight;

    double kWeight;
    double tWeight;
    double cWeight;
    double aWeight;

    public Marks marks= new Marks();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SettingsActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_settings);


        mEditTextKWeight= (EditText) findViewById(R.id.editTextKWeight) ;
        mEditTextTWeight= (EditText) findViewById(R.id.editTextTWeight) ;
        mEditTextCWeight= (EditText) findViewById(R.id.editTextCWeight) ;
        mEditTextAWeight= (EditText) findViewById(R.id.editTextAWeight) ;
        mBtnChangeWeight= (ImageButton) findViewById(R.id.btnChangeWeight) ;


        mBtnChangeWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kWeight = Double.parseDouble(mEditTextKWeight.getText().toString());
                tWeight = Double.parseDouble(mEditTextTWeight.getText().toString());
                cWeight = Double.parseDouble(mEditTextCWeight.getText().toString());
                aWeight = Double.parseDouble(mEditTextAWeight.getText().toString());

                marks.setApplication(aWeight);
                marks.setCommunication(cWeight);
                marks.setKnowledge(kWeight);
                marks.setThinking(tWeight);

                Intent weights=new Intent(SettingsActivity.this, ManageMarks.class);
                weights.putExtra("kWeight",marks.getKnowledge());
                weights.putExtra("cWeight",marks.getCommunication());
                weights.putExtra("tWeight",marks.getThinking());
                weights.putExtra("aWeight",marks.getApplication());

                startActivity(weights);

            }
        });
    }
}

