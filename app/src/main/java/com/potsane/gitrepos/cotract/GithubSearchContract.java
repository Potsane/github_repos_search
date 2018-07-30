package com.potsane.gitrepos.cotract;

import com.potsane.gitrepos.model.SearchResult;

import java.util.List;

/**
 * Created by PMohale on 2018/07/24.
 */

public class GithubSearchContract {

    public interface View {

        void showErrorMessage(String errorMessage);

        void showSearchResults(List<SearchResult> searchResults);
    }

    public interface Presenter {

        void onSuccess();

        void onError();

        void search(String query);
    }
}
