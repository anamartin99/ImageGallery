package com.imagesgallery.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImagesGalleryModelsTest {

    @Test
    void IdTest() {
       Long id = 1L;
       ImagesGalleryModels imagegallerymodels = new ImagesGalleryModels();

       imagegallerymodels.setId(id);
       assertEquals(id, imagegallerymodels.getId());

    }

    @Test
    void UrlTest() {
        String Url = "vivapepito.com";
        ImagesGalleryModels imagesgallerymodels = new ImagesGalleryModels();

        imagesgallerymodels.setUrl(Url);
        assertEquals(Url, imagesgallerymodels.getUrl());
    }

    @Test
    void TitleTest() {
        String Title = "El libro de Pepito";
        ImagesGalleryModels imagesgallerymodels = new ImagesGalleryModels();

        imagesgallerymodels.setTitle(Title);
        assertEquals(Title, imagesgallerymodels.getTitle());

    }


    @Test
    void DescriptionTest() {
        String Description = "El perro de san roque no tiene rabo...";
        ImagesGalleryModels imagesgallerymodels = new ImagesGalleryModels();
        
        imagesgallerymodels.setDescription(Description);
        assertEquals(Description, imagesgallerymodels.getDescription());

    }

}