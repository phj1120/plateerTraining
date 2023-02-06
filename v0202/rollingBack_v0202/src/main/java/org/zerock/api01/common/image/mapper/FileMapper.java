package org.zerock.api01.common.image.mapper;

import org.zerock.api01.common.image.dto.FileDTO;

import java.util.List;

public interface FileMapper {
    int addFile(FileDTO fileDTO);

    int setRollingId(Long id, List<String> names);

    List<String> getImagePaths(Long id);

    int deleteById(Long id);

    int deleteImageByRollingId(Long rollingId);
}
