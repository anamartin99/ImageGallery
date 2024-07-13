package com.imagesgallery.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imagesgallery.Models.ImagesGalleryModels;
import com.imagesgallery.Services.ImagesGalleryServices;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class ImagesGalleryControllers {
    
    @Autowired
    ImagesGalleryServices imagesGalleryServices;

    @GetMapping(path = "")
    public ArrayList<ImagesGalleryModels> getAllImages() {
        return imagesGalleryServices.getImages();
    }

   @GetMapping(path = "/images/{id}")
    public Optional<ImagesGalleryModels> getImageById(@PathVariable("id") Long id) {
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

