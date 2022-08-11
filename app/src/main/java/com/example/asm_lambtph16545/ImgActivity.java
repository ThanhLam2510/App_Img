package com.example.asm_lambtph16545;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asm_lambtph16545.Adapter.ViewPagerAdapter;
import com.example.asm_lambtph16545.model.Photo;
import com.example.asm_lambtph16545.model.Photos1;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jsibbold.zoomage.ZoomageView;

import java.io.File;

public class ImgActivity extends AppCompatActivity {
    ImageView  imageView ;
    ViewPager2 viewPager ;
    FloatingActionButton fab1,fab2,fab3,fab4;
    Animation fabOpen,fabClose,fabrotate,fabback;
    Boolean isOpen= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
//        viewPager =findViewById(R.id.viewPager2);

        imageView = findViewById(R.id.detailImage);

        fab1=findViewById(R.id.floatingActionButton1);
        fab2=findViewById(R.id.floatingActionButton2);
        fab3=findViewById(R.id.floatingActionButton3);
        fab4=findViewById(R.id.floatingActionButton4);
        //animation

        fabOpen= AnimationUtils.loadAnimation(this,R.anim.rotate);
        fabClose= AnimationUtils.loadAnimation(this,R.anim.close);
        fabrotate= AnimationUtils.loadAnimation(this,R.anim.rotate);
        fabback= AnimationUtils.loadAnimation(this,R.anim.back);
        Bundle bundle = getIntent().getExtras();
        Photo photo = (Photo) bundle.get("img");
        Log.e("POSITION","po:"+photo);
//        imageView.setImageResource(photo.getImage());
        Glide.with(this).load(photo.getUrlM()).into(imageView);
//        viewPager.setAdapter(new ViewPagerAdapter(this,mlist,viewPager));
//        viewPager.setClipToPadding(false);
//        viewPager.setClipChildren(false);
//        viewPager.setOffscreenPageLimit(1);
//        viewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
//        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
//        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
//        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
////                float r = 1 -Math.abs(position);
////                page.setScaleY(0.85f+r*0.15f);
////                    String  p = String.valueOf(position);
////                    int pos = Integer.parseInt(String.valueOf(position));
//                Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();
//            }
//        });
//        viewPager.setPageTransformer(compositePageTransformer);

        fab1.setOnClickListener(v -> {
            animationFab();
        });
        fab2.setOnClickListener(v -> {
            animationFab();
            dowloadImage("img",photo.getUrlM());
            Toast.makeText(this, "t2", Toast.LENGTH_SHORT).show();
        });
        fab3.setOnClickListener(v -> {
            animationFab();
            Toast.makeText(this, "t3", Toast.LENGTH_SHORT).show();
        });
        fab4.setOnClickListener(v -> {
            animationFab();
            Toast.makeText(this, "t4", Toast.LENGTH_SHORT).show();
        });
    }
    private void dowloadImage(String fileName, String url) {
        try {
            DownloadManager downloadManager = null;
            downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

            Uri dowloadUri = Uri.parse(url);
            DownloadManager.Request request = new DownloadManager.Request(dowloadUri);

            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI
                            | DownloadManager.Request.NETWORK_MOBILE)
                    .setAllowedOverRoaming(false)
                    .setTitle(fileName)
                    .setMimeType("image/jpeg")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, File.separator + fileName + ".jpg");

            downloadManager.enqueue(request);

            Toast.makeText(getApplicationContext(), "Dowloading...", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),

                    "Dowload Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("Imgdow",e.getMessage());
        }
    }
    private void animationFab(){
        if(isOpen){
            fab1.startAnimation(fabrotate);
            fab2.startAnimation(fabClose);
            fab3.startAnimation(fabClose);
            fab4.startAnimation(fabClose);
            fab2.setClickable(false);
            fab3.setClickable(false);
            fab4.setClickable(false);
            isOpen=false;
        }else {
            fab1.startAnimation(fabback);
            fab2.startAnimation(fabOpen);
            fab3.startAnimation(fabOpen);
            fab4.startAnimation(fabOpen);
            fab2.setClickable(true);
            fab3.setClickable(true);
            fab4.setClickable(true);
            isOpen=true;
        }


    }


}