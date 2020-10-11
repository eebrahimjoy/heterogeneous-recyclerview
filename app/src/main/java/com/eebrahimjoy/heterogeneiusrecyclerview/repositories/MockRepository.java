package com.eebrahimjoy.heterogeneiusrecyclerview.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Chapter;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Document;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.SubChapter;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Video;

import java.util.ArrayList;
import java.util.List;


public class MockRepository {
    private static MockRepository mInstance;

    private static final Object LOCK = new Object();

    private MockRepository() {
    }

    public static MockRepository getInstance() {
        if (mInstance == null) {
            synchronized (LOCK) {
                mInstance = new MockRepository();
            }
        }
        return mInstance;
    }

    public LiveData<List<Object>> mockData() {
        final MutableLiveData<List<Object>> data = new MutableLiveData<>();

        List<Object> objectList = new ArrayList<>();
        List<SubChapter> subChapterList1 = new ArrayList<>();
        List<SubChapter> subChapterList2 = new ArrayList<>();
        List<SubChapter> subChapterList3 = new ArrayList<>();

        SubChapter subChapter1 = new SubChapter("Video 1.1");
        SubChapter subChapter2 = new SubChapter("Document 1.1");
        SubChapter subChapter3 = new SubChapter("Audio 1.1");
        SubChapter subChapter4 = new SubChapter("Video 2.1");
        SubChapter subChapter5 = new SubChapter("Video 2.2");
        SubChapter subChapter6 = new SubChapter("Document 2.1");

        subChapterList1.add(subChapter1);
        subChapterList1.add(subChapter2);
        subChapterList1.add(subChapter3);


        subChapterList2.add(subChapter4);
        subChapterList2.add(subChapter5);
        subChapterList2.add(subChapter6);


        subChapterList3.add(subChapter2);
        subChapterList3.add(subChapter2);
        subChapterList3.add(subChapter3);
        subChapterList3.add(subChapter3);
        subChapterList3.add(subChapter3);

        objectList.add(new Document("Document 1", "Author 1"));
        objectList.add(new Video("Video 1"));
        objectList.add(new Chapter("Chapter 1", subChapterList1));
        objectList.add(new Video("Video 2"));
        objectList.add(new Document("Document 2", "Author 2"));
        objectList.add(new Chapter("Chapter 2", subChapterList2));
        objectList.add(new Video("Video 3"));
        objectList.add(new Document("Document 3", "Author 3"));
        objectList.add(new Chapter("Chapter 3", subChapterList3));

        data.postValue(objectList);

        return data;
    }
}

