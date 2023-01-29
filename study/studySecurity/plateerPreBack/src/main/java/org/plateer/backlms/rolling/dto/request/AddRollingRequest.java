package org.plateer.backlms.rolling.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.plateer.backlms.rolling.dto.RollingDTO;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddRollingRequest {
    private String title;
    private Long writerId;
    private String target;
    private String imgSrc;

    public RollingDTO convert() {
        return RollingDTO.builder()
                .title(title)
                .writerId(writerId)
                .target(target)
                .imgSrc(imgSrc)
                .createDt(LocalDate.now())
                .build();
    }

}
