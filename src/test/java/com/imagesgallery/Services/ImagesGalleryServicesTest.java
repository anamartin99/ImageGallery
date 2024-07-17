package com.imagesgallery.Services;

import com.imagesgallery.Models.ImagesGalleryModels;
import com.imagesgallery.Repositories.IimagesGalleryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ImagesGalleryServicesTest {

    @InjectMocks
    private ImagesGalleryServices imagesGalleryServices;

    @Mock
    private IimagesGalleryRepository imagesGalleryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetImages() {
        ArrayList<ImagesGalleryModels> imagesList = new ArrayList<>();
        ImagesGalleryModels image = new ImagesGalleryModels();
        imagesList.add(image);

        when(imagesGalleryRepository.findAll()).thenReturn(imagesList);

        ArrayList<ImagesGalleryModels> result = imagesGalleryServices.getImages();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(imagesGalleryRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        ImagesGalleryModels image = new ImagesGalleryModels();
        when(imagesGalleryRepository.findById(1L)).thenReturn(Optional.of(image));

        ImagesGalleryModels result = imagesGalleryServices.getById(1L);

        assertNotNull(result);
        verify(imagesGalleryRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveImages() {
        ImagesGalleryModels image = new ImagesGalleryModels();
        when(imagesGalleryRepository.save(image)).thenReturn(image);

        ImagesGalleryModels result = imagesGalleryServices.saveImages(image);

        assertNotNull(result);
        verify(imagesGalleryRepository, times(1)).save(image);
    }

    @Test
    void testUpdateImage() {
        ImagesGalleryModels image = new ImagesGalleryModels();
        imagesGalleryServices.updateImage(image);

        verify(imagesGalleryRepository, times(1)).save(image);
    }

    @Test
    void testDeleteImages() {
        doNothing().when(imagesGalleryRepository).deleteById(1L);

        String result = imagesGalleryServices.deleteImages(1L);

        assertEquals("todo ok", result);
        verify(imagesGalleryRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteImages_Exception() {
        doThrow(new RuntimeException()).when(imagesGalleryRepository).deleteById(1L);

        String result = imagesGalleryServices.deleteImages(1L);

        assertEquals("todo mal", result);
        verify(imagesGalleryRepository, times(1)).deleteById(1L);
    }
}
