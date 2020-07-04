package com.example.lesson4;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainViewHolder extends RecyclerView.ViewHolder {

    TextView surnameTV;
    TextView nameTV;
    TextView groupTV;
    TextView yearTV;


    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        surnameTV = itemView.findViewById(R.id.tv_vh_surname);
        nameTV = itemView.findViewById(R.id.tv_vh_name);
        groupTV = itemView.findViewById(R.id.tv_vh_group);
        yearTV = itemView.findViewById(R.id.tv_vh_year);

    }

    public void onBind(Students students) {
        surnameTV.setText(students.surname);
        nameTV.setText(students.name);
        groupTV.setText(students.group);

        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
       yearTV.setText( format.format(students.year));
    }
}
