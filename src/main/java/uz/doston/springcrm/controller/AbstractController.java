package uz.doston.springcrm.controller;

import uz.doston.springcrm.service.BaseService;

public abstract class AbstractController<S extends BaseService> {
     protected S service;

    public AbstractController(S service) {
        this.service = service;
    }
}
