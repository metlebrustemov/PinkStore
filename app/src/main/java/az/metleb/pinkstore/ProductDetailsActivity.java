package az.metleb.pinkstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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