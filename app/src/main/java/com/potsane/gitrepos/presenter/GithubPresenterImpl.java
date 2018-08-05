package com.potsane.gitrepos.presenter;

import android.support.annotation.NonNull;

import com.potsane.gitrepos.cotract.GithubSearchContract;
import com.potsane.gitrepos.model.SearchResponse;
import com.potsane.gitrepos.repository.GithubRepository;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by PMohale on 2018/07/30.
 */

public class GithubPresenterImpl implements GithubSearchContract.Presenter {

    private GithubRepository repository;

    private GithubSearchContract.View view;

    @Inject
    public GithubPresenterImpl(GithubRepository repository, GithubSearchContract.View view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void search(String query) {

        Call<SearchResponse> call = repository.search(query);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                handleResponse(response);
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                showError("E103 - System error");
            }
        });
    }

    private void handleResponse(@NonNull Response<SearchResponse> response) {
        if (response.isSuccessful()) {
            SearchResponse searchResponse = response.body();
            if (searchResponse != null) {
                showResults(searchResponse);
            } else {
                showError("E102 - System error");
            }
        } else {
            showError("E101 - System error");
        }
    }

    private void showError(String errorMessage) {
        view.showErrorMessage(errorMessage);
    }

    private void showResults(SearchResponse searchResponse) {
        view.showSearchResults(searchResponse.getSearchResults());
    }
}
