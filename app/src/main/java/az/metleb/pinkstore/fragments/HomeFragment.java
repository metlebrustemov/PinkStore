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
import az.metleb.pinkstore.backends.ProductsBackend;
import az.metleb.pinkstore.models.ProductModel;

public class HomeFragment extends Fragment {

    ProductsBackend productsBackend;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        productsBackend = ProductsBackend.getInstance();
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        GridView gridView = rootView.findViewById(R.id.productsGrid);
        ProductAdapter customAdapter = new ProductAdapter(getContext(), R.layout.item_view, productsBackend.getItemsList());
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ProductDetailsActivity.class);
                intent.putExtra("ID", i);
                startActivity(intent);
            }
        });
        return  rootView;
    }
}