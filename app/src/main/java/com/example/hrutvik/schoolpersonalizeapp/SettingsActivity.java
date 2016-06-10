package com.example.hrutvik.schoolpersonalizeapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * This class is used to allow the user to change the weight of each category
 * This activity can be called by clicking the assigned button on the main activity screen.
 */
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

    public Marks marks= new Marks(); //overloading constructor

    /**
     * This is an auto generated method by android studio
     * It is made as the app gets created
     * @param savedInstanceState
     */
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
            /**
             * This method is done when the user clicks the change weight button
             * The ManageMark activity is opened once this button is clicked
             * The weight of each category is changed according to the users input
             * using intent objects we relay the changes to the ManageMarks activity
             * @param view
             */
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

