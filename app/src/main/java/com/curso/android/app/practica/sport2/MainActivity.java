package com.curso.android.app.practica.sport2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 1- AdapterView: RecyclerView
    RecyclerView recyclerView;

    // 2- Data Source
    List<Sport> sports = new ArrayList<>();

    // 3- Adapter
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize recyclerView
        recyclerView = findViewById(R.id.recyclerView);

        // Populate ArrayList
        sports.add(new Sport("Football", R.drawable.football));
        sports.add(new Sport("Basketball", R.drawable.basketball));
        sports.add(new Sport("Tennis", R.drawable.tennis));
        sports.add(new Sport("Volleyball", R.drawable.volley));
        sports.add(new Sport("Ping Pong", R.drawable.ping));

        // Initialize adapter
        adapter = new MyAdapter(sports);

        // Set adapter
        recyclerView.setAdapter(adapter);

        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
}