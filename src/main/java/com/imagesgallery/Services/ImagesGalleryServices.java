package com.imagesgallery.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.imagesgallery.Models.ImagesGalleryModels;
import com.imagesgallery.Repositories.IimagesGalleryRepository;
import org.springframework.stereotype.Service;


@Service
public class ImagesGalleryServices {
    @Autowired
    IimagesGalleryRepository imagesGalleryRepository;

    public ArrayList<ImagesGalleryModels> getImages(){
        return (ArrayList<ImagesGalleryModels>) imagesGalleryRepository.findAll();
    }

    public Optional<ImagesGalleryModels> getById(Long id){
        return imagesGalleryRepository.findById(id);
    }

    public ImagesGalleryModels saveImages(ImagesGalleryModels images ){
        return imagesGalleryRepository.save(images);
    }

    public ImagesGalleryModels updateById(ImagesGalleryModels Request){
        ImagesGalleryModels images = imagesGalleryRepository.findById(Request.getId()).get();

        images.setImageUrl(Request.getImageUrl());
        images.setTitle(Request.getTitle());
        images.setDescription(Request.getDescription());

        return imagesGalleryRepository.save(images);
    }

    public String deleteImages(Long id){
        try{
            imagesGalleryRepository.deleteById(id);
            return "todo ok";
        }catch (Exception error){
        return "todo mal";
    }
}
    
}
