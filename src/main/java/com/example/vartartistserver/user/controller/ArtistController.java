package com.example.vartartistserver.user.controller;

import com.example.vartartistserver.user.service.ArtistService;
import com.example.vartartistserver.user.dto.ArtistRegisterRequestDTO;
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