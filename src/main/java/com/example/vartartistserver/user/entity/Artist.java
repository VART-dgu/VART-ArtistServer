package com.example.vartartistserver.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Builder @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Artist {
    @Id @GeneratedValue
    private Long seq;

    private String id;
    private String name;
}