package com.example.dummy;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class notes extends Fragment {

    public static final String TITLE = "title";
    private ArrayList<Notes> notesArrayList;
    private  String[] notesTitle;
    private  String[] notesDescription;
    private RecyclerView recyclerViewNotes;
    private FloatingActionButton btn;

    public notes(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //dataInitialize();
        btn = view.findViewById(R.id.note_add_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),AddNodeActivity.class));
            }
        });
        recyclerViewNotes = view.findViewById(R.id.recyclerViewNotes);
    //  recyclerViewNotes.setLayoutManager(new LinearLayoutManager(getContext()));
    //  recyclerViewNotes.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerViewNotes.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerViewNotes.setHasFixedSize(true);
        RVAdapter notesAdapter = new RVAdapter(getContext(),DataBase.notesList);
        recyclerViewNotes.setAdapter(notesAdapter);
        notesAdapter.notifyDataSetChanged();
    }

//    private void dataInitialize() {
//        notesArrayList = new ArrayList<>();
//
//        notesTitle = new String[]{
//                getString(R.string.h1),
//                getString(R.string.h2),
//                getString(R.string.h3),
//                getString(R.string.h4),
//                getString(R.string.h5),
//                getString(R.string.h6),
//                getString(R.string.h7),
//                getString(R.string.h8),
//                getString(R.string.h9),
//                getString(R.string.h10)
//        };
//
//        notesDescription = new String[]{
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
//        for(int i = 0; i<notesTitle.length;i++){
//            Notes note = new Notes(notesTitle[i],notesDescription[i]);
//            notesArrayList.add(note);
//        }
//    }
}