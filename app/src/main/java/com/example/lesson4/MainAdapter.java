package com.example.lesson4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    ArrayList<Students> data = new ArrayList<>();


    public void addElement(Students students) {
        data.add(students);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_holder_main, parent, false);
        MainViewHolder mainViewHolder = new MainViewHolder(view);

        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
