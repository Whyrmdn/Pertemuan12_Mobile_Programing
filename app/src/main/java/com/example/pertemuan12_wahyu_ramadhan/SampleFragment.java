package com.example.pertemuan12_wahyu_ramadhan;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class SampleFragment extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // Bind the TextView
        View view = null;
        textView = view.findViewById(R.id.textView);

        // Set listeners for buttons
        view.findViewById(R.id.buttonAlert).setOnClickListener(v -> showAlertDialog());
        view.findViewById(R.id.buttonDatePicker).setOnClickListener(v -> showDatePicker());
        view.findViewById(R.id.buttonTimePicker).setOnClickListener(v -> showTimePicker());

        return view;
    }

    // Method for Alert Dialog
    private void showAlertDialog() {
        // Similar to your previous code
    }

    // Method for Date Picker
    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), (datePicker, selectedYear, selectedMonth, selectedDay) -> {
            String dateMessage = (selectedMonth + 1) + "/" + selectedDay + "/" + selectedYear;
            Toast.makeText(getActivity(), "Selected Date: " + dateMessage, Toast.LENGTH_SHORT).show();
            textView.setText("Selected Date: " + dateMessage);
        }, year, month, day);

        datePickerDialog.show();
    }

    // Method for Time Picker
    private void showTimePicker() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), (timePicker, selectedHour, selectedMinute) -> {
            String timeMessage = selectedHour + ":" + String.format("%02d", selectedMinute);
            Toast.makeText(getActivity(), "Selected Time: " + timeMessage, Toast.LENGTH_SHORT).show();
            textView.setText("Selected Time: " + timeMessage);
        }, hour, minute, true);

        timePickerDialog.show();
    }
}
