package com.akshat.cache.core.eviction;

import com.akshat.cache.core.node.CacheNode;




public class LRUEvictionPolicy <K , V> implements EvictionPolicy <K , V>  {
    CacheNode<K , V> dummyHead;
    CacheNode<K , V> dummyTail;
    int currSize;
    public LRUEvictionPolicy(){
        dummyHead = new CacheNode<>(null , null , null , null);
        dummyTail = new CacheNode<>(null , null , null  , null);
        dummyHead.setNext(dummyTail);
        dummyTail.setNext(dummyHead);
        currSize = 0 ;
    }


    //checks to add if node exists or not should be made in cache Application
    @Override
    public void keysAccessed(CacheNode<K, V> node) {


    }

    @Override
    public void evict() {

    }
}
