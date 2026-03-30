package com.akshat.cache.core.eviction;

import com.akshat.cache.core.node.CacheNode;




public class LRUEvictionPolicy <K , V> implements EvictionPolicy <K , V>  {
    CacheNode<K , V> dummyHead;
    CacheNode<K , V> dummyTail;
    public LRUEvictionPolicy(){
        dummyHead = new CacheNode<>(null , null , null , null);
        dummyTail = new CacheNode<>(null , null , null  , null);
        dummyHead.setNext(dummyTail);
        dummyTail.setNext(dummyHead);
    }


    //checks to add if node exists or not should be made in cache Application
    @Override
    public void onAccess(CacheNode<K, V> node) {
        onDelete(node);
        onInsert(node);

    }

    @Override
    public void onInsert(CacheNode<K, V> node) {
        node.setPrev(dummyHead);
        node.setNext(dummyHead.getNext());
        dummyHead.getNext().setPrev(node);
        dummyHead.setNext(node);

    }

    @Override
    public void onDelete(CacheNode<K, V> node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }

    @Override
    public K evict() {
        K key = null ;
        if(dummyTail.getPrev() != dummyHead){
            key= dummyTail.getPrev().getKey();
            onDelete(dummyTail.getPrev());
        }
        return key;

    }
}
