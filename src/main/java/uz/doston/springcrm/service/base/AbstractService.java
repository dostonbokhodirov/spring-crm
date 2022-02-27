package uz.doston.springcrm.service.base;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.doston.springcrm.entity.organization.Logo;
import uz.doston.springcrm.mapper.BaseMapper;
import uz.doston.springcrm.repository.BaseRepository;

@Service
public abstract class AbstractService<M extends BaseMapper, R extends BaseRepository> implements BaseService {


    protected final M mapper;
    protected final R repository;

    public AbstractService(M mapper, R repository) {
        this.mapper = mapper;
        this.repository = repository;
    }
    public AbstractService(R repository) {
        this.mapper = null;
        this.repository = repository;
    }

}
