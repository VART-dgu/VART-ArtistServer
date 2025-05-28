package com.example.vartartistserver.gallery.Controller;

import com.example.vartartistserver.gallery.DTO.GalleryDTO;
import com.example.vartartistserver.gallery.Service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{galleryId}")
    public ResponseEntity<String> delete(@PathVariable Long galleryId){
        galleryService.delete(galleryId);
        return ResponseEntity.ok("삭제 완료");
    }
}
