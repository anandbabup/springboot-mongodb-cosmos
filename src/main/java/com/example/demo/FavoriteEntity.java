package com.example.demo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hca_favorites")
public class FavoriteEntity{
    
    @Id
    private String favoriteId;
    private String userId;
    private String favoriteRegion;
    private String favoriteMedicalCenterId;
    private String favoriteDepartmentId;
    private String usersFavoriteId;
    private String favoriteType;
    private String createdBy;
    private String updatedBy;
    private Date createdDateTime;
    private Date updateDateTime;
    
    public FavoriteEntity() {

    }
    
    public FavoriteEntity(String favoriteId, String userId, String favoriteRegion,
            String favoriteMedicalCenterId, String favoriteDepartmentId, String usersFavoriteId, String favoriteType,
            String createdBy, String updatedBy, Date createdDateTime, Date updateDateTime) {
        super();
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.favoriteRegion = favoriteRegion;
        this.favoriteMedicalCenterId = favoriteMedicalCenterId;
        this.favoriteDepartmentId = favoriteDepartmentId;
        this.usersFavoriteId = usersFavoriteId;
        this.favoriteType = favoriteType;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdDateTime = createdDateTime;
        this.updateDateTime = updateDateTime;
    }

    @Override
    public String toString() {
        return "[favoriteRegion=" + favoriteRegion + ", favoriteMedicalCenterId=" + favoriteMedicalCenterId + "]";
    }

    public String getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFavoriteRegion() {
        return favoriteRegion;
    }

    public void setFavoriteRegion(String favoriteRegion) {
        this.favoriteRegion = favoriteRegion;
    }

    public String getFavoriteMedicalCenterId() {
        return favoriteMedicalCenterId;
    }

    public void setFavoriteMedicalCenterId(String favoriteMedicalCenterId) {
        this.favoriteMedicalCenterId = favoriteMedicalCenterId;
    }

    public String getFavoriteDepartmentId() {
        return favoriteDepartmentId;
    }

    public void setFavoriteDepartmentId(String favoriteDepartmentId) {
        this.favoriteDepartmentId = favoriteDepartmentId;
    }

    public String getUsersFavoriteId() {
        return usersFavoriteId;
    }

    public void setUsersFavoriteId(String usersFavoriteId) {
        this.usersFavoriteId = usersFavoriteId;
    }

    public String getFavoriteType() {
        return favoriteType;
    }

    public void setFavoriteType(String favoriteType) {
        this.favoriteType = favoriteType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    
    public Date getCreatedDateTime() {
        return createdDateTime;
    }
    
    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
    
    public Date getUpdateDateTime() {
        return updateDateTime;
    }
    
    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
    
}

