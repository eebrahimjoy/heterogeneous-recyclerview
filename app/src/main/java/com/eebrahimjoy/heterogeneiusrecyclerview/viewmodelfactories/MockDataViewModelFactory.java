package com.eebrahimjoy.heterogeneiusrecyclerview.viewmodelfactories;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.eebrahimjoy.heterogeneiusrecyclerview.repositories.MockRepository;
import com.eebrahimjoy.heterogeneiusrecyclerview.viewmodel.MockViewModel;


public class MockDataViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private long officeId;
    private long designationId;
    private MockRepository mockRepository;

    public MockDataViewModelFactory(MockRepository mockRepository) {
        this.mockRepository = mockRepository;
    }

    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MockViewModel(mockRepository);
    }
}