package com.eebrahimjoy.heterogeneiusrecyclerview.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.eebrahimjoy.heterogeneiusrecyclerview.R;
import com.eebrahimjoy.heterogeneiusrecyclerview.adapters.BookAdapter;
import com.eebrahimjoy.heterogeneiusrecyclerview.adapters.MixAdapter;
import com.eebrahimjoy.heterogeneiusrecyclerview.databinding.ActivityBookBinding;
import com.eebrahimjoy.heterogeneiusrecyclerview.utilities.InjectorUtils;
import com.eebrahimjoy.heterogeneiusrecyclerview.viewmodel.MockViewModel;
import com.eebrahimjoy.heterogeneiusrecyclerview.viewmodelfactories.MockDataViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity {
    private ActivityBookBinding mBinding;
    private MockViewModel mockViewModel;
    private MixAdapter mixAdapter;
    private BookAdapter bookAdapter;
    List<Object> objectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_book);

        init();
        //initRecyclerView();
        initExpandableListView();
        getMockData();

    }

    private void init() {
        objectList = new ArrayList<>();
        mockViewModel = new ViewModelProvider(this, new MockDataViewModelFactory(
                InjectorUtils.provideMockRepository()
        )).get(MockViewModel.class);
    }

    private void initRecyclerView() {
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mixAdapter = new MixAdapter(objectList);
        mBinding.recyclerView.setAdapter(mixAdapter);
    }

    private void initExpandableListView() {
        bookAdapter = new BookAdapter(getApplicationContext(), objectList);
        mBinding.expandArrowEV.setAdapter(bookAdapter);
    }

    private void getMockData() {
     mockViewModel.getMockData().observe(this, new Observer<List<Object>>() {
         @Override
         public void onChanged(List<Object> objects) {
             if (objects.size()>0){
                 objectList.addAll(objects);
             }
             bookAdapter.notifyDataSetChanged();
            // mixAdapter.notifyDataSetChanged();
         }
     });
    }


}