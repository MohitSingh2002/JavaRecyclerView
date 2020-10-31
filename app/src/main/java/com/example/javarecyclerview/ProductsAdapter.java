package com.example.javarecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javarecyclerview.databinding.ProductItemBinding;
import com.example.javarecyclerview.model.Product;

import java.util.List;

// Adapter for list of products
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    // Needed for inflating layout
    private Context context;

    // List of data
    private List<Product> productList;

    public ProductsAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    // Inflate the view for item and create a ViewHolder object
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 1. Inflate the layout for product_item.xml
        ProductItemBinding b = ProductItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
        );
        // 2. Create ViewHolder object and return
        return new ViewHolder(b);
    }

    // Binds the data to view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data at position
        Product product = productList.get(position);

        // Bind the data
        // Name and Price
        holder.b.name.setText(String.format("%s (Rs. %d)", product.name, product.price));

        // Quantity
        holder.b.quantity.setText(product.quantity + "");

        // DecrementButton and Quantity TV Visibility
        holder.b.decrementBtn.setVisibility(product.quantity > 0 ? View.VISIBLE : View.GONE);
        holder.b.quantity.setVisibility(product.quantity > 0 ? View.VISIBLE : View.GONE);

        // Configure increment button
        holder.b.incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.quantity++;
                notifyItemChanged(position);
            }
        });

        holder.b.decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.quantity--;
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    // Holds the view for each item
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ProductItemBinding b;

        public ViewHolder(@NonNull ProductItemBinding b) {
            super(b.getRoot());
            this.b = b;
        }
    }
}
