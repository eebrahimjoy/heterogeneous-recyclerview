package com.eebrahimjoy.heterogeneiusrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.eebrahimjoy.heterogeneiusrecyclerview.adapter.MixAdapter;
import com.eebrahimjoy.heterogeneiusrecyclerview.databinding.ActivityMainBinding;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Chapter;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Video;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Document;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private MixAdapter mixAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<Object> objectList = new ArrayList<>();
        objectList.add(new Document("Document 1", "Author 1"));
        objectList.add(new Video("Video 1"));
        objectList.add(new Chapter("Chapter 1"));
        objectList.add(new Video("Video 2"));
        objectList.add(new Document("Document 2", "Author 2"));
        objectList.add(new Chapter("Chapter 2"));
        objectList.add(new Chapter("Chapter 3"));
        objectList.add(new Video("Video 3"));
        objectList.add(new Document("Document 3", "Author 3"));

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mixAdapter = new MixAdapter(objectList);
        mBinding.recyclerView.setAdapter(mixAdapter);

    }
}