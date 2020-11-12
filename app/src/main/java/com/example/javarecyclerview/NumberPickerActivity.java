package com.example.javarecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.javarecyclerview.databinding.ActivityNumberPickerBinding;

import java.util.ArrayList;
import java.util.List;

public class NumberPickerActivity extends AppCompatActivity {

    ActivityNumberPickerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNumberPickerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        setupListView();

    }

    public void showDialog(View view) {
        if (binding.etMinQty.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Enter MinQty!", Toast.LENGTH_SHORT).show();
        } else {
            new WeightPicker().show(NumberPickerActivity.this, binding.etMinQty.getText().toString().trim(), new WeightPicker.OnWeightPickedListener() {
                @Override
                public void onWeightPicked(int kg, int g) {
                    Toast.makeText(NumberPickerActivity.this, kg + "kg" + " " + g * 50 + "g", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onWeightPickerCancelled() {
                    Toast.makeText(NumberPickerActivity.this, "Cancel Clicked!", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.btn_button1:
//                Toast.makeText(this, "Button 1 Pressed!", Toast.LENGTH_LONG).show();
//                break;
//
//            case R.id.btn_button2:
//                Toast.makeText(this, "Button 2 Pressed!", Toast.LENGTH_LONG).show();
//                break;
//
//            case R.id.btn_button3:
//                Toast.makeText(this, "Button 3 Pressed!", Toast.LENGTH_LONG).show();
//                break;
//
//            default:
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void setupListView() {
//        List<String> list = new ArrayList<>();
//        for(int i = 1; i<=50; i++) {
//            list.add("Word : " + i);
//        }
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
//        binding.listView.setAdapter(adapter);
//        // Register the ListView  for Context menu
//        registerForContextMenu(binding.listView);
//    }
//
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        menu.setHeaderTitle("Pick One");
//    }
//
//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.btn_button1:
//                Toast.makeText(this, "Button 1 Pressed! of Contextual Menu", Toast.LENGTH_LONG).show();
//                return true;
//
//            case R.id.btn_button2:
//                Toast.makeText(this, "Button 2 Pressed! of Contextual Menu", Toast.LENGTH_LONG).show();
//                return true;
//
//            case R.id.btn_button3:
//                Toast.makeText(this, "Button 3 Pressed! of Contextual Menu", Toast.LENGTH_LONG).show();
//                return true;
//
////            default:
////                return true;
//        }
//        return super.onContextItemSelected(item);
//    }

}
