package com.akshat.cache.service;

import com.akshat.cache.configuration.CacheConfiguration;
import com.akshat.cache.core.cache.Cache;
import com.akshat.cache.core.cache.InMemoryCache;
import org.springframework.stereotype.Service;

import javax.security.auth.callback.CallbackHandler;

@Service
public class  CacheService <K , V > {

    private final CacheConfiguration cacheConfiguration; // I will try the suggestion of making it local variable but I guess the code will break
    private final Cache <K , V > cache;

    public CacheService(CacheConfiguration cacheConfiguration){
        this.cacheConfiguration = cacheConfiguration;
        cache = new InMemoryCache<>( this.cacheConfiguration.getCapacity());
    }

    public V get (K key){
        return cache.get(key);
    }
    public boolean put(K key , V value){
        return cache.put(key , value);
    }
    public boolean delete (K key){
        return cache.delete(key);
    }


}
