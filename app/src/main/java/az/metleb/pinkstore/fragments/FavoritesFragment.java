package az.metleb.pinkstore.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import az.metleb.pinkstore.R;
import az.metleb.pinkstore.adapters.FavoriteAdapter;
import az.metleb.pinkstore.backends.ProductsBackend;


public class FavoritesFragment extends Fragment {
ProductsBackend productsBackend = ProductsBackend.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_favorites, container, false);
        FavoriteAdapter favoriteAdapter = new FavoriteAdapter(getContext(), R.layout.favorite_list_item, productsBackend.getFavorites());
        ListView listView = (ListView) view.findViewById(R.id.favoritesList);
        listView.setAdapter(favoriteAdapter);
        return  view;
    }
}