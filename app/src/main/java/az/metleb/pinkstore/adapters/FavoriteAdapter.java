package az.metleb.pinkstore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import az.metleb.pinkstore.R;
import az.metleb.pinkstore.models.ProductModel;

public class FavoriteAdapter extends ArrayAdapter {
    List<ProductModel> favorites;
    int resuourceID;
    public FavoriteAdapter(@NonNull Context context, int resource, List<ProductModel> favorites) {
        super(context, resource);
        this.favorites = favorites;
        this.resuourceID = resource;
    }

    @Override
    public int getCount() {
        return this.favorites.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(this.resuourceID, null);
        }
        ProductModel pm = this.favorites.get(position);
        TextView textView = (TextView) v.findViewById(R.id.favorit_item_name);
        textView.setText(pm.getText());
        TextView textView1 =(TextView) v.findViewById(R.id.favorite_item_price);
        textView1.setText(String.format("%.2f $",pm.getPrice()));
        ImageView imageView = (ImageView) v.findViewById(R.id.favorite_item_image);
        imageView.setImageResource(pm.getImageId());
        ImageButton imageButton =  (ImageButton) v.findViewById(R.id.buttonFavoritdenSil);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pm.setFavorite(false);
                notifyDataSetChanged();
            }
        });
        return v;
    }
}
