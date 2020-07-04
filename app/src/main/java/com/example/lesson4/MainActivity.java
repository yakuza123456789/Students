package com.example.lesson4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int ADD_ACTIVITY = 500;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

            adapter = new MainAdapter();

            recyclerView.setAdapter(adapter);

    }

    public void onAddElement(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivityForResult(intent, ADD_ACTIVITY);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_ACTIVITY && resultCode == RESULT_OK){
            Students students = (Students) data.getSerializableExtra("students");
            Log.d("olol", " " + students.surname + " " + students.name);
            adapter.addElement(students);
        }
    }
}

