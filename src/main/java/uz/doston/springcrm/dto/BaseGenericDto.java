package uz.doston.springcrm.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public abstract class BaseGenericDto {
    private Long id;
}
