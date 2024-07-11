package com.imagesgallery.Controllers;

import org.apache.catalina.connector.Request;
import org.apache.tomcat.util.openssl.pem_password_cb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResquetMapping("/")
@CrossOrigin(Origins = "*")

public class ImageGalleryControllers {
    
    @Autowired
    ImagesService ImagesService;

    @GetMapping(path = "/images")
    public ArrayList<Images> getAllImages() {
        return imagesService.getAllImages();
    }

    @GetMapping(path = "/id")
    public ArrayList<Image> getImageById() {
        return imagesService.getImageById();
    }

    @PostMapping(path = "/images")
    public Images addImage(@RequestBody Image newImage) {
        return imagesService.addImage(newImage);
    }

    @PutMapping(path = "/images")
    public ArrayList<Image> updateImage() {
        return imagesService.updateImage();
    }

    @DeleteMapping(path = "/image/{id}")
    public Request deleteImage(@PathVariable Long id) {
		imagesService.deleteImage();
	}

}

