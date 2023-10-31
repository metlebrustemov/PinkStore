package az.metleb.pinkstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import az.metleb.pinkstore.databinding.ActivityMainBinding;
import az.metleb.pinkstore.fragments.BasketFragment;
import az.metleb.pinkstore.fragments.FavoritesFragment;
import az.metleb.pinkstore.fragments.HomeFragment;
import az.metleb.pinkstore.fragments.NotificationFragment;
import az.metleb.pinkstore.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment( new HomeFragment());
                    break;
                case R.id.basket:
                    replaceFragment(new BasketFragment());
                    break;
                case R.id.notifications:
                    replaceFragment(new NotificationFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.centerButton);
        fab.setColorFilter(getResources().getColor(R.color.pink));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new FavoritesFragment());
            }
        });

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}