package com.adriyo.daggerpractice.network;

import java.util.HashMap;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by adriyo on 13/06/17.
 * adriyo.github.io
 */

public class Repository {

    private Service service;

    @Inject
    public Repository(Service service) {
        this.service = service;
    }

    public Observable<PeopleResponse> getPeopleData(HashMap<String, Integer> param) {
        return service.getPeople(param);
    }
}
