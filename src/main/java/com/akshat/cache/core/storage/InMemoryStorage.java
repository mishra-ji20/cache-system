package com.akshat.cache.core.storage;

import java.util.concurrent.ConcurrentMap;

public class InMemoryStorage<N , K> implements Storage <N , K> {
    ConcurrentMap<K , N> storageMap;

    @Override
    public K get(N key) {
        return null;
    }

    @Override
    public boolean add(K node) {
        return false;
    }

    @Override
    public boolean remove(K node) {
        return false;
    }
}
