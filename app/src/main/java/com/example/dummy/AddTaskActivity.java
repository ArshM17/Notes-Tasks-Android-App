package com.example.dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        EditText taskInput = findViewById(R.id.task_input);
        MaterialButton saveBtn2 = findViewById(R.id.save_task_button);
        TextView t_title = findViewById(R.id.t_title);

        int pos = getIntent().getIntExtra("position", -1);

        if(pos != -1){
            taskInput.setText(DataBase.taskList.get(pos).task.toString());
            t_title.setText("Edit Task");
        }

        saveBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = new Task(taskInput.getText().toString(), false);
                if(pos == -1){
                    DataBase.taskList.add(0,task);
                    PrefConfig.saveTaskArrayList(getApplicationContext(), DataBase.taskList);
                    Toast.makeText(AddTaskActivity.this, "Task Saved", Toast.LENGTH_SHORT).show();
                }else{
                    DataBase.taskList.get(pos).setTask(task.task);
                    PrefConfig.saveTaskArrayList(getApplicationContext(), DataBase.taskList);
                    Toast.makeText(AddTaskActivity.this, "Task Updated", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }
}