package uz.doston.springcrm.service;

import uz.doston.springcrm.mapper.BaseMapper;
import uz.doston.springcrm.repository.BaseRepository;

public abstract class AbstractService<M extends BaseMapper, R extends BaseRepository> implements BaseService {

    protected final M mapper;
    protected R repository;

    public AbstractService(M mapper, R repository) {
        this.mapper = mapper;
        this.repository = repository;
    }
}
