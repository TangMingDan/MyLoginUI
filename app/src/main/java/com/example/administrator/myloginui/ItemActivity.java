package com.example.administrator.myloginui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {
    private List<sings> singsList = new ArrayList<>();
    private String[] singsItems = {"这是第一个歌单","这是第二个歌单","这是第三个歌单","这是第四个歌单",
                                        "这是第五个歌单","这是第六个歌单","这是第七个歌单","这是第八个歌单",};
    private  String[] singsnum = {"共50首","共50首","共50首","共50首","共50首","共50首","共50首","共50首"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sings_layout);
        initSings();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
        SingsAdapter adapter = new SingsAdapter(singsList);
        recyclerView.setAdapter(adapter);
    }
    public void initSings(){
        for (int i = 0; i < singsItems.length; i++) {
            sings sing = new sings(singsnum[i],R.drawable.bg_main,singsItems[i]);
            singsList.add(sing);
        }
    }
}
