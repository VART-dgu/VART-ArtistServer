package com.example.vartartistserver.domain.user.repository;

import com.example.vartartistserver.domain.user.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    // save, findById 등은 JpaRepository가 제공하니까 선언 안 해도 됨
}