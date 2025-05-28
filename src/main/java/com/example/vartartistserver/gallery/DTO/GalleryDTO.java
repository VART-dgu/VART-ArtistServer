package com.example.vartartistserver.gallery.DTO;

import com.example.vartartistserver.gallery.entity.Gallery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
@AllArgsConstructor
public class GalleryDTO {
    private Integer galleryId;
    private String name;
    private String description;
    private String mapFile;

    public static Gallery toGallery(GalleryDTO dto){
        return Gallery.builder()
                .galleryId(dto.getGalleryId())
                .name(dto.getName())
                .description(dto.getDescription())
                .mapFile(dto.getMapFile())
                .build();
    }

    public static GalleryDTO toGalleryDTO(Gallery gallery){
        return GalleryDTO.builder()
                .galleryId(gallery.getGalleryId())
                .name(gallery.getName())
                .description(gallery.getDescription())
                .mapFile(gallery.getMapFile())
                .build();
    }
}
