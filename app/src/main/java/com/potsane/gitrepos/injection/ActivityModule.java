package com.potsane.gitrepos.injection;

import com.potsane.gitrepos.view.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by PMohale on 2018/07/23.
 */

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
