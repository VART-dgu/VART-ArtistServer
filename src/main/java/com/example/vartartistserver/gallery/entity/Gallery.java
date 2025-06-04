package com.example.vartartistserver.gallery.entity;

import com.example.vartartistserver.user.entity.Artist;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gallery {
    @Id @GeneratedValue
    private Long id;

    private Integer galleryId;
    private String name;
    private String description;
    private String mapFile;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;
}
