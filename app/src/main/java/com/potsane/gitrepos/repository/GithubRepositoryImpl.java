package com.potsane.gitrepos.repository;

import com.potsane.gitrepos.network.GithubApi;

/**
 * Created by PMohale on 2018/07/30.
 */

public class GithubRepositoryImpl implements GithubRepository {

    private GithubApi githubApi;

    @Override
    public void search(String query) {
        githubApi.searchRepos(query);
    }
}
