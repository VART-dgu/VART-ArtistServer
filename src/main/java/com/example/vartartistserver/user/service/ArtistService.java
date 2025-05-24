package com.example.vartartistserver.user.service;

import com.example.vartartistserver.user.dto.ArtistRegisterRequestDTO;
import com.example.vartartistserver.user.entity.Artist;
import com.example.vartartistserver.user.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;

    public void register(ArtistRegisterRequestDTO dto) {
        Artist artist = Artist.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
        artistRepository.save(artist);
    }
}