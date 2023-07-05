package com.example.hdwallpaper.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hdwallpaper.Adapter.NaturalImagesAdapter;
import com.example.hdwallpaper.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvNaturalImages;
    NaturalImagesAdapter naturalImagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNaturalImages  = findViewById(R.id.rvNaturalImages);

    }
}