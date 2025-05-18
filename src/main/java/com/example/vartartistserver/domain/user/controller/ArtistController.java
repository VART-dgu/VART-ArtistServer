package com.example.vartartistserver.domain.user.controller;

import com.example.vartartistserver.domain.user.service.ArtistService;
import com.example.vartartistserver.domain.user.dto.ArtistRegisterRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/artist")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody ArtistRegisterRequestDTO dto) {
        artistService.register(dto);
        return ResponseEntity.ok("회원가입 성공");
    }
}