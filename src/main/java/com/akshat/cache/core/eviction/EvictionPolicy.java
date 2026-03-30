package com.akshat.cache.core.eviction;

import com.akshat.cache.core.node.CacheNode;

public interface EvictionPolicy <K , V> {
    void keysAccessed(CacheNode<K , V> node);
    void evict();
}
