package com.example.dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class AddNodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_node);

        EditText titleInput = findViewById(R.id.title_input);
        EditText descriptionInput = findViewById(R.id.description_input);
        MaterialButton saveBtn = findViewById(R.id.save_note_button);
        TextView n_title = findViewById(R.id.n_title);
        int pos = getIntent().getIntExtra("position", -1);

        if(pos != -1){
            titleInput.setText(DataBase.notesList.get(pos).title.toString());
            descriptionInput.setText(DataBase.notesList.get(pos).description.toString());
            n_title.setText("Edit Note");
        }

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notes note = new Notes(titleInput.getText().toString(), descriptionInput.getText().toString());
                if(pos == -1){
                    DataBase.notesList.add(0,note);
                    PrefConfig.saveNotesArrayList(getApplicationContext(), DataBase.notesList);
                    Toast.makeText(AddNodeActivity.this, "Note Saved", Toast.LENGTH_SHORT).show();
                }else{
                    DataBase.notesList.get(pos).setTitle(note.title);
                    DataBase.notesList.get(pos).setDescription(note.description);
                    PrefConfig.saveNotesArrayList(getApplicationContext(), DataBase.notesList);
                    Toast.makeText(AddNodeActivity.this, "Note Updated", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }
}