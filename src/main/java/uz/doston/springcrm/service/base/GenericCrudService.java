package uz.doston.springcrm.service.base;

import uz.doston.springcrm.dto.BaseDto;
import uz.doston.springcrm.dto.BaseGenericDto;

import java.io.IOException;

public interface GenericCrudService<CD extends BaseDto, UD extends BaseGenericDto> {

    void delete(Long id);

    void create(CD cd);

    void update(UD ud) throws IOException;

}
