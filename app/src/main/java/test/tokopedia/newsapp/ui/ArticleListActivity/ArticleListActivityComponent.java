package test.tokopedia.newsapp.ui.ArticleListActivity;

import dagger.Subcomponent;
import test.tokopedia.newsapp.di.scope.ActivityScope;

/**
 * Created by Kharisma AW on 8/15/2018.
 */
@ActivityScope
@Subcomponent(
        modules = ArticleListActivityModule.class
)
public interface ArticleListActivityComponent {
    ArticleListActivity inject(ArticleListActivity articleListActivity);
}
