package org.zerock.api01.common.image.mapper;

import org.zerock.api01.common.image.dto.FileDTO;

import java.util.List;

public interface FileMapper {
    int addFile(FileDTO fileDTO);
    int setRollingId(Long id, List<String> names);
}
