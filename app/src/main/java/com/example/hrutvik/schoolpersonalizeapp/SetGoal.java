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


public class SetGoal extends Activity {
    Calendar calendar = Calendar.getInstance();
    int day, month, Year;
    public Button saveButton, saveButton2, saveButton3, saveButton4, saveButton5;
    public SharedPreferences savedText1, savedText2, savedText3, savedText4, savedText5;
    public EditText editGoal, editGoal2, editGoal3, editGoal4, editGoal5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.goal_set);

        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton2 = (Button) findViewById(R.id.saveButton2);
        saveButton3 = (Button) findViewById(R.id.saveButton3);
        saveButton4 = (Button) findViewById(R.id.saveButton4);

        editGoal = (EditText) findViewById(R.id.setGoal);
        editGoal2 = (EditText) findViewById(R.id.setGoal2);
        editGoal3 = (EditText) findViewById(R.id.setGoal3);
        editGoal4 = (EditText) findViewById(R.id.setGoal4);

        savedText1 = getSharedPreferences("notes1", MODE_PRIVATE);
        savedText2 = getSharedPreferences("notes2", MODE_PRIVATE);
        savedText3 = getSharedPreferences("notes3", MODE_PRIVATE);
        savedText4 = getSharedPreferences("notes4", MODE_PRIVATE);
        savedText5 = getSharedPreferences("notes5", MODE_PRIVATE);

        editGoal.setText(savedText1.getString("tag1", ""));
        editGoal2.setText(savedText2.getString("tag2", ""));
        editGoal3.setText(savedText3.getString("tag3", ""));
        editGoal4.setText(savedText4.getString("tag4", ""));
        editGoal5.setText(savedText5.getString("tag5", ""));

        saveButton.setOnClickListener(saveButtonListener1);
        saveButton2.setOnClickListener(saveButtonListener2);
        saveButton3.setOnClickListener(saveButtonListener3);
        saveButton4.setOnClickListener(saveButtonListener4);
        saveButton5.setOnClickListener(saveButtonListener5);

        Button changeDate = (Button) findViewById(R.id.date);
        Button changeDate2 = (Button) findViewById(R.id.date2);
        Button changeDate3 = (Button) findViewById(R.id.date3);
        Button changeDate4 = (Button) findViewById(R.id.date4);

        changeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                new TimePickerDialog(SetGoal.this, onTimeSetListener1, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
                new DatePickerDialog(SetGoal.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        changeDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                new TimePickerDialog(SetGoal.this, onTimeSetListener2, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
                new DatePickerDialog(SetGoal.this, date2, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        changeDate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                new TimePickerDialog(SetGoal.this, onTimeSetListener3, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
                new DatePickerDialog(SetGoal.this, date3, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        changeDate4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                new TimePickerDialog(SetGoal.this, onTimeSetListener4, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
                new DatePickerDialog(SetGoal.this, date4, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void makeTag1(String tag1) {
        String or = savedText1.getString(tag1, null);
        SharedPreferences.Editor preferencesEditor = savedText1.edit();
        preferencesEditor.putString("tag1", tag1);
        preferencesEditor.commit();
    }

    private void makeTag2(String tag2) {
        String or = savedText2.getString(tag2, null);
        SharedPreferences.Editor preferencesEditor = savedText2.edit();
        preferencesEditor.putString("tag2", tag2);
        preferencesEditor.commit();
    }

    private void makeTag3(String tag3) {
        String or = savedText3.getString(tag3, null);
        SharedPreferences.Editor preferencesEditor = savedText3.edit();
        preferencesEditor.putString("tag3", tag3);
        preferencesEditor.commit();
    }

    private void makeTag4(String tag4) {
        String or = savedText4.getString(tag4, null);
        SharedPreferences.Editor preferencesEditor = savedText4.edit();
        preferencesEditor.putString("tag4", tag4);
        preferencesEditor.commit();
    }

    private void makeTag5(String tag5) {
        String or = savedText5.getString(tag5, null);
        SharedPreferences.Editor preferencesEditor = savedText5.edit();
        preferencesEditor.putString("tag5", tag5);
        preferencesEditor.commit();
    }

    public View.OnClickListener saveButtonListener1 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (editGoal.getText().length() > 0) {
                makeTag1(editGoal.getText().toString());

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editGoal.getWindowToken(), 0);

            }
        }
    };
    public View.OnClickListener saveButtonListener2 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (editGoal2.getText().length() > 0) {
                makeTag2(editGoal2.getText().toString());

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editGoal2.getWindowToken(), 0);

            }
        }
    };
    public View.OnClickListener saveButtonListener3 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (editGoal3.getText().length() > 0) {
                makeTag3(editGoal3.getText().toString());

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editGoal3.getWindowToken(), 0);

            }
        }
    };
    public View.OnClickListener saveButtonListener4 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (editGoal4.getText().length() > 0) {
                makeTag4(editGoal4.getText().toString());

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editGoal4.getWindowToken(), 0);

            }
        }
    };
    public View.OnClickListener saveButtonListener5 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (editGoal5.getText().length() > 0) {
                makeTag5(editGoal5.getText().toString());

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editGoal5.getWindowToken(), 0);

            }
        }
    };

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            day = dayOfMonth;
            month = monthOfYear + 1;
            Year = year;
            Toast.makeText(SetGoal.this, "Reminder set at : " + dayOfMonth + "/" + month + "/" + Year, Toast.LENGTH_SHORT).show();
        }
    };

    DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            day = dayOfMonth;
            month = monthOfYear + 1;
            Year = year;
            Toast.makeText(SetGoal.this, "Reminder set at : " + dayOfMonth + "/" + month + "/" + Year, Toast.LENGTH_SHORT).show();
        }
    };
    DatePickerDialog.OnDateSetListener date3 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            day = dayOfMonth;
            month = monthOfYear + 1;
            Year = year;
            Toast.makeText(SetGoal.this, "Reminder set at : " + dayOfMonth + "/" + month + "/" + Year, Toast.LENGTH_SHORT).show();
        }
    };
    DatePickerDialog.OnDateSetListener date4 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            day = dayOfMonth;
            month = monthOfYear + 1;
            Year = year;
            Toast.makeText(SetGoal.this, "Reminder set at : " + dayOfMonth + "/" + month + "/" + Year, Toast.LENGTH_SHORT).show();
        }
    };
    DatePickerDialog.OnDateSetListener date5 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            day = dayOfMonth;
            month = monthOfYear + 1;
            Year = year;
            Toast.makeText(SetGoal.this, "Reminder set at : " + dayOfMonth + "/" + month + "/" + Year, Toast.LENGTH_SHORT).show();
        }
    };
    TimePickerDialog.OnTimeSetListener onTimeSetListener1 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(SetGoal.this, "Time Reminder set at: " + hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();
        }
    };
    TimePickerDialog.OnTimeSetListener onTimeSetListener2 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(SetGoal.this, "Time Reminder set at: " + hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();
        }
    };
    TimePickerDialog.OnTimeSetListener onTimeSetListener3 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(SetGoal.this, "Time Reminder set at: " + hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();
        }
    };
    TimePickerDialog.OnTimeSetListener onTimeSetListener4 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(SetGoal.this, "Time Reminder set at: " + hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();
        }
    };
    TimePickerDialog.OnTimeSetListener onTimeSetListener5 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(SetGoal.this, "Time Reminder set at: " + hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();
        }
    };

}