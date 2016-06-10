package com.example.hrutvik.schoolpersonalizeapp;

import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * This activity class is the title screen.
 * It contains 4 buttons which each launch a different activity.
 */
public class TitleActivity extends Activity {

    public Button mbtnManageMarksAct;
    public Button mbtnSetGoalAct;
    public Button mbtnSettingsAct;
    public Button mbtnReflectionAct;

    /**
     * This method opens the ManageMarks activity
     */
    public void openManageMarksAct(){

        mbtnManageMarksAct= (Button) findViewById(R.id.btnManageMarksAct);

        mbtnManageMarksAct.setOnClickListener(new View.OnClickListener() {
            /**
             * This method is done when the user clicks the weighted average calculator button
             * @param view
             */
            public void onClick(View view){
                Intent ManageMarksIntent = new Intent(TitleActivity.this,ManageMarks.class);
                startActivity(ManageMarksIntent);
            }
        });
    }

    /**
     * This method opens the SetGoal activity
     */
    public void openSetGoalAct(){
        mbtnSetGoalAct= (Button) findViewById(R.id.btnSetGoalAct);

        mbtnSetGoalAct.setOnClickListener(new View.OnClickListener() {
            /**
             * This method is done when the user clicks the set goals with reminders button
             * @param view
             */
            public void onClick(View view){
                Intent SetGoalIntent  = new Intent(TitleActivity.this,SetGoal.class);
                startActivity(SetGoalIntent);
            }
        });
    }

    /**
     * This method opens the SettingsActivity
     */
    public void openSettingsAct(){
        mbtnSettingsAct= (Button) findViewById(R.id.btnSettingsAct);

        mbtnSettingsAct.setOnClickListener(new View.OnClickListener() {
            /**
             * This method is done when the user clicks the change weight of categories button
             * @param view
             */
            public void onClick(View view){
                Intent SettingsIntent  = new Intent(TitleActivity.this,SettingsActivity.class);
                startActivity(SettingsIntent);
            }
        });
    }

    /**
     * This method opens the ReflectionActivity
     */
    public void openReflectionAct(){
        mbtnReflectionAct= (Button) findViewById(R.id.btnReflectionAct);

        mbtnReflectionAct.setOnClickListener(new View.OnClickListener() {
            /**
             * This method is done when the user clicks the mark reflection button
             * @param view
             */
            public void onClick(View view){
                Intent ReflectionIntent  = new Intent(TitleActivity.this,ReflectionActivity.class);
                startActivity(ReflectionIntent);
            }
        });
    }

    /**
     * This is an auto generated method by android studio
     * It is made as the app gets created
     * @param savedInstanceState
     */
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
