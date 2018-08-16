package test.tokopedia.newsapp.ui.ArticleListActivity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.tokopedia.newsapp.NewsApp;
import test.tokopedia.newsapp.R;
import test.tokopedia.newsapp.adapter.ArticleListAdapter;
import test.tokopedia.newsapp.data.ArticleData;

/**
 * Created by Kharisma AW on 8/14/2018.
 */
public class ArticleListActivity extends AppCompatActivity implements ArticleListActivityContract.View {
    @Inject
    ArticleListActivityPresenter articleListActivityPresenter;
    @BindView(R.id.news_article_list)
    RecyclerView mArticleList;
    @BindView(R.id.article_progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.button_container)
    ConstraintLayout btnContainer;
    @BindView(R.id.next_btn)
    Button nextBtn;
    @BindView(R.id.prev_btn)
    Button prevBtn;

    private final static String LOG_TAG = "ArticleListActivity";

    private ArticleListActivityContract.Presenter mPresenter;
    private GridLayoutManager mGridLayoutManager;
    private ArticleListAdapter mArticleListAdapter;

    private String source;
    private int curPage = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);

        source = getIntent().getExtras().getString("source");
        Log.d(LOG_TAG, source);
        setupActivityComponent();
        mPresenter = articleListActivityPresenter;
        articleListActivityPresenter.setView(this);
        initializeData();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initializeData();
            }
        });

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPrevPage();
            }
        });
    }

    private void setupActivityComponent() {
        NewsApp.get()
                .getAppComponent()
                .plus(new ArticleListActivityModule(this))
                .inject(this);
    }

    @Override
    public void setAdapter(List<ArticleData> articleDataList) {
        mGridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        mArticleList.setLayoutManager(mGridLayoutManager);
        mArticleListAdapter = new ArticleListAdapter(articleDataList, this);
        mArticleList.setAdapter(mArticleListAdapter);
    }

    @Override
    public void initializeData() {
        mPresenter.getArticleData(source, curPage + 1);
    }

    @Override
    public void requestPrevPage() {
        mPresenter.getArticleData(source, curPage - 1);
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setBtnContainerVisibility() {
        if (curPage < 1) {
            btnContainer.setVisibility(View.GONE);
        } else {
            btnContainer.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setPrevBtnVisibility() {
        if(curPage > 1)
            prevBtn.setVisibility(View.VISIBLE);
        else
            prevBtn.setVisibility(View.GONE);
    }

    @Override
    public void setCurPage(int page) {
        curPage = page;
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setQueryHint("search keyword");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchView.clearFocus();
                mPresenter.searchArticleQuery(source, s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return true;
            }
        });
        return true;
    }
}
