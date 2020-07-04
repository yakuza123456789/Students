package com.example.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class AddActivity extends AppCompatActivity {

    String surname;
    String name;
    String group;

    Date year;

    TextView dateTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        EditText surnameET = findViewById(R.id.et_add_surname);
        EditText nameET = findViewById(R.id.et_add_name);
        EditText groupET = findViewById(R.id.et_add_group);

        dateTV = findViewById(R.id.tv_add_year);

        surnameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                surname = s.toString();
            }
        });

        nameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                name = s.toString();
            }
        });

        groupET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                group = s.toString();
            }
        });

        Button chooseDate = findViewById(R.id.btn_add_year);
        chooseDate.setOnClickListener(new View.OnClickListener() {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Log.d("ololo", "year: " + year + "month: "+ (month + 1) + "day: "+dayOfMonth);
                        dateTV.setText(dayOfMonth + "." + (month + 1) + "."+ year);
                        AddActivity.this.year = new Date(year, month, dayOfMonth);

                    }
                }, year, month, day);
                dialog.show();
            }
        });

        final Button save = findViewById(R.id.btn_add_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Students students = new Students();
                students.surname = surname;
                students.name = name;
                students.group = group;
                students.year = year;

                Intent intent = new Intent();
                intent.putExtra("students", students);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }

}
