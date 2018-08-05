package com.potsane.gitrepos.repository;

import com.potsane.gitrepos.model.SearchResponse;
import com.potsane.gitrepos.network.GithubApi;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by PMohale on 2018/07/30.
 */

public class GithubRepositoryImpl implements GithubRepository {

    private GithubApi githubApi;

    @Inject
    public GithubRepositoryImpl(GithubApi githubApi) {
        this.githubApi = githubApi;
    }

    @Override
    public Call<SearchResponse> search(String query) {
        return githubApi.searchRepos(query);
    }
}
