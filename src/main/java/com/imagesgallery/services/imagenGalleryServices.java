package com.imagesgallery.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

public class imagenGalleryServices {
    

    @Autowired
    IimagesGalleryRepository imagesGalleryRepository;

    public ArrayList<ImagesGalleryModels> getImages(){
        return (ArrayList<ImagesGalleryModels>) imagesGalleryRepository.findAll();
    }

    public ImagesGalleryModels saveImages(ImagesGalleryModels images ){
        return imagesGalleryRepository.save(images);
    }

    public Optional<imagesGalleryRepository> getById(Long id){
        return imagesGalleryRepository.findById(id);
    }
    public ImagesGalleryModels updateById(ImagesGalleryModels Request){
        ImagesGalleryModels images = imagesGalleryRepository.findById(Request.getId()).get();

        images.setimageUrl(request.getimagenUrl());
        images.settitle(request.gettitle());
        images.setdescription(request.getdescription());

        return imagesGalleryRepository.save(images);

    }

    public Boolean deleteImages (Long id){
        try{
            imagesGalleryRepository.save(images);
            return true;
        }catch (Exception error){
        return false;
    }
}
}
