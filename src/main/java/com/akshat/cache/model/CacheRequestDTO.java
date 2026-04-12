package com.akshat.cache.model;


import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CacheRequestDTO {
    public String key;
    public JsonNode value;
}
