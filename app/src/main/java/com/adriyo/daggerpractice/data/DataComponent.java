package com.adriyo.daggerpractice.data;

import com.adriyo.daggerpractice.BaseApplication;
import com.adriyo.daggerpractice.network.Repository;
import com.adriyo.daggerpractice.ui.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by adriyo on 13/06/17.
 * adriyo.github.io
 */

@Singleton
@Component(modules = DataModule.class)
public interface DataComponent {

    void inject(BaseApplication baseApplication);

    void inject(Repository repository);

    void inject(MainViewModel mainViewModel);

}
