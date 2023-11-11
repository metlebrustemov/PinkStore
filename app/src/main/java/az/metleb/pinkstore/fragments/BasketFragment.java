package az.metleb.pinkstore.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import az.metleb.pinkstore.R;
import az.metleb.pinkstore.adapters.BasketAdapter;
import az.metleb.pinkstore.backends.ProductsBackend;

public class BasketFragment extends Fragment {

    ProductsBackend productsBackend = ProductsBackend.getInstance();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_basket, container, false);
        ListView basketList = v.findViewById(R.id.basket_list);
        BasketAdapter basketAdapter = new BasketAdapter(getContext(), R.layout.basket_list_item, productsBackend.getBasket());
        basketList.setAdapter(basketAdapter);
        return v;
    }
}