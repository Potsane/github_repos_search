package com.potsane.gitrepos.injection;

import com.potsane.gitrepos.cotract.GithubSearchContract;
import com.potsane.gitrepos.network.GithubApi;
import com.potsane.gitrepos.presenter.GithubPresenterImpl;
import com.potsane.gitrepos.repository.GithubRepository;
import com.potsane.gitrepos.repository.GithubRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PMohale on 2018/07/23.
 */

@Module(includes = {AndroidInjectionModule.class})
public class AppModule {

    @Provides
    GithubSearchContract.Presenter providesPresenter(GithubRepository repository, GithubSearchContract.View view) {
        return new GithubPresenterImpl(repository, view);
    }

    @Provides
    GithubRepository providesGithubRepository(GithubApi githubApi) {
        return new GithubRepositoryImpl(githubApi);
    }

    @Provides
    @Singleton
    GithubApi providesGithubApi(Retrofit retrofit) {
        return retrofit.create(GithubApi.class);
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com")
                .build();
    }
}
