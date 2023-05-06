package com.example.dummy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBase.taskList = PrefConfig.getTaskArrayList(this);
        DataBase.notesList = PrefConfig.getNotesArrayList(this);
        if(DataBase.notesList==null){
            DataBase.notesList = new ArrayList<>();
        }
        if(DataBase.taskList==null){
            DataBase.taskList = new ArrayList<>();
        }
        TabLayout tabLayout = findViewById(R.id.tablayout);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager);

        VPAdapter adapter = new VPAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2, (TabLayoutMediator.TabConfigurationStrategy) (tab, position) -> {
            if (position == 0) {
                tab.setText("Notes");
            }else{
                tab.setText("Tasks");
            }
        }).attach();

    }


}