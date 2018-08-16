package test.tokopedia.newsapp.ui.ArticleListActivity;

import dagger.Module;
import dagger.Provides;
import test.tokopedia.newsapp.Repository.MainRepository;
import test.tokopedia.newsapp.di.scope.ActivityScope;
import test.tokopedia.newsapp.network.NetworkService;

/**
 * Created by Kharisma AW on 8/15/2018.
 */
@Module
public class ArticleListActivityModule {
    private ArticleListActivity articleListActivity;

    public ArticleListActivityModule(ArticleListActivity articleListActivity) {
        this.articleListActivity = articleListActivity;
    }

    @Provides
    @ActivityScope
    ArticleListActivity provideArticleListActivity() {
        return articleListActivity;
    }

    @Provides
    @ActivityScope
    MainRepository provideMainRepository(NetworkService networkService) {
        return new MainRepository(networkService);
    }

    @Provides
    @ActivityScope
    ArticleListActivityPresenter provideArticleListActivityPresenter(MainRepository mainRepository) {
        return new ArticleListActivityPresenter(mainRepository);
    }
}
