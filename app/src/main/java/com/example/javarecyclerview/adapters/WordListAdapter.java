package com.example.javarecyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javarecyclerview.databinding.WordlistItemBinding;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final Context context;
    private final List<String> items;

    public WordListAdapter(Context context, List<String> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WordlistItemBinding b = WordlistItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new WordViewHolder(b, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String word = items.get(position);
        holder.b.word.setText(word);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        WordListAdapter adapter;
        WordlistItemBinding b;

        public WordViewHolder(@NonNull WordlistItemBinding b, WordListAdapter adapter) {
            super(b.getRoot());
            this.adapter = adapter;
            this.b = b;

            b.word.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String element = items.get(position);
            items.set(position, "Clicked! " + element);
            adapter.notifyItemChanged(position);
        }

    }

}
