package com.example.dummy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.NotesViewHolder> {

    Context context;
    ArrayList<Notes> notesArrayList;

    public RVAdapter(Context context, ArrayList<Notes> notesArrayList) {
        this.context = context;
        this.notesArrayList = notesArrayList;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.note_item,parent,false);

        return new NotesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Notes notes = notesArrayList.get(holder.getAdapterPosition());
        holder.title.setText(notes.title);
        holder.description.setText(notes.description);
        holder.itemView.setOnClickListener((v)->{
            Intent intent = new Intent(context,AddNodeActivity.class);
            intent.putExtra("position", holder.getAdapterPosition());
            context.startActivity(intent);
            notifyDataSetChanged();
        });

        holder.itemView.setOnLongClickListener((v)->{
            new AlertDialog.Builder(context).setTitle("Delete this note?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    DataBase.notesList.remove(holder.getAdapterPosition());
                    PrefConfig.saveNotesArrayList(context, DataBase.notesList);
                    notifyDataSetChanged();
                }
            }).setNegativeButton("No", null).show();
            return true;
        });

    }

    @Override
    public int getItemCount() {
        return notesArrayList.size();
    }

    public static class NotesViewHolder extends RecyclerView.ViewHolder{

        TextView title, description;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.note_title);
            description = itemView.findViewById(R.id.note_description);
        }
    }
}
