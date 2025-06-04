package com.example.vartartistserver.gallery.Controller;

import com.example.vartartistserver.gallery.DTO.PublishRequestDTO;
import com.example.vartartistserver.gallery.Service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artist/gallery")
@RequiredArgsConstructor
public class GalleryController {
    private final GalleryService galleryService;

    @PostMapping("/publish")
    public ResponseEntity<Integer> publish(@RequestBody PublishRequestDTO galleryDTO){
        int nextId = galleryService.publish(galleryDTO);

        return ResponseEntity.ok(nextId);
    }

    @DeleteMapping("/{galleryId}")
    public ResponseEntity<String> delete(@PathVariable int galleryId){
        galleryService.delete(galleryId);
        return ResponseEntity.ok("삭제 완료");
    }
}
