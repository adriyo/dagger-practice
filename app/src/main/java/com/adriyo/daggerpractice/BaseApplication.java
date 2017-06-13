package com.adriyo.daggerpractice;

import android.app.Application;

import com.adriyo.daggerpractice.data.DaggerDataComponent;
import com.adriyo.daggerpractice.data.DataComponent;
import com.adriyo.daggerpractice.data.DataModule;

/**
 * Created by adriyo on 13/06/17.
 * adriyo.github.io
 */

public class BaseApplication extends Application {

    private static BaseApplication application;
    DataComponent dataComponent;

    public static BaseApplication getBaseApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initDataComponent();

        application = this;
        dataComponent.inject(this);
    }

    private void initDataComponent() {
        dataComponent = DaggerDataComponent.builder()
                .dataModule(new DataModule(this))
                .build();
    }

    public DataComponent getDataComponent() {
        return dataComponent;
    }
}
