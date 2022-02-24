package uz.doston.springcrm.service.base;

import uz.doston.springcrm.dto.BaseDto;
import uz.doston.springcrm.dto.BaseGenericDto;

public interface GenericCrudService<D extends BaseGenericDto, CD extends BaseDto, UD extends BaseGenericDto>
        extends GenericService<D> {

    void delete(Long id);

    void create(CD cd);

    void update(UD ud);

}
