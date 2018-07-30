package com.potsane.gitrepos.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.potsane.gitrepos.R;
import com.potsane.gitrepos.cotract.GithubSearchContract;
import com.potsane.gitrepos.model.SearchResult;
import com.potsane.gitrepos.view.adapter.GithubSearchResultAdapter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements GithubSearchContract.View {

    @Inject
    GithubSearchContract.Presenter presenter;

    private GithubSearchResultAdapter resultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupEditText();
    }

    private void setupEditText() {
        final EditText searchQueryEditText = findViewById(R.id.et_search_query);

        searchQueryEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    search(searchQueryEditText.getText().toString());
                }
                return false;
            }
        });
    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    @Override
    public void showSearchResults(List<SearchResult> searchResults) {

    }

    private void search(String query) {
        presenter.search(query);
    }
}
