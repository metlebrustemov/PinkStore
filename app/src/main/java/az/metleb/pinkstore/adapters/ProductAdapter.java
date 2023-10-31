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

public class ProductAdapter extends ArrayAdapter {
    List<ProductModel> items_list;
    int custom_layout_id;


    public ProductAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        items_list = objects;
        custom_layout_id = resource;
    }
    @Override
    public int getCount() {
        return items_list.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            // getting reference to the main layout and initializing
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(custom_layout_id, null);
        }

        // initializing the imageview and textview and setting data
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView textView = v.findViewById(R.id.textView);

        // get the item using the  position param
        ProductModel item = items_list.get(position);

        imageView.setImageResource(item.getImageId());
        textView.setText(item.getText());
        return v;
    }
}
