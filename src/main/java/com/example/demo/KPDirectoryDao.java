package com.example.demo;

import java.util.List;
import java.util.Map;

public interface KPDirectoryDao {
	
	public void upsertFavorite(String userId, String favoriteRegion, String favoriteMCID, String favoriteDeptId, String favoriteId, String favoriteType);
	
	public void addFavorite(String userId, String favoriteRegion, String favoriteMCID, String favoriteDeptId, String favoriteId, String favoriteType);
	
	public void updateFavorite(String userId, String favoriteRegion, String favoriteMCID, String favoriteDeptId, String favoriteId, String favoriteType);
	
	public boolean isAlreadyAvailableFavorite(String userId, String favoriteId, String favoriteType);
	
	public void deleteFavorite(String userId, String favoriteId, String favoriteType);
	
	public Map<String, List<String>> getFavorite(String userId, String favoriteType);
	
}
