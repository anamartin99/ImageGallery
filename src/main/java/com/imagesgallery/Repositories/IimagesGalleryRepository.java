package com.imagesgallery.Repositories;

import com.imagesgallery.Models.ImagesGalleryModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IimagesGalleryRepository extends JpaRepository<ImagesGalleryModels, Long> {
}
