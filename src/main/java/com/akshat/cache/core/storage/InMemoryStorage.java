package com.akshat.cache.core.storage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;



public class InMemoryStorage<N , K> implements Storage <N , K> {

    ConcurrentMap<K , N> storageMap;
    int initialCapacity;

    public InMemoryStorage(int initialCapacity){
        this.initialCapacity = initialCapacity;
        this.storageMap = new ConcurrentHashMap<>();
    }

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
