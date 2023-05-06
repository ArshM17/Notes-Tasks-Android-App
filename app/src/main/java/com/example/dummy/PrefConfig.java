package com.example.dummy;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PrefConfig {

    public static final String TASK_ARRAYLIST_KEY = "task_key";
    public static final String NOTES_ARRAYLIST_KEY = "note_key";


    public static void saveTaskArrayList(Context context, ArrayList<Task> taskArraylist){
        Gson gson = new Gson();
        String jsonString = gson.toJson(taskArraylist);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(TASK_ARRAYLIST_KEY, jsonString);
        editor.apply();
    }

    public static ArrayList<Task> getTaskArrayList(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(TASK_ARRAYLIST_KEY,"");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Task>>(){}.getType();
        ArrayList<Task> taskArrayList = gson.fromJson(jsonString, type);
        return taskArrayList;
    }

    public static void saveNotesArrayList(Context context, ArrayList<Notes> notesArraylist){
        Gson gson = new Gson();
        String jsonString = gson.toJson(notesArraylist);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(NOTES_ARRAYLIST_KEY, jsonString);
        editor.apply();
    }

    public static ArrayList<Notes> getNotesArrayList(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(NOTES_ARRAYLIST_KEY,"");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Notes>>(){}.getType();
        ArrayList<Notes> notesArrayList = gson.fromJson(jsonString, type);
        return notesArrayList;
    }
}
