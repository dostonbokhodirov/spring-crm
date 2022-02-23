package uz.doston.springcrm.service.base;

import org.springframework.web.multipart.MultipartFile;
import uz.doston.springcrm.dto.BaseDto;
import uz.doston.springcrm.dto.BaseGenericDto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface GenericCrudService<CD extends BaseDto,UD extends BaseGenericDto> {


    void delete(Long id);

    void  create(CD cd);

    void update(UD ud);



}
