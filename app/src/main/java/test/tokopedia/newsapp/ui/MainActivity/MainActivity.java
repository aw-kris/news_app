package test.tokopedia.newsapp.ui.MainActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.tokopedia.newsapp.NewsApp;
import test.tokopedia.newsapp.R;
import test.tokopedia.newsapp.adapter.NewsSourceListAdapter;
import test.tokopedia.newsapp.data.SourceData;
import test.tokopedia.newsapp.ui.ArticleListActivity.ArticleListActivity;

/**
 * Created by Kharisma AW on 8/13/2018.
 */
public class MainActivity extends AppCompatActivity implements MainActivityContract.View{
    @Inject
    MainActivityPresenter mainActivityPresenter;
    @BindView(R.id.news_source_list)
    RecyclerView mSourcesList;
    @BindView(R.id.main_progress_bar)
    ProgressBar mProgressBar;

    private MainActivityContract.Presenter mPresenter;
    private GridLayoutManager mGridLayoutManager;
    private NewsSourceListAdapter mNewsSourceListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupActivityComponent();
        mPresenter = mainActivityPresenter;
        mainActivityPresenter.setView(this);
        initializeData();
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private void setupActivityComponent() {
        NewsApp.get()
                .getAppComponent()
                .plus(new MainActivityModule(this))
                .inject(this);
    }


    @Override
    public void setAdapter(List<SourceData> sourceDataList) {
        mGridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        mSourcesList.setLayoutManager(mGridLayoutManager);
        mNewsSourceListAdapter = new NewsSourceListAdapter(sourceDataList, this);
        mSourcesList.setAdapter(mNewsSourceListAdapter);
    }

    @Override
    public void initializeData() {
        mPresenter.getSourcesData();
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

//    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage(R.string.exit_confirmation_msg);
//        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                // User clicked OK button
//                finish();
//            }
//        });
//        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                dialog.dismiss();
//            }
//        });
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }
}
