package com.example.vartartistserver.gallery.Service;

import com.example.vartartistserver.gallery.DTO.GalleryDTO;
import com.example.vartartistserver.gallery.repository.GalleryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GalleryService {
    private final GalleryRepository galleryRepository;

    public Boolean publish(GalleryDTO galleryDTO) {
        try {
            galleryRepository.save(GalleryDTO.toGallery(galleryDTO));
            return true;
        } catch (Exception e) {
            log.error("갤러리 저장 중 예외 발생: {}", e.getMessage(), e);
            return false;
        }
    }
}
