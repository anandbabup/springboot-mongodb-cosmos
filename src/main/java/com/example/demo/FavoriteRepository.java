package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends MongoRepository<FavoriteEntity, String> {
	List<String> findFavoriteIdsByUserIdAndFavoriteType(String userId, String favoriteType);
	void deleteByUserIdAndFavoriteIdAndFavoriteType(String userId, String favoriteId, String favoriteType); 
	boolean existsByUserIdAndFavoriteIdAndFavoriteType(String userId, String favoriteId, String favoriteType);
}
