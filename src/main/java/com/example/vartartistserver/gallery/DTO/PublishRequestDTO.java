package com.example.vartartistserver.gallery.DTO;

import com.example.vartartistserver.gallery.entity.Gallery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
@AllArgsConstructor
public class PublishRequestDTO {
    private Long artistId;
    private String name;
    private String description;
    private String mapFile;

    public PublishRequestDTO() {

    }

    public static Gallery toGallery(PublishRequestDTO dto){
        return Gallery.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .mapFile(dto.getMapFile())
                .build();
    }

    public static PublishRequestDTO toPublishRequestDTO(Gallery gallery){
        return PublishRequestDTO.builder()
                .name(gallery.getName())
                .description(gallery.getDescription())
                .mapFile(gallery.getMapFile())
                .build();
    }
}
