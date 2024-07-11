package com.imagesgallery.Controllers;

import com.imagesgallery.Models.ImagesGalleryModels;
import com.imagesgallery.Services.ImagesGalleryServices;
import jakarta.persistence.Id;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class ImagesGalleryControllers {
    
    @Autowired
    ImagesGalleryServices imagesGalleryServices;

    @GetMapping(path = "/images")
    public ArrayList<ImagesGalleryModels> getAllImages() {
        return imagesGalleryServices.getImages();
    }

    @GetMapping(path = "/images/{id}")
    public Optional<ImagesGalleryModels> getImageById(Long id) {
        return imagesGalleryServices.getById(id);
    }

    @PostMapping(path = "/images")
    public ImagesGalleryModels addImage(@RequestBody ImagesGalleryModels newImage) {
        return imagesGalleryServices.saveImages(newImage);
    }

    @PutMapping(path = "/images")
    public ImagesGalleryModels updateImageGallery(@RequestBody ImagesGalleryModels ImagesGalleryModels) {
        return imagesGalleryServices.updateById(ImagesGalleryModels);
    }

    @DeleteMapping(path = "/images/{id}")
    public String deleteImage(@PathVariable("id") Long id) {
		return imagesGalleryServices.deleteImages(id);
	}

}

