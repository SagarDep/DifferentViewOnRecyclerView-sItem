package com.androidbie.differenctviewonrecyclerviewitem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidbie.differenctviewonrecyclerviewitem.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ItemModel> mlistItemModel;
    private RecyclerView recyclerView;
    private ViewAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        mlistItemModel = new ArrayList<>();
        mlistItemModel.add(new ItemModel(0,"This Form Login","Android Newbie","Bandung"));
        mlistItemModel.add(new ItemModel(1,"This Form Loading","Android Expert","Canberra"));
        mlistItemModel.add(new ItemModel(2,"This Form Detail","Android Middle","Kuala Lumpur"));
        mlistItemModel.add(new ItemModel(0,"This Form Login","Android Newbie","Bandung"));
        mlistItemModel.add(new ItemModel(2,"This Form Detail","Android Expert","London"));
        mlistItemModel.add(new ItemModel(1,"This Form Loading","Android Middle","Barcelona"));

        mAdapter = new ViewAdapter(mlistItemModel, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


    }
}
