package com.example.vartartistserver.user.controller;

import com.example.vartartistserver.user.service.ArtistService;
import com.example.vartartistserver.user.dto.ArtistRegisterRequestDTO;
import com.example.vartartistserver.user.dto.ArtistLoginRequestDTO;
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
  
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody ArtistLoginRequestDTO dto) {
        boolean result = artistService.login(dto);
        if (result) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.status(401).body("로그인 실패: 존재하지 않는 작가입니다.");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        artistService.logout(); // 요청 없이 로그아웃 처리
        return ResponseEntity.ok("로그아웃 성공");
    }
}