package com.example.hrutvik.schoolpersonalizeapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * This class is created to set goals. The purpose of this class is to let the user set goals with reminders
 * The only flaw in this class, is actually receiving notifications from set reminders.
 * The user is given four EditText fields, in which they can decide to add a goal.
 */
public class SetGoal extends Activity {
    /**
     * Calender object is used to produce calender related fields. This is used so date/time can be implemented
     * Declare Buttons, SharedPreferences, EditText
     */
    Calendar calendar = Calendar.getInstance();
    int day, month, Year;
    public Button saveButton, saveButton2, saveButton3, saveButton4;
    public SharedPreferences savedText1, savedText2, savedText3, savedText4;
    public EditText editGoal, editGoal2, editGoal3, editGoal4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.goal_set);
        /**
         * Initializing the buttons for saving the goals
         */
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton2 = (Button) findViewById(R.id.saveButton2);
        saveButton3 = (Button) findViewById(R.id.saveButton3);
        saveButton4 = (Button) findViewById(R.id.saveButton4);

        /**
         * Initializing EditText for editing goals
         */
        editGoal = (EditText) findViewById(R.id.setGoal);
        editGoal2 = (EditText) findViewById(R.id.setGoal2);
        editGoal3 = (EditText) findViewById(R.id.setGoal3);
        editGoal4 = (EditText) findViewById(R.id.setGoal4);

        /**
         * Initializing SharedPreferences so that the data entered in the EditText can be saved
         */
        savedText1 = getSharedPreferences("text1", MODE_PRIVATE);
        savedText2 = getSharedPreferences("text2", MODE_PRIVATE);
        savedText3 = getSharedPreferences("text3", MODE_PRIVATE);
        savedText4 = getSharedPreferences("text4", MODE_PRIVATE);

        /**
         *Setting a default value for the EditText, when the app is opened.
         */
        editGoal.setText(savedText1.getString("newgoal1", ""));
        editGoal2.setText(savedText2.getString("newgoal2", ""));
        editGoal3.setText(savedText3.getString("newgoal3", ""));
        editGoal4.setText(savedText4.getString("newgoal4", ""));

        Button changeDate = (Button) findViewById(R.id.date);
        Button changeDate2 = (Button) findViewById(R.id.date2);
        Button changeDate3 = (Button) findViewById(R.id.date3);
        Button changeDate4 = (Button) findViewById(R.id.date4);

        /**
         * Declare event handler for 4 buttons that save the EditText
         */
        saveButton.setOnClickListener(saveButtonListener1);
        saveButton2.setOnClickListener(saveButtonListener2);
        saveButton3.setOnClickListener(saveButtonListener3);
        saveButton4.setOnClickListener(saveButtonListener4);

        /**
         * Creates a Time picker and a date picker dialog once the reminder button is clicked.
         * Allows the user to select a date and time as a reminder for their goal.
         */
        changeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                new TimePickerDialog(SetGoal.this, onTimeSetListener1, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
                new DatePickerDialog(SetGoal.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        /**
         * Creates a Time picker and a date picker dialog once the reminder button is clicked.
         * Allows the user to select a date and time as a reminder for their goal.
         */
        changeDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                new TimePickerDialog(SetGoal.this, onTimeSetListener2, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
                new DatePickerDialog(SetGoal.this, date2, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        /**
         * Creates a Time picker and a date picker dialog once the reminder button is clicked.
         * Allows the user to select a date and time as a reminder for their goal.
         */
        changeDate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                new TimePickerDialog(SetGoal.this, onTimeSetListener3, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
                new DatePickerDialog(SetGoal.this, date3, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        /**
         * Creates a Time picker and a date picker dialog once the reminder button is clicked.
         * Allows the user to select a date and time as a reminder for their goal.
         */
        changeDate4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                new TimePickerDialog(SetGoal.this, onTimeSetListener4, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
                new DatePickerDialog(SetGoal.this, date4, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    /**
     * Allows the user to save the text in EditText. This task is performed by using SharedPreferences
     *
     * @param newGoal
     */
    private void savedChanges1(String newGoal) {
        String save = savedText1.getString(newGoal, null);
        SharedPreferences.Editor preferencesEditor = savedText1.edit();
        preferencesEditor.putString("newgoal1", newGoal);
        preferencesEditor.apply();
    }

    /**
     * Allows the user to save the text in EditText. This task is performed by using SharedPreferences
     *
     * @param newGoal2
     */
    private void savedChanges2(String newGoal2) {
        String save = savedText2.getString(newGoal2, null);
        SharedPreferences.Editor preferencesEditor = savedText2.edit();
        preferencesEditor.putString("newgoal2", newGoal2);
        preferencesEditor.apply();
    }

    /**
     * Allows the user to save the text in EditText. This task is performed by using SharedPreferences
     *
     * @param newGoal3
     */
    private void savedChanges3(String newGoal3) {
        String save = savedText3.getString(newGoal3, null);
        SharedPreferences.Editor preferencesEditor = savedText3.edit();
        preferencesEditor.putString("newgoal3", newGoal3);
        preferencesEditor.apply();
    }

    /**
     * Allows the user to save the text in EditText. This task is performed by using SharedPreferences
     *
     * @param newGoal4
     */
    private void savedChanges4(String newGoal4) {
        String save = savedText4.getString(newGoal4, null);
        SharedPreferences.Editor preferencesEditor = savedText4.edit();
        preferencesEditor.putString("newgoal4", newGoal4);
        preferencesEditor.apply();
    }

    /**
     * On click method for allowing the user to save the text in EditText
     */
    public View.OnClickListener saveButtonListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (editGoal.getText().length() > 0) {
                savedChanges1(editGoal.getText().toString());
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editGoal.getWindowToken(), 0);
            }
        }
    };
    /**
     * On click method for allowing the user to save the text in EditText
     */
    public View.OnClickListener saveButtonListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (editGoal2.getText().length() > 0) {
                savedChanges2(editGoal2.getText().toString());
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editGoal2.getWindowToken(), 0);
            }
        }
    };
    /**
     * On click method for allowing the user to save the text in EditText
     */
    public View.OnClickListener saveButtonListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (editGoal3.getText().length() > 0) {
                savedChanges3(editGoal3.getText().toString());
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editGoal3.getWindowToken(), 0);
            }
        }
    };
    /**
     * On click method for allowing the user to save the text in EditText
     */
    public View.OnClickListener saveButtonListener4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (editGoal4.getText().length() > 0) {
                savedChanges4(editGoal4.getText().toString());
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editGoal4.getWindowToken(), 0);
            }
        }
    };

    /**
     * Implementation of date picker dialog
     * User sets the date for their reminder
     * Once the date is picked, it creates a toast, showing a certain date is picked.
     */
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            day = dayOfMonth;
            month = monthOfYear + 1;
            Year = year;
            Toast.makeText(SetGoal.this, "Reminder set at : " + dayOfMonth + "/" + month + "/" + Year, Toast.LENGTH_SHORT).show();
        }
    };
    /**
     * Implementation of date picker dialog
     * User sets the date for their reminder
     * Once the date is picked, it creates a toast, showing a certain date is picked.
     */
    DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            day = dayOfMonth;
            month = monthOfYear + 1;
            Year = year;
            Toast.makeText(SetGoal.this, "Reminder set at : " + dayOfMonth + "/" + month + "/" + Year, Toast.LENGTH_SHORT).show();
        }
    };
    /**
     * Implementation of date picker dialog
     * User sets the date for their reminder
     * Once the date is picked, it creates a toast, showing a certain date is picked.
     */
    DatePickerDialog.OnDateSetListener date3 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            day = dayOfMonth;
            month = monthOfYear + 1;
            Year = year;
            Toast.makeText(SetGoal.this, "Reminder set at : " + dayOfMonth + "/" + month + "/" + Year, Toast.LENGTH_SHORT).show();
        }
    };
    /**
     * Implementation of date picker dialog
     * User sets the date for their reminder
     * Once the date is picked, it creates a toast, showing a certain date is picked.
     */
    DatePickerDialog.OnDateSetListener date4 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            day = dayOfMonth;
            month = monthOfYear + 1;
            Year = year;
            Toast.makeText(SetGoal.this, "Reminder set at : " + dayOfMonth + "/" + month + "/" + Year, Toast.LENGTH_SHORT).show();
        }
    };
    /**
     * Implementation of the time picker dialog.
     * User sets the time for their reminder
     * Once the time is picked, a toast is created showing the time that was picked.
     */
    TimePickerDialog.OnTimeSetListener onTimeSetListener1 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(SetGoal.this, "Time Reminder set at: " + hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();
        }
    };
    /**
     * Implementation of the time picker dialog.
     * User sets the time for their reminder
     * Once the time is picked, a toast is created showing the time that was picked.
     */
    TimePickerDialog.OnTimeSetListener onTimeSetListener2 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(SetGoal.this, "Time Reminder set at: " + hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();
        }
    };
    /**
     * Implementation of the time picker dialog.
     * User sets the time for their reminder
     * Once the time is picked, a toast is created showing the time that was picked.
     */
    TimePickerDialog.OnTimeSetListener onTimeSetListener3 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(SetGoal.this, "Time Reminder set at: " + hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();
        }
    };
    /**
     * Implementation of the time picker dialog.
     * User sets the time for their reminder
     * Once the time is picked, a toast is created showing the time that was picked.
     */
    TimePickerDialog.OnTimeSetListener onTimeSetListener4 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(SetGoal.this, "Time Reminder set at: " + hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();
        }
    };

}