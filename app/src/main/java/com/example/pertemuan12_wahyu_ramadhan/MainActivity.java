package com.example.pertemuan12_wahyu_ramadhan;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    // Method to load a fragment


    // Other methods for Alert Dialog, DatePicker, and TimePicker
    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);

        myAlertBuilder.setTitle(R.string.alert_title);
        myAlertBuilder.setMessage(R.string.alert_message);

        myAlertBuilder.setPositiveButton(R.string.ok_button, (dialog, which) ->
                Toast.makeText(getApplicationContext(), R.string.pressed_ok, Toast.LENGTH_SHORT).show());

        myAlertBuilder.setNegativeButton(R.string.cancel_button, (dialog, which) ->
                Toast.makeText(getApplicationContext(), R.string.pressed_cancel, Toast.LENGTH_SHORT).show());

        myAlertBuilder.show();
    }

    public void showDatePicker(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (datePicker, selectedYear, selectedMonth, selectedDay) -> {
            String dateMessage = (selectedMonth + 1) + "/" + selectedDay + "/" + selectedYear;
            Toast.makeText(MainActivity.this, getString(R.string.selected_date) + dateMessage, Toast.LENGTH_SHORT).show();
            textView.setText(getString(R.string.selected_date) + dateMessage);
        }, year, month, day);

        datePickerDialog.show();
    }

    public void showTimePicker(View view) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, (timePicker, selectedHour, selectedMinute) -> {
            String timeMessage = selectedHour + ":" + String.format("%02d", selectedMinute);
            Toast.makeText(MainActivity.this, getString(R.string.selected_time) + timeMessage, Toast.LENGTH_SHORT).show();
            textView.setText(getString(R.string.selected_time) + timeMessage);
        }, hour, minute, true);

        timePickerDialog.show();
    }
}
