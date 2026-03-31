package com.akshat.cache.core.storage;

import com.akshat.cache.core.node.CacheNode;

public interface Storage <K ,V>{
    CacheNode<K , V> get (K key);
    void add (K  key , CacheNode<K , V> node);
    void remove(K key);
}
