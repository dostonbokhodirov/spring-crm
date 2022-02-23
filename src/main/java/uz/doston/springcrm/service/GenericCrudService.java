package uz.doston.springcrm.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface GenericCrudService<CD extends BaseDto,UD extends BaseGenericDto> {


    void delete(String id);

    void  create(CD cd);

    void update(UD ud);



}
