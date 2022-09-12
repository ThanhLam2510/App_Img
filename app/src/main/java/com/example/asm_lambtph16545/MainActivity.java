package com.example.asm_lambtph16545;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.asm_lambtph16545.API.AipService;
import com.example.asm_lambtph16545.Adapter.PhotosAdapter;
import com.example.asm_lambtph16545.model.Photo;
import com.example.asm_lambtph16545.model.Photos1;
import com.example.asm_lambtph16545.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
//    public static final  List<Photos1> mlist= new ArrayList<>();
    List<Photo> photoArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
//        mlist.add(new Photos1(R.drawable.a));
//        mlist.add(new Photos1(R.drawable.a2));
//        mlist.add(new Photos1(R.drawable.a3));
//        mlist.add(new Photos1(R.drawable.a4));
//        mlist.add(new Photos1(R.drawable.a5));
//        mlist.add(new Photos1(R.drawable.a6));
//        mlist.add(new Photos1(R.drawable.b));
//        mlist.add(new Photos1(R.drawable.d));
//        mlist.add(new Photos1(R.drawable.c));
//        mlist.add(new Photos1(R.drawable.f));
//        mlist.add(new Photos1(R.drawable.r));
//        mlist.add(new Photos1(R.drawable.q));
//        mlist.add(new Photos1(R.drawable.w));
        onclickAPI();

    }
    private void onclickAPI() {
        AipService.AIP_SERVICE.getAPI().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                photoArrayList = (List<Photo>) user.getPhotos().getPhoto();
                Log.e("ARRAYLIST", "onCreate: "+photoArrayList.size() );
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                PhotosAdapter photosAdapter = new PhotosAdapter(photoArrayList,getApplicationContext());
                recyclerView.setAdapter(photosAdapter);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this,"CALL API erorr",Toast.LENGTH_SHORT).show();
            }
        });

    }

}