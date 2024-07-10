package com.imagesgallery.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

public class imagesgalleryModels {

      @Entity
      @Table(name = "imagesgallery") 

public class ImagesGalleryModels {

   private long id;

   private String imageUrl;

   private String title;

   private String description;
  
   public long getId() {
       return id;
   }

   public String getDescription() {
       return description;
   }

   public String getImageUrl() {
       return imageUrl;
   }

   public String getTitle() {
       return title;
   }

   public void setDescription(String description) {
       this.description = description;
   }

   public void setId(long id) {
       this.id = id;
   }

   public void setImageUrl(String imageUrl) {
       this.imageUrl = imageUrl;
   }

   public void setTitle(String title) {
       this.title = title;
   }
}

    
}
