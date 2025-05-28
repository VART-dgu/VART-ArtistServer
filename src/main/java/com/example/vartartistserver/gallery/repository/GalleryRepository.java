package com.example.vartartistserver.gallery.repository;

import com.example.vartartistserver.gallery.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
