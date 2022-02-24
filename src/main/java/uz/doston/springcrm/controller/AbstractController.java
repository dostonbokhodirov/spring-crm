package uz.doston.springcrm.controller;

import org.springframework.stereotype.Component;
import uz.doston.springcrm.service.base.BaseService;


public abstract class AbstractController<S extends BaseService> {
     protected S service;

    public AbstractController(S service) {
        this.service = service;
    }
}
