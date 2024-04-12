package com.example.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class KPDirectoryDaoImpl implements KPDirectoryDao {

	@Autowired
	private FavoriteRepository favoritesRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void upsertFavorite(String userId, String favoriteRegion, String favoriteMCID, String favoriteDeptId,
			String favoriteId, String favoriteType) {

		updateFavorite(userId, favoriteRegion, favoriteMCID, favoriteDeptId, favoriteId, favoriteType);

	}

	@Override
	public void addFavorite(String userId, String favoriteRegion, String favoriteMCID, String favoriteDeptId,
			String favoriteId, String favoriteType) {

		FavoriteEntity newFavourite = new FavoriteEntity();
		newFavourite.setUserId(userId);
		newFavourite.setFavoriteRegion(favoriteRegion);
		newFavourite.setFavoriteMedicalCenterId(favoriteMCID);
		newFavourite.setFavoriteDepartmentId(favoriteDeptId);
		newFavourite.setFavoriteId(favoriteId);
		newFavourite.setFavoriteType(favoriteType);
		newFavourite.setCreatedDateTime(new Date());

		favoritesRepository.save(newFavourite);
	}

	@Override
	public void updateFavorite(String userId, String favoriteRegion, String favoriteMCID, String favoriteDeptId,
			String favoriteId, String favoriteType) {

		FavoriteEntity newFavourite = new FavoriteEntity();
		newFavourite.setUserId(userId);
		newFavourite.setFavoriteRegion(favoriteRegion);
		newFavourite.setFavoriteMedicalCenterId(favoriteMCID);
		newFavourite.setFavoriteDepartmentId(favoriteDeptId);
		newFavourite.setFavoriteId(favoriteId);
		newFavourite.setFavoriteType(favoriteType);
		newFavourite.setUpdateDateTime(new Date());

		// Save the updated user
		favoritesRepository.save(newFavourite);
	}

	@Override
	public boolean isAlreadyAvailableFavorite(String userId, String favoriteId, String favoriteType) {
		return favoritesRepository.existsByUserIdAndFavoriteIdAndFavoriteType(userId, favoriteId, favoriteType);
	}

	@Override
	public void deleteFavorite(String userId, String favoriteId, String favoriteType) {

		// Delete the favorite by userId, favoriteId, and favoriteType
		favoritesRepository.deleteByUserIdAndFavoriteIdAndFavoriteType(userId, favoriteId, favoriteType);

	}

	@Override
	public Map<String, List<String>> getFavorite(String userId, String favoriteType) {

		List<String> favoriteIds = favoritesRepository.findFavoriteIdsByUserIdAndFavoriteType(userId, favoriteType);
		Map<String, List<String>> favoriteMap = new HashMap<>();
		favoriteMap.put(favoriteType, favoriteIds);
		return favoriteMap;
	}

}
