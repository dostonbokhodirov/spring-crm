package uz.doston.springcrm.service.base;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uz.doston.springcrm.mapper.BaseMapper;
import uz.doston.springcrm.repository.BaseRepository;

@Service
public abstract class AbstractService<M extends BaseMapper, R extends BaseRepository> implements BaseService {

    protected final M mapper;
    protected R repository;



    public AbstractService(M mapper, R repository) {

        this.mapper = mapper;
        this.repository = repository;

    }
}
