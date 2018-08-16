package test.tokopedia.newsapp.ui.ArticleListActivity;

import android.util.Log;

import io.reactivex.subscribers.ResourceSubscriber;
import test.tokopedia.newsapp.Repository.MainRepository;
import test.tokopedia.newsapp.data.Article;
import test.tokopedia.newsapp.data.Source;
import test.tokopedia.newsapp.helper.Constant;

/**
 * Created by Kharisma AW on 8/15/2018.
 */
public class ArticleListActivityPresenter implements ArticleListActivityContract.Presenter{
    private final static String LOG_TAG = "ArticleListActPresenter";

    private ArticleListActivityContract.View mView;
    private MainRepository mMainRepository;

    public ArticleListActivityPresenter(MainRepository mMainRepository) {
        this.mMainRepository = mMainRepository;
    }

    public void setView(ArticleListActivityContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getArticleData(final String source, final int page) {
        String url = Constant.ARTICLES + source + "&" + Constant.PAGE + page + "&" + Constant.API_KEY;
        Log.d(LOG_TAG, url);
        mView.showProgressBar();
        mMainRepository.getArticles(url)
                .subscribe(new ResourceSubscriber<Article>() {
                    @Override
                    public void onNext(Article article) {
                        mView.hideProgressBar();
                        mView.setCurPage(page);
                        mView.setPrevBtnVisibility();
                        mView.setAdapter(article.getArticles());
                    }

                    @Override
                    public void onError(Throwable t) {
                        mView.hideProgressBar();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void searchArticleQuery(String source, String keyword) {
        String url = Constant.ARTICLES + source + "&" + Constant.KEYWORD + keyword + "&" + Constant.API_KEY;
        Log.d(LOG_TAG, url);
        mView.showProgressBar();
        mMainRepository.getArticles(url)
                .subscribe(new ResourceSubscriber<Article>() {
                    @Override
                    public void onNext(Article article) {
                        mView.hideProgressBar();
                        mView.setCurPage(0);
                        mView.setBtnContainerVisibility();
                        mView.setAdapter(article.getArticles());
                    }

                    @Override
                    public void onError(Throwable t) {
                        mView.hideProgressBar();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
