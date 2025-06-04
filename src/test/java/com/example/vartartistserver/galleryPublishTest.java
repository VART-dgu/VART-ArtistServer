package com.example.vartartistserver;

// 예: PublishServiceTest.java
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.vartartistserver.gallery.DTO.PublishRequestDTO;
import com.example.vartartistserver.gallery.Service.GalleryService;
import com.example.vartartistserver.gallery.entity.Gallery;
import com.example.vartartistserver.gallery.repository.GalleryRepository;
import com.example.vartartistserver.user.entity.Artist;
import com.example.vartartistserver.user.repository.ArtistRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

class PublishServiceTest {

    @InjectMocks
    private GalleryService publishService;

    @Mock
    private ArtistRepository artistRepository;

    @Mock
    private GalleryRepository galleryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // @InjectMocks, @Mock 초기화
    }

    @Test
    void testPublish_Success() {
        // given
        Long artistId = 1L;
        PublishRequestDTO requestDTO = new PublishRequestDTO();
        requestDTO.setArtistId(artistId);
        requestDTO.setDescription("테스트 설명");
        requestDTO.setName("테스트 이름");

        Artist mockArtist = new Artist();
        mockArtist.setSeq(artistId);

        when(artistRepository.findById(artistId)).thenReturn(Optional.of(mockArtist));
        when(galleryRepository.findAllByArtist_Seq(artistId)).thenReturn(Collections.emptyList());
        when(galleryRepository.save(any(Gallery.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // when
        int nextId = publishService.publish(requestDTO);

        // then
        assertEquals(1, nextId); // 기존 갤러리가 없으면 1
        verify(artistRepository).findById(artistId);
        verify(galleryRepository).findAllByArtist_Seq(artistId);
        verify(galleryRepository).save(any(Gallery.class));
    }
}