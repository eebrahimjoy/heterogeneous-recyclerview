package com.eebrahimjoy.heterogeneiusrecyclerview.repository;

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

    public List<String> mockData() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        return strings;
    }
}

