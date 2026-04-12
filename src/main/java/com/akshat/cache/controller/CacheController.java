package com.akshat.cache.controller;

import com.akshat.cache.model.CacheRequestDTO;
import com.akshat.cache.model.CacheResponseDTO;
import com.akshat.cache.service.CacheService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CacheController {
    private final CacheService <String , String> cacheService ;
    private final ObjectMapper objectMapper;

    public CacheController(CacheService< String , String> cacheService , ObjectMapper objectMapper){
        this.cacheService = cacheService;
        this.objectMapper = objectMapper;
    }
    @GetMapping("/cache/getValue/{key}")
    public CacheResponseDTO getValue(@PathVariable String key){
        String value = cacheService.get(key);
        CacheResponseDTO cacheResponse = new CacheResponseDTO();
        try {
            cacheResponse.setValue(objectMapper.readTree(value));
        }catch (JsonProcessingException e){
            throw new RuntimeException("Serialization failed", e);
        }
        return  cacheResponse;
    }

    @PostMapping("/cache/postValue")
    public boolean putValue(@RequestBody CacheRequestDTO cacheRequestDTO) {
        String key = cacheRequestDTO.getKey();
        String value;
        try{
            value = objectMapper.writeValueAsString(cacheRequestDTO.getValue());
        }catch (JsonProcessingException e){
            throw new RuntimeException("Deserialization failed", e);
        }
        cacheService.put(key , value);

       return  false;
    }

    @DeleteMapping("cache/deleteKey")
    public  boolean deleteValue(@RequestParam String key){
        return cacheService.delete(key);
    }




}
