package com.imagesgallery.Models;

import jakarta.persistence.*;

    @Entity
    @Table(name = "imagesgallery")

public class ImagesGalleryModels {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "url")
    private String url;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
  
   public long getId() {
       return id;
   }

        public void setId(Long id) {
            this.id = id;
        }

       public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

