package com.example.hrutvik.schoolpersonalizeapp;

import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class TitleActivity extends Activity {

    public Button mbtnManageMarksAct;
    public Button mbtnSetGoalAct;
    public Button mbtnSettingsAct;
    public Button mbtnReflectionAct;

    public void openManageMarksAct(){
        mbtnManageMarksAct= (Button) findViewById(R.id.btnManageMarksAct);

        mbtnManageMarksAct.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){

                Intent ManageMarksIntent = new Intent(TitleActivity.this,ManageMarks.class);
                startActivity(ManageMarksIntent);
            }
        });
    }
    public void openSetGoalAct(){
        mbtnSetGoalAct= (Button) findViewById(R.id.btnSetGoalAct);

        mbtnSetGoalAct.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){

                Intent SetGoalIntent  = new Intent(TitleActivity.this,SetGoal.class);
                startActivity(SetGoalIntent);
            }
        });
    }

    public void openSettingsAct(){
        mbtnSettingsAct= (Button) findViewById(R.id.btnSettingsAct);

        mbtnSettingsAct.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){

                Intent SettingsIntent  = new Intent(TitleActivity.this,SettingsActivity.class);
                startActivity(SettingsIntent);
            }
        });
    }
    public void openReflectionAct(){
        mbtnReflectionAct= (Button) findViewById(R.id.btnReflectionAct);

        mbtnReflectionAct.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){

                Intent ReflectionIntent  = new Intent(TitleActivity.this,ReflectionActivity.class);
                startActivity(ReflectionIntent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        TitleActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_title);

        openManageMarksAct();
        openSetGoalAct();
        openSettingsAct();
        openReflectionAct();
    }
}
