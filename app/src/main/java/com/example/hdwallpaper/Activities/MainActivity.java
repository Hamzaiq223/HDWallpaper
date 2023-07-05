package com.example.hdwallpaper.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hdwallpaper.Adapter.NaturalImagesAdapter;
import com.example.hdwallpaper.Model.NaturalImages;
import com.example.hdwallpaper.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvNaturalImages;
    NaturalImagesAdapter naturalImagesAdapter;
    private List<NaturalImages> imageList;
    private FirebaseStorage storage;
    private StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(MainActivity.this);

        rvNaturalImages  = findViewById(R.id.rvNaturalImages);
        imageList = new ArrayList<>();
        naturalImagesAdapter = new NaturalImagesAdapter(imageList, this);
        rvNaturalImages.setAdapter(naturalImagesAdapter);

        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference().child("Nature"); // Replace "images" with your Firebase Storage folder name

        fetchImages();
    }
    private void fetchImages() {
        storageRef.listAll()
                .addOnSuccessListener(listResult -> {
                    for (StorageReference item : listResult.getItems()) {
                        item.getDownloadUrl().addOnSuccessListener(uri -> {
                            imageList.add(new NaturalImages(uri.toString()));
                            naturalImagesAdapter.notifyDataSetChanged();
                        });
                    }
                })
                .addOnFailureListener(e -> {
                    // Handle any errors
                });
    }
}