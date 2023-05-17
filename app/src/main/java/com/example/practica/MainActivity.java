package com.example.practica;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.practica.MainPage.Analys;
import com.example.practica.MainPage.Helps;
import com.example.practica.MainPage.Profile;
import com.example.practica.MainPage.Results;
import com.example.practica.R;
import com.example.practica.databinding.MainActivity;

public class MainActivity extends AppCompatActivity {

    MainActivity binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainActivity.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new Analys());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.analize:
                    replaceFragment(new Analys());
                    break;
                case R.id.results:
                    replaceFragment(new Results());
                    break;
                case R.id.support:
                    replaceFragment(new Helps());
                    break;
                case R.id.profile:
                    replaceFragment(new Profile()       );
                    break;
            }


            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}