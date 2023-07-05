package com.example.hdwallpaper.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hdwallpaper.Model.NaturalImages;
import com.example.hdwallpaper.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NaturalImagesAdapter extends RecyclerView.Adapter<NaturalImagesAdapter.ViewHolder> {
    private List<NaturalImages> imageList;
    private Context context;

    public NaturalImagesAdapter(List<NaturalImages> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_natural_images, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NaturalImages item = imageList.get(position);
        Picasso.get().load(item.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivImages);
        }
    }
}
