package com.example.javarecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.javarecyclerview.databinding.ActivityCatalogBinding;
import com.example.javarecyclerview.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogActivity extends AppCompatActivity {

    private ActivityCatalogBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityCatalogBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

//        setupProductList();
//
//        setupAdapter();

    }

    private void setupAdapter() {

    }

    private void setupProductList() {
        // Create DataSet
        List<Product> products = new ArrayList<>(
                Arrays.asList(
                        new Product("Apple", 10),
                        new Product("Banana", 20),
                        new Product("Mango", 30),
                        new Product("Orange", 40),
                        new Product("Strawberry", 50)
                )
        );

        // Create adapter object
        ProductsAdapter adapter = new ProductsAdapter(CatalogActivity.this, products);

        // Set the adapter and LayoutManager to RecyclerView
        b.productList.setAdapter(adapter);
        b.productList.setLayoutManager(new LinearLayoutManager(CatalogActivity.this));

    }

}
