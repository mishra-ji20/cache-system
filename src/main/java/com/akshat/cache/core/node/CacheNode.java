package com.akshat.cache.core.node;

public class CacheNode<K , V> {
    K key ;
    V value ;
    CacheNode <K  , V> next;
    CacheNode <K , V> prev;

    public CacheNode(K key , V value , CacheNode<K , V> next , CacheNode <K , V> prev){
        this.key =  key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
