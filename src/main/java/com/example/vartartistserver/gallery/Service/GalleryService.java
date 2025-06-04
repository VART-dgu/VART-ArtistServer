package com.example.vartartistserver.gallery.Service;

import com.example.vartartistserver.gallery.DTO.PublishRequestDTO;
import com.example.vartartistserver.gallery.entity.Gallery;
import com.example.vartartistserver.gallery.repository.GalleryRepository;
import com.example.vartartistserver.user.entity.Artist;
import com.example.vartartistserver.user.repository.ArtistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GalleryService {
    private final GalleryRepository galleryRepository;
    private final ArtistRepository artistRepository;

    @Transactional
    public int publish(PublishRequestDTO publishRequestDTO) {
        try {
            Long artistId = publishRequestDTO.getArtistId();
            Artist artist = artistRepository.findById(artistId)
                    .orElseThrow(() -> new IllegalArgumentException("해당 artistId가 없습니다: " + artistId));
            List<Gallery> galleryList = galleryRepository.findAllByArtist_Seq(artistId);
            
            //작가의 gallery 정보를 가져와서 다음 ID를 추가
            int nextId = galleryList.stream()
                            .map(Gallery::getGalleryId)
                            .max(Comparator.naturalOrder())
                            .map(max -> max + 1)
                            .orElse(1);

            Gallery toSave = PublishRequestDTO.toGallery(publishRequestDTO);
            toSave.setGalleryId(nextId);
            toSave.setArtist(artist);

            galleryRepository.save(toSave);

            return nextId;
        } catch (Exception e) {
            log.error("갤러리 저장 중 예외 발생: {}", e.getMessage(), e);
            return -1;
        }
    }

    public Boolean delete(int galleryId) {
        try {
            galleryRepository.deleteGalleryByGalleryId(galleryId);
            return true;
        } catch (Exception e) {
            log.error("갤러리 삭제 중 예외 발생: {}", e.getMessage(), e);
            return false;
        }
    }
}
