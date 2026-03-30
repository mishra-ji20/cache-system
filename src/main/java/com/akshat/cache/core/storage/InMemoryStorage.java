package com.akshat.cache.core.storage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;



public class InMemoryStorage<K, N> implements Storage <K , N> {

    ConcurrentMap<K , N> storageMap;
    int initialCapacity;

    public InMemoryStorage(int initialCapacity){
        this.initialCapacity = initialCapacity;
        this.storageMap = new ConcurrentHashMap<>();
    }

    @Override
    public N get(K key) {
        return storageMap.getOrDefault(key , null);
    }

    @Override
    public void  add (K key , N node) {
         storageMap.put(key, node);
    }

    @Override
    public void remove(K key) {
        storageMap.remove(key);
    }


}
