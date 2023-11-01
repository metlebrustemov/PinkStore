package az.metleb.pinkstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import az.metleb.pinkstore.backends.ProductsBackend;
import az.metleb.pinkstore.databinding.ActivityProductDetailsBinding;
import az.metleb.pinkstore.models.ProductModel;

public class ProductDetailsActivity extends AppCompatActivity implements View.OnClickListener {
ActivityProductDetailsBinding binding;
int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        id = getIntent().getIntExtra("ID", 0);
        ProductModel pm = ProductsBackend.getInstance().getItemsList().get(id);
        binding.productName.setText(pm.getText());
        binding.productPrice.setText(String.format("%.2f $", pm.getPrice()));
        List<ProductModel> likeThis = ProductsBackend.getInstance().getLikeThis(id);

        binding.imageViewL1.setImageResource(likeThis.get(0).getImageId());
        binding.imageViewL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                i.putExtra("ID", likeThis.get(0).getId());
                startActivity(i);
                finish();
            }
        });
        binding.imageViewL2.setImageResource(likeThis.get(1).getImageId());
        binding.imageViewL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                i.putExtra("ID", likeThis.get(1).getId());
                startActivity(i);
                finish();
            }
        });
        binding.imageViewL3.setImageResource(likeThis.get(2).getImageId());
        binding.imageViewL3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                i.putExtra("ID", likeThis.get(2).getId());
                startActivity(i);
                finish();
            }
        });
        binding.imageViewL4.setImageResource(likeThis.get(3).getImageId());
        binding.imageViewL4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                i.putExtra("ID", likeThis.get(3).getId());
                startActivity(i);
                finish();
            }
        });

        binding.productBigInmage.setImageResource(pm.getAllImages()[0]);
        binding.imageViewP1.setImageResource(pm.getAllImages()[0]);
        binding.imageViewP1.setTag(pm.getAllImages()[0]);
        binding.imageViewP1.setOnClickListener(this);
        binding.imageViewP2.setImageResource(pm.getAllImages()[1]);
        binding.imageViewP2.setTag(pm.getAllImages()[1]);
        binding.imageViewP2.setOnClickListener(this);
        binding.imageViewP3.setImageResource(pm.getAllImages()[2]);
        binding.imageViewP3.setTag(pm.getAllImages()[2]);
        binding.imageViewP3.setOnClickListener(this);
        binding.imageViewP4.setImageResource(pm.getAllImages()[3]);
        binding.imageViewP4.setTag(pm.getAllImages()[3]);
        binding.imageViewP4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        binding.productBigInmage.setImageResource((int)((ImageView)view).getTag());
    }
}