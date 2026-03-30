package com.akshat.cache.core.storage;

public interface Storage <K , N> {
    N get (K key);
    void add (K  key , N node);
    void remove(K key);
}
