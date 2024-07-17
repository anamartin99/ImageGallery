package com.imagesgallery.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.imagesgallery.Repositories.IimagesGalleryRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.imagesgallery.Models.ImagesGalleryModels;


public class ImagesGalleryServicesTest {

    @Mock
    private IimagesGalleryRepository  imagesGalleryRepository;

    @InjectMocks
    private ImagesGalleryServices imagesGalleryServices;
    //private ImagesGalleryModels imagesGalleryModels;
    private ArrayList<ImagesGalleryModels> DataBaseList = new ArrayList<>();
    private ImagesGalleryModels image1;
    private ImagesGalleryModels image2;

    @BeforeEach
    public void DataBase() {
        MockitoAnnotations.openMocks(this);

        ImagesGalleryModels image1 = new ImagesGalleryModels();
        image1.setId(1L);
        image1.setUrl("perro.com");
        image1.setTitle("perro");
        image1.setDescription("perraso");

        ImagesGalleryModels image2 = new ImagesGalleryModels();
        image2.setId(2L);
        image2.setUrl("gato.com");
        image2.setTitle("gato");
        image2.setDescription("gatote");

        DataBaseList.add(image1);
        DataBaseList.add(image2);

    }

    @Test
    public void getImages(){
        //Arrange
        ArrayList<ImagesGalleryModels> GetAllImages = imagesGalleryServices.getImages();
        //Act
        when(imagesGalleryServices.getImages()).thenReturn(DataBaseList);
        //Assert
        assertEquals(2, GetAllImages.size());
    }

    @Test
    public void getImagesById(){
        when(imagesGalleryRepository.findById(1L)).thenReturn(Optional.of(image1));

        ImagesGalleryModels ImageById = imagesGalleryServices.getById(1L);

        assertEquals("perro", image1.getTitle());
        assertEquals("perro.com", image1.getUrl());
        assertEquals("perraso", image1.getDescription());
    }

    }

