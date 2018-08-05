package com.potsane.gitrepos.injection;

import com.potsane.gitrepos.cotract.GithubSearchContract;

import dagger.Binds;
import dagger.Module;

/**
 * Created by PMohale on 2018/07/23.
 */

@Module
public abstract class ActivityModule {

    @Binds
    abstract GithubSearchContract.View provieView();
}
