package com.imagesgallery.Controllers;

import com.imagesgallery.Models.ImagesGalleryModels;
import com.imagesgallery.Services.ImagesGalleryServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ImagesGalleryControllers.class)
class ImagesGalleryControllersTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ImagesGalleryServices imagesGalleryServices;

    @Test
    void testGetAllImages() throws Exception {
        when(imagesGalleryServices.getImages()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(imagesGalleryServices, times(1)).getImages();
    }

    @Test
    void testGetImageById() throws Exception {
        ImagesGalleryModels image = new ImagesGalleryModels();
        image.setId(1L);  


        when(imagesGalleryServices.getById(1L)).thenReturn(image);

        mockMvc.perform(get("/images/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));

        verify(imagesGalleryServices, times(1)).getById(1L);
    }


    @Test
    void testAddImage() throws Exception {
        ImagesGalleryModels image = new ImagesGalleryModels();
        image.setId(1L);

        when(imagesGalleryServices.saveImages(any(ImagesGalleryModels.class))).thenReturn(image);

        mockMvc.perform(post("/images")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"test\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));

        verify(imagesGalleryServices, times(1)).saveImages(any(ImagesGalleryModels.class));
    }

    @Test
    void testUpdateImage() throws Exception {
        doNothing().when(imagesGalleryServices).updateImage(any(ImagesGalleryModels.class));

        mockMvc.perform(put("/images/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"updated\"}"))
                .andExpect(status().isOk());

        verify(imagesGalleryServices, times(1)).updateImage(any(ImagesGalleryModels.class));
    }

    @Test
    void testDeleteImage() throws Exception {
        when(imagesGalleryServices.deleteImages(1L)).thenReturn("todo ok");

        mockMvc.perform(delete("/images/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("todo ok"));

        verify(imagesGalleryServices, times(1)).deleteImages(1L);
    }
}
