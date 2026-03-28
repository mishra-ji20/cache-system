package com.akshat.cache.core.eviction;

public interface EvictionPolicy <N> {
    boolean keysAccessed (N node);
    void evict();
}
