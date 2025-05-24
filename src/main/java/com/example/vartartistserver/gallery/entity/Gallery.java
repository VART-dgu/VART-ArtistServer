package com.example.vartartistserver.gallery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Gallery {
    @Id @GeneratedValue
    private Long id;

    private Integer galleryId;
    private String name;
    private String description;
    private String mapFile;
}
