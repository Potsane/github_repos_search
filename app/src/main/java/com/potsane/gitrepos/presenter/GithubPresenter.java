package com.potsane.gitrepos.presenter;

import com.potsane.gitrepos.cotract.GithubSearchContract;
import com.potsane.gitrepos.repository.GithubRepository;

/**
 * Created by PMohale on 2018/07/30.
 */

public class GithubPresenter implements GithubSearchContract.Presenter {

    private GithubRepository repository;

    private GithubSearchContract.View view;


    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void search(String query) {

    }
}
