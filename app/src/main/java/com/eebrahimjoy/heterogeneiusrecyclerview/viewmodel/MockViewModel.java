package com.eebrahimjoy.heterogeneiusrecyclerview.viewmodel;

import androidx.lifecycle.ViewModel;

import com.eebrahimjoy.heterogeneiusrecyclerview.repository.MockRepository;

import java.util.List;

public class MockViewModel extends ViewModel {
    private MockRepository mockRepository;

    public MockViewModel() {
        mockRepository = MockRepository.getInstance();
    }

    public List<String> getMockData() {
        return mockRepository.mockData();
    }
}
