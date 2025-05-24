package com.example.vartartistserver.domain.user.service;

import com.example.vartartistserver.domain.user.dto.ArtistRegisterRequestDTO;
import com.example.vartartistserver.domain.user.dto.ArtistLoginRequestDTO;
import com.example.vartartistserver.domain.user.entity.Artist;
import com.example.vartartistserver.domain.user.repository.ArtistRepository;
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
    public boolean login(ArtistLoginRequestDTO dto) {
        return artistRepository.findById(dto.getId()).isPresent();
    }

    public void logout() {
        // 실제 로그아웃 처리 로직이 없으면 단순 로그로 대체
        System.out.println("작가 로그아웃 완료");
    }
}
