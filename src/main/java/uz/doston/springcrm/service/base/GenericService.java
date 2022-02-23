package uz.doston.springcrm.service.base;

import uz.doston.springcrm.dto.BaseGenericDto;

import java.util.List;

public interface GenericService<D extends BaseGenericDto> {

    List<D> getAll();

    D get(Long id);

}
