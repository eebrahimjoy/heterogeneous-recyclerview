package com.eebrahimjoy.heterogeneiusrecyclerview.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.eebrahimjoy.heterogeneiusrecyclerview.repositories.MockRepository;

import java.util.List;

public class MockViewModel extends ViewModel {
    private MockRepository mockRepository;

    public MockViewModel(MockRepository mockRepository) {
        this.mockRepository = mockRepository;
    }

    public LiveData<List<Object>> getMockData() {
        return mockRepository.mockData();
    }
}
