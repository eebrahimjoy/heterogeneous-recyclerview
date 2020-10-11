package com.eebrahimjoy.heterogeneiusrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.eebrahimjoy.heterogeneiusrecyclerview.adapter.BookAdapter;
import com.eebrahimjoy.heterogeneiusrecyclerview.adapter.MixAdapter;
import com.eebrahimjoy.heterogeneiusrecyclerview.databinding.ActivityMainBinding;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Chapter;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.SubChapter;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Video;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Document;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private MixAdapter mixAdapter;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        SubChapter d1 = new SubChapter("Video 1.1");
        SubChapter d2 = new SubChapter("Document 1.1");
        SubChapter d3 = new SubChapter("Audio 1.1");
        SubChapter d4 = new SubChapter("Video 2.1");
        SubChapter d5 = new SubChapter("Video 2.2");
        SubChapter d6 = new SubChapter("Document 2.1");

        List<SubChapter> doc1 = new ArrayList<>();
        doc1.add(d1);
        doc1.add(d2);
        doc1.add(d3);

        List<SubChapter> doc2 = new ArrayList<>();
        doc2.add(d4);
        doc2.add(d5);
        doc2.add(d6);

        List<SubChapter> doc3 = new ArrayList<>();
        doc3.add(d2);
        doc3.add(d2);
        doc3.add(d3);
        doc3.add(d3);
        doc3.add(d3);


        List<Object> objectList = new ArrayList<>();
        objectList.add(new Document("Document 1", "Author 1"));
        objectList.add(new Video("Video 1"));
        objectList.add(new Chapter("Chapter 1", doc1));
        objectList.add(new Video("Video 2"));
        objectList.add(new Document("Document 2", "Author 2"));
        objectList.add(new Chapter("Chapter 2", doc2));
        objectList.add(new Chapter("Chapter 3", doc3));
        objectList.add(new Video("Video 3"));
        objectList.add(new Document("Document 3", "Author 3"));
        initRecyclerViewForDakSealAdd(objectList);

        /*List<Object> objectList = new ArrayList<>();
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
        mBinding.recyclerView.setAdapter(mixAdapter);*/

    }

    private void initRecyclerViewForDakSealAdd(List<Object> objects) {
        adapter = new BookAdapter(getApplicationContext(), objects);
        mBinding.expandArrowEV.setAdapter(adapter);
    }
}