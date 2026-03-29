package com.akshat.cache.core.node;

import java.time.Instant;

public class CacheNode<K , V> {
    K key ;
    V value ;
    CacheNode <K  , V> next;
    CacheNode <K , V> prev;
    long creationTime;
    public CacheNode(K key , V value , CacheNode<K , V> next , CacheNode <K , V> prev){
        this.key =  key;
        this.value = value;
        this.next = next;
        this.prev = prev;
        creationTime = Instant.now().toEpochMilli();
    }
}
