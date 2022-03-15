package com.debrains.debrainsApi.service;

import com.debrains.debrainsApi.dto.TilCrtDTO;
import com.debrains.debrainsApi.entity.Til;
import com.debrains.debrainsApi.entity.TilCrt;
import com.debrains.debrainsApi.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TilCrtService {

    TilCrt createTilCrts(MultipartFile[] files, TilCrtDTO tilCrtDTO) throws IOException;

    TilCrtDTO updateTilCrt(Long id, MultipartFile[] files, TilCrtDTO tilCrtDTO) throws IOException;

    void deleteTilCrt(TilCrt tilCrt);

    void deleteTilCrtFile(Long id);

    List<TilCrtDTO> tilCrtList(Pageable pageable);

    default TilCrt dtoToEntity(TilCrtDTO tilCrtDTO, Til til) {
        User user = User.builder().id(tilCrtDTO.getUserId()).build();

        TilCrt tilCrt = TilCrt.builder()
                .user(user)
                .til(til)
                .description(tilCrtDTO.getDescription())
                .startTime1(tilCrtDTO.getStartTime1())
                .endTime1(tilCrtDTO.getEndTime1())
                .startTime2(tilCrtDTO.getStartTime2())
                .endTime2(tilCrtDTO.getEndTime2())
                .startTime3(tilCrtDTO.getStartTime3())
                .endTime3(tilCrtDTO.getEndTime3())
                .watchTime(tilCrtDTO.getWatchTime())
                .build();

        return tilCrt;
    }

    TilCrtDTO getTilCrt(Long id);
}
