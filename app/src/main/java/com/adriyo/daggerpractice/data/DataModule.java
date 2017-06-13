package com.adriyo.daggerpractice.data;

import android.app.Application;

import com.adriyo.daggerpractice.network.Service;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

/**
 * Created by adriyo on 13/06/17.
 * adriyo.github.io
 */

@Module
public class DataModule {

    private static final String BASE_URL = "http://swapi.co/api/";

    private Application application;

    public DataModule(Application application) {
        this.application = application;
    }

    @Provides
    public Service providePeopleService(Retrofit retrofit) {
        return retrofit.create(Service.class);
    }

    @Provides
    @Singleton
    public OkHttpClient provideHttpClient() {
        return new OkHttpClient().newBuilder().build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
