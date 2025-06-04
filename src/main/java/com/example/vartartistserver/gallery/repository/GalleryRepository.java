package com.example.vartartistserver.gallery.repository;

import com.example.vartartistserver.gallery.entity.Gallery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
    @Modifying
    @Transactional
    int deleteGalleryByGalleryId(Integer galleryId);

    List<Gallery> findAllByArtist_Seq(Long artistId);
}
