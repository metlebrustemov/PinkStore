package az.metleb.pinkstore.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import az.metleb.pinkstore.ProductDetailsActivity;
import az.metleb.pinkstore.R;
import az.metleb.pinkstore.adapters.ProductAdapter;
import az.metleb.pinkstore.models.ProductModel;

public class HomeFragment extends Fragment {

    List<ProductModel> itemsList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       if(itemsList.isEmpty()) {
           itemsList.add(new ProductModel(R.drawable.rose1, "Rose 1"));
           itemsList.add(new ProductModel(R.drawable.rose2, "Rose 2"));
           itemsList.add(new ProductModel(R.drawable.rose3, "Rose 3"));
           itemsList.add(new ProductModel(R.drawable.rose4, "Rose 4"));
           itemsList.add(new ProductModel(R.drawable.rose5, "Rose 5"));
           itemsList.add(new ProductModel(R.drawable.rose6, "Rose 6"));
           itemsList.add(new ProductModel(R.drawable.rose1, "Rose 7"));
           itemsList.add(new ProductModel(R.drawable.rose2, "Rose 8"));
           itemsList.add(new ProductModel(R.drawable.rose3, "Rose 9"));
           itemsList.add(new ProductModel(R.drawable.rose4, "Rose 10"));
           itemsList.add(new ProductModel(R.drawable.rose5, "Rose 11"));
           itemsList.add(new ProductModel(R.drawable.rose6, "Rose 12"));
       }
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        GridView gridView = rootView.findViewById(R.id.productsGrid);
        ProductAdapter customAdapter = new ProductAdapter(getContext(), R.layout.item_view, itemsList);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getContext(), ProductDetailsActivity.class));
            }
        });
        return  rootView;
    }
}