package com.example.vartartistserver.gallery.Controller;

import com.example.vartartistserver.gallery.DTO.GalleryDTO;
import com.example.vartartistserver.gallery.Service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist/gallery")
@RequiredArgsConstructor
public class GalleryController {
    private final GalleryService galleryService;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody GalleryDTO galleryDTO){
        galleryService.publish(galleryDTO);

        return ResponseEntity.ok("등록 완료");
    }
}
