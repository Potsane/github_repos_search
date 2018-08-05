package com.potsane.gitrepos.repository;

import com.potsane.gitrepos.model.SearchResponse;

import retrofit2.Call;

/**
 * Created by PMohale on 2018/07/30.
 */

public interface GithubRepository {

    Call<SearchResponse> search(String query);
}
