package com.eebrahimjoy.heterogeneiusrecyclerview.utilities;

import com.eebrahimjoy.heterogeneiusrecyclerview.repositories.MockRepository;


public class InjectorUtils {

    public static MockRepository provideMockRepository() {
        return MockRepository.getInstance();
    }
}
