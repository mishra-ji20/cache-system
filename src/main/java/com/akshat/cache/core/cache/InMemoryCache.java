package com.akshat.cache.core.cache;

import com.akshat.cache.core.eviction.EvictionPolicy;
import com.akshat.cache.core.eviction.LRUEvictionPolicy;
import com.akshat.cache.core.node.CacheNode;
import com.akshat.cache.core.storage.InMemoryStorage;
import com.akshat.cache.core.storage.Storage;

public class  InMemoryCache <K, V>  implements Cache <K , V> {
    private final Storage<K , V> storage;
    private final EvictionPolicy <K , V> evictionPolicy;
    int capacity;
    int currentCapacity;
    public InMemoryCache(int capacity){
        this.capacity = capacity;
        this.currentCapacity = 0;
        this.storage = new InMemoryStorage<>();
        this.evictionPolicy = new LRUEvictionPolicy<>();
    }
    public CacheNode<K, V> getHelper(K key){
        return storage.get(key);
    }

    @Override
    public V get(K key) {
        CacheNode <K , V> node = getHelper(key);
        evictionPolicy.onAccess(node);
        return node == null ? null : node.getValue();
    }

    @Override
    public boolean put(K key, V value) {
        CacheNode<K , V> currNode = getHelper(key);
        if( currNode != null){
            evictionPolicy.onAccess(currNode);
            currNode.setValue(value);
        }else{
            if(currentCapacity == capacity){
                K evictedKey = evictionPolicy.evict();
                delete(evictedKey);
            }
            currNode = new CacheNode<>(key , value);
            evictionPolicy.onInsert(currNode);
            currentCapacity++;
        }
        storage.add(key , currNode);
        return true;
    }

    @Override
    public boolean delete(K key) {
        CacheNode<K , V>  currNode = getHelper(key);
        storage.remove(key);
        evictionPolicy.onDelete(currNode);
        currentCapacity--;
        return false;
    }
}
