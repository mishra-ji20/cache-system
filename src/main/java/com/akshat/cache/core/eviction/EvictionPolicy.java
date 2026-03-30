package com.akshat.cache.core.eviction;

import com.akshat.cache.core.node.CacheNode;

public interface EvictionPolicy <K , V> {
    void onAccess(CacheNode<K , V> node);
    void onInsert(CacheNode <K , V> node);
    void onDelete(CacheNode <K , V> node);
    K evict();
}
