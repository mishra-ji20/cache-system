package com.akshat.cache.core.node;

import java.time.Instant;

//Kept this as pojo just for the sepa

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
    public CacheNode (K key , V value ){
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
        creationTime = Instant.now().toEpochMilli();

    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public CacheNode<K, V> getNext() {
        return next;
    }

    public void setNext(CacheNode<K, V> next) {
        this.next = next;
    }

    public CacheNode<K, V> getPrev() {
        return prev;
    }

    public void setPrev(CacheNode<K, V> prev) {
        this.prev = prev;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }
}
