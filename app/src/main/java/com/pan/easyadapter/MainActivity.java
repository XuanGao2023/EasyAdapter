package com.pan.easyadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pan.easyadapter.easyadapter.AdapterBase;
import com.pan.easyadapter.easyadapter.ItemBase;
import com.pan.easyadapter.easyadapter.ViewHolderBuilder;
import com.pan.easyadapter.easyadapter.usage.ItemTest;
import com.pan.easyadapter.easyadapter.usage.ItemTest1;
import com.pan.easyadapter.easyadapter.usage.ViewHolderTest;
import com.pan.easyadapter.easyadapter.usage.ViewHolderTest1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdapterBase adapterBase;
    private ArrayList<ItemBase> itemBaseArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        ViewHolderBuilder builder = ViewHolderBuilder.getDefaultViewHolderBuilder();
        builder.putItemViewHolderRelation(ItemTest.class, ViewHolderTest.class);
        builder.putItemViewHolderRelation(ItemTest1.class, ViewHolderTest1.class);
        adapterBase = new AdapterBase(this, itemBaseArrayList);
        recyclerView.setAdapter(adapterBase);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemBaseArrayList.add(new ItemTest("ItemTest"));
        itemBaseArrayList.add(new ItemTest1("ItemTest1Left", "ItemTest1Right"));
    }

}
