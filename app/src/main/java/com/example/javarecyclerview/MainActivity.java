package com.example.javarecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.javarecyclerview.adapters.WordListAdapter;
import com.example.javarecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    WordListAdapter adapter;
    List<String> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createList();
        setupAdapter();
        setupFAB();

    }

    private void setupFAB() {
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                words.add("+ Word: " + words.size());
                adapter.notifyItemChanged(words.size() - 1);
                binding.recyclerView.smoothScrollToPosition(words.size() - 1);
            }
        });
    }

    void createList() {
        words = new ArrayList<>();
        for(int i = 0;i < 20; i++) {
            words.add("Word: " + i);
        }
    }

    void setupAdapter() {
        adapter = new WordListAdapter(MainActivity.this, words);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

}
