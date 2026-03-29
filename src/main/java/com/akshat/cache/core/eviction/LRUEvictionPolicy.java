package com.akshat.cache.core.eviction;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class LRUEvictionPolicy<N> implements EvictionPolicy <N> {
    List<N> lruOrdered;
    N dummyHead;
    N dummyTail;

    @Override
    public boolean keysAccessed(N node) {
        return false;
    }

    @Override
    public void evict() {

    }
}
