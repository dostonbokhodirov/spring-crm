package uz.doston.springcrm.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService <D extends BaseGenericDto>{

    List<D> getAll();

    D get(String id);

}
