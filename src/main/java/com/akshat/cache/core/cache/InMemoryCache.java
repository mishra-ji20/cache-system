package com.akshat.cache.core.cache;

import com.akshat.cache.core.eviction.EvictionPolicy;
import com.akshat.cache.core.storage.Storage;

public class  InMemoryCache <K, V>  implements Cache <K , V> {
    private Storage storage;
    private EvictionPolicy evictionPolicy;

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        return false;
    }

    @Override
    public boolean delete(K key) {
        return false;
    }
}
