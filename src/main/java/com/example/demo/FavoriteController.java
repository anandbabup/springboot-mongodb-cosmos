package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    @Autowired
    private KPDirectoryDao dao;

    @PostMapping
    public ResponseEntity<FavoriteEntity> addBook(@RequestBody FavoriteEntity entity) {
    	dao.addFavorite(entity.getUserId(),entity.getFavoriteRegion(), entity.getFavoriteMedicalCenterId(), entity.getFavoriteDepartmentId(), entity.getFavoriteId(),entity.getFavoriteType());
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Map<String, List<String>>> getAllFavorites(@RequestBody Map<String, Object> requestBody) {
        String userId = (String) requestBody.get("userId");
        String favoriteType = (String) requestBody.get("favoriteType");
    	
    	Map<String, List<String>> books = dao.getFavorite(userId, favoriteType);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<String> updateFavorite(@RequestBody FavoriteEntity entity) {
        dao.upsertFavorite(entity.getUserId(),entity.getFavoriteRegion(), entity.getFavoriteMedicalCenterId(), entity.getFavoriteDepartmentId(), entity.getFavoriteId(),entity.getFavoriteType());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<String> deleteFavorite(@RequestBody Map<String, String> requestBody) {
        String userId = requestBody.get("userId");
        String favoriteType = requestBody.get("favoriteType");
        String favoriteId = requestBody.get("favoriteId");
        
        dao.deleteFavorite(userId, favoriteId, favoriteType);
        return ResponseEntity.ok().build(); 
    }
}
