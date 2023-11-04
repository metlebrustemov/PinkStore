package az.metleb.pinkstore.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

import az.metleb.pinkstore.models.ProductModel;

public class BasketAdapter extends ArrayAdapter<ProductModel> {
    List<ProductModel> products;
    int resource;
    public BasketAdapter(@NonNull Context context, int resource, @NonNull List<ProductModel> objects) {
        super(context, resource, objects);
        this.products = objects;
        this.resource = resource;
    }
}
