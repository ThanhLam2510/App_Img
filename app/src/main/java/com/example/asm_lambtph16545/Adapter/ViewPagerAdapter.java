package com.example.asm_lambtph16545.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.asm_lambtph16545.R;
import com.example.asm_lambtph16545.model.Photos1;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHoler> {

    private Context context;
    private List<Photos1> listphoto = new ArrayList<>();
    private ViewPager2 viewPager2;


    public ViewPagerAdapter(Context context, List<Photos1> photos, ViewPager2 viewPager2) {
        this.context = context;
        this.listphoto = photos;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ViewPagerHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_click,parent,false);
        return new ViewPagerHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerHoler holder, int position) {
        holder.setImage(listphoto.get(position));

    }

    @Override
    public int getItemCount() {
        return listphoto.size();
    }
    public class ViewPagerHoler extends RecyclerView.ViewHolder{
        public RoundedImageView imageView;

        public ViewPagerHoler(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.imgSlide);
        }
        public void setImage(Photos1 photos){
            imageView.setImageResource(photos.getImage());
        }
    }

}
