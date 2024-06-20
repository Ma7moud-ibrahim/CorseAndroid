package com.example.settingusedadapter;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.settingusedadapter.R;
import com.example.settingusedadapter.SettingItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> items = new ArrayList<>();
        items.add("Dark Mode");
        items.add("Language");
        items.add("Add User");
        items.add("Log Out");
        items.add("About");

        SettingItemAdapter adapter = new SettingItemAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }
}
