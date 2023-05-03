package com.example.dummy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter2 extends RecyclerView.Adapter<RVAdapter2.TaskViewHolder> {

    Context context;
    ArrayList<Task> taskArrayList;

    public RVAdapter2(Context context, ArrayList<Task> taskArrayList) {
        this.context = context;
        this.taskArrayList = taskArrayList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.task_item,parent,false);

        return new TaskViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task tasks = taskArrayList.get(position);
        holder.text.setText(tasks.task);

        holder.itemView.setOnClickListener((v)->{
            Intent intent = new Intent(context,AddTaskActivity.class);
            intent.putExtra("position", position);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return taskArrayList.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder{

        CheckBox task;
        TextView text;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            task = itemView.findViewById(R.id.task);
            text = itemView.findViewById(R.id.t_text);
        }
    }
}
