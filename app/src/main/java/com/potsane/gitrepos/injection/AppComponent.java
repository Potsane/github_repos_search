package com.potsane.gitrepos.injection;

import com.potsane.gitrepos.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by PMohale on 2018/07/23.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityModule.class})
public interface AppComponent {

    void inject(App application);

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(App application);

        AppComponent build();
    }
}
