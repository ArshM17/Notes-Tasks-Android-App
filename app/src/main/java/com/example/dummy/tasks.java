package com.example.dummy;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class tasks extends Fragment {


    public static final String TITLE = "title";
    private ArrayList<Task> tasksArrayList;
    private  String[] taskName;
    private RecyclerView recyclerViewTasks;
    private FloatingActionButton btn;

    public tasks(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        dataInitialize();
        btn = view.findViewById(R.id.task_add_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),AddTaskActivity.class));
            }
        });
        recyclerViewTasks = view.findViewById(R.id.recyclerViewTasks);
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(getContext()));
//      recyclerViewTasks.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerViewTasks.setHasFixedSize(true);
        RVAdapter2 taskAdapter = new RVAdapter2(getContext(),DataBase.taskList);
        recyclerViewTasks.setAdapter(taskAdapter);
        taskAdapter.notifyDataSetChanged();
    }

//    private void dataInitialize() {
//        tasksArrayList = new ArrayList<>();
//
//        taskName = new String[]{
//                getString(R.string.d1),
//                getString(R.string.d2),
//                getString(R.string.d3),
//                getString(R.string.d4),
//                getString(R.string.d5),
//                getString(R.string.d6),
//                getString(R.string.d7),
//                getString(R.string.d8),
//                getString(R.string.d9),
//                getString(R.string.d10)
//        };
//
//        for(int i = 0; i<taskName.length;i++){
//            Task task = new Task(taskName[i]);
//            tasksArrayList.add(task);
//        }
//    }

}