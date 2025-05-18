package com.example.vartartistserver.domain.user.service;

import com.example.vartartistserver.domain.user.dto.ArtistRegisterRequestDTO;
import com.example.vartartistserver.domain.user.entity.Artist;
import com.example.vartartistserver.domain.user.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    public void register(ArtistRegisterRequestDTO dto) {
        Artist artist = new Artist(dto.getId(), dto.getName());
        artistRepository.save(artist);
    }
}