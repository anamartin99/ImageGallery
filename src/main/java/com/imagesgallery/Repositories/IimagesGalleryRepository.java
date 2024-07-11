package com.imagesgallery.Repositories;

import com.imagesgallery.Models.ImagesGalleryModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IimagesGalleryRepository extends JpaRepository<ImagesGalleryModels, Long> {
}
