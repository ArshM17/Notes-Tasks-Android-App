package com.example.dummy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
        Task tasks = taskArrayList.get(holder.getAdapterPosition());
        holder.text.setText(tasks.task);
//        holder.task.setChecked(tasks.isDone);

//        System.out.println(tasks.isDone);
        holder.itemView.setOnClickListener((v)->{
            Intent intent = new Intent(context,AddTaskActivity.class);
            intent.putExtra("position", holder.getAdapterPosition());
            context.startActivity(intent);
            notifyDataSetChanged();
        });

        holder.itemView.setOnLongClickListener((v)->{
            new AlertDialog.Builder(context).setTitle("Delete this task?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    DataBase.taskList.remove(holder.getAdapterPosition());
                    PrefConfig.saveTaskArrayList(context, DataBase.taskList);
                    notifyDataSetChanged();
                }
            }).setNegativeButton("No", null).show();
            return true;
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
