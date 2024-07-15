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

    }


    @Test
    void DescriptionTest() {

    }

}