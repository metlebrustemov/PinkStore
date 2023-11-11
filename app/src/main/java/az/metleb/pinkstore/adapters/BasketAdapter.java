package az.metleb.pinkstore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import az.metleb.pinkstore.R;
import az.metleb.pinkstore.models.ProductModel;

public class BasketAdapter extends ArrayAdapter<ProductModel> {
    List<ProductModel> products;
    int resource;
    public BasketAdapter(@NonNull Context context, int resource, @NonNull List<ProductModel> objects) {
        super(context, resource, objects);
        this.products = objects;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            // getting reference to the main layout and initializing
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(this.resource, null);
        }
        TextView title = (TextView) v.findViewById(R.id.basket_name);
        title.setText(this.products.get(position).getText());
        TextView price = (TextView) v.findViewById(R.id.basket_price);
        price.setText(String.format("%f",this.products.get(position).getPrice()));
        ImageView image = (ImageView) v.findViewById(R.id.basket_image);
        image.setImageResource(this.products.get(position).getImageId());
        return v;
    }
}
