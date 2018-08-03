package com.potsane.gitrepos.network;

import com.potsane.gitrepos.model.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by PMohale on 2018/08/03.
 */

public interface GithubApi {

    @Headers({"Accept: application/vnd.github.mercy-preview+json"})
    @GET("search/repositories")
    Call<SearchResponse> searchRepos(@Query("q") String query);
}
