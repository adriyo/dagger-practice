package com.adriyo.daggerpractice.network;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by adriyo on 13/06/17.
 * adriyo.github.io
 */

public interface Service {
    @GET("people")
    Observable<PeopleResponse> getPeople(
            @QueryMap Map<String, Integer> page
    );

}
