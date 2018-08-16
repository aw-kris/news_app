package test.tokopedia.newsapp.di.component;

import javax.inject.Singleton;

import dagger.Component;
import test.tokopedia.newsapp.di.module.AppModule;
import test.tokopedia.newsapp.di.module.NetworkModule;
import test.tokopedia.newsapp.ui.ArticleListActivity.ArticleListActivityComponent;
import test.tokopedia.newsapp.ui.ArticleListActivity.ArticleListActivityModule;
import test.tokopedia.newsapp.ui.MainActivity.MainActivityModule;
import test.tokopedia.newsapp.ui.MainActivity.MainActivityComponent;

/**
 * Created by Kharisma AW on 8/14/2018.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class
        }
)
public interface AppComponent {
    MainActivityComponent plus(MainActivityModule mainActivityModule);
    ArticleListActivityComponent plus(ArticleListActivityModule articleListActivityModule);
}
