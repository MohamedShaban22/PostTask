package com.example.post_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int i=0;
RecyclerView rv ;
    RecyclerView rv_Story ;
post_adapter postAdapter ;
Story_Adapter storyadapter ;
RecyclerView.LayoutManager layoutManager ;
TextView likeCounter ;

List <postDataClass> listpostData=new ArrayList<>();
    List <StoryDataClass> listStoryData=new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.RS) ;
        rv_Story = findViewById(R.id.RV_Stores);
        likeCounter=findViewById(R.id.likesNumber);
      listpostData.add(new postDataClass(R.drawable.im1,"Mohamed Aboelftoh","2 hour",R.drawable.im1,i));
        listpostData.add(new postDataClass(R.drawable.im2,"Ahmed Aboelftoh","3 hour",R.drawable.im2,i));
        listpostData.add(new postDataClass(R.drawable.im3,"Mohamed shapan","4 hour",R.drawable.im3,i));
        listpostData.add(new postDataClass(R.drawable.im4,"Aya Aboelftoh","5 hour",R.drawable.im4,i));
        listpostData.add(new postDataClass(R.drawable.im1,"Sara Aboelftoh","6 hour",R.drawable.im1,i));
        listpostData.add(new postDataClass(R.drawable.im2,"Mohamed Ali","7 hour",R.drawable.im2,i));
        listpostData.add(new postDataClass(R.drawable.im3,"yuoussif Aboelftoh","8 hour",R.drawable.im3,i));
        listpostData.add(new postDataClass(R.drawable.im4,"Mohamed ragb","9 hour",R.drawable.im4,i));
        listpostData.add(new postDataClass(R.drawable.im1,"sameh Aboelftoh","11 hour",R.drawable.im1,i));
        listpostData.add(new postDataClass(R.drawable.im2,"said Aboelftoh","12 hour",R.drawable.im2,i));
        listpostData.add(new postDataClass(R.drawable.im3,"yasser Aboelftoh","14 hour",R.drawable.im3,i));
        //..........................................................
        listStoryData.add(new StoryDataClass(R.drawable.im1,"Ahmed mohamed",R.drawable.miss));
        listStoryData.add(new StoryDataClass(R.drawable.im2,"Islam Ahmed" ,R.drawable.im1));
        listStoryData.add(new StoryDataClass(R.drawable.im3,"aya yasser",R.drawable.im4));
        listStoryData.add(new StoryDataClass(R.drawable.im4,"salma mohamed",R.drawable.im3));
        listStoryData.add(new StoryDataClass(R.drawable.im2,"mostafa khald",R.drawable.im1));
        listStoryData.add(new StoryDataClass(R.drawable.im1,"sabry ragab",R.drawable.im2));
        listStoryData.add(new StoryDataClass(R.drawable.im3,"alaa mohamed",R.drawable.im4));

        storyadapter = new Story_Adapter(listStoryData);
        rv_Story.setAdapter(storyadapter);
        postAdapter = new post_adapter(listpostData) ;
        layoutManager = new LinearLayoutManager(MainActivity.this) ;
        rv.setAdapter(postAdapter);
        rv.setLayoutManager(layoutManager);

        postAdapter.onlikeOnclickListener=new post_adapter.OnLikeOnclickListener(){

            @Override
            public void onclick(postDataClass post, int position) {
               i=listpostData.get(position).likeCounter++;
               postAdapter.notifyDataSetChanged();

            }
        };

    }

}