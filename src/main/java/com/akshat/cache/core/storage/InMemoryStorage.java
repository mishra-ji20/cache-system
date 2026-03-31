package com.akshat.cache.core.storage;

import com.akshat.cache.core.node.CacheNode;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;



public class InMemoryStorage<K, V> implements Storage <K , V> {

    ConcurrentMap<K , CacheNode<K , V>> storageMap;

    public InMemoryStorage(){
        this.storageMap = new ConcurrentHashMap<>();
    }

    @Override
    public CacheNode<K , V> get(K key) {
        return storageMap.getOrDefault(key , null);
    }

    @Override
    public void  add (K key , CacheNode<K , V> node) {
         storageMap.put(key, node);
    }

    @Override
    public void remove(K key) {
        storageMap.remove(key);
    }


}
