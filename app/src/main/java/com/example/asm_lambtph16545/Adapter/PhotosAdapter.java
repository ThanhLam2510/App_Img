package com.example.asm_lambtph16545.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.asm_lambtph16545.ImgActivity;
import com.example.asm_lambtph16545.R;
import com.example.asm_lambtph16545.model.Photo;
import com.example.asm_lambtph16545.model.Photos1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder> {
//    private List<Photos1> listphotos = new ArrayList<>();
    private List<Photo> listphoto ;
    Context context;

    public PhotosAdapter(List<Photo> listphoto, Context context) {
        this.listphoto = listphoto;
        this.context = context;
    }

    @NonNull
    @Override
    public PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new PhotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosViewHolder holder, int position) {
        Photo photos = listphoto.get(position);
        Glide.with(context).load(""+photos.getUrlM()).into(holder.roundedImageView);
        holder.textView.setText(photos.getViews());
//        holder.roundedImageView.setImageResource(listphotos.get(position).getImage());
        holder.roundedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ImgActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("img",  photos);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listphoto.size();
    }

    public class PhotosViewHolder extends RecyclerView.ViewHolder{
        ImageView roundedImageView;
        TextView textView;
        public PhotosViewHolder(@NonNull View itemView) {
            super(itemView);
            roundedImageView=itemView.findViewById(R.id.itemImg);
            textView=itemView.findViewById(R.id.tvView);
        }
    }
}
