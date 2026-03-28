package com.akshat.cache.core.storage;

public interface Storage <K , N> {
    N get (K key);
    boolean add (N node);
    boolean remove(N node);
}
