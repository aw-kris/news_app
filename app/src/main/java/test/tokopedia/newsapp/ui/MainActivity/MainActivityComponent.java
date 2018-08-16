package test.tokopedia.newsapp.ui.MainActivity;

import dagger.Subcomponent;
import test.tokopedia.newsapp.di.scope.ActivityScope;
import test.tokopedia.newsapp.model.SourceModel;

/**
 * Created by Kharisma AW on 8/14/2018.
 */
@ActivityScope
@Subcomponent(
        modules = MainActivityModule.class
)
public interface MainActivityComponent {
    MainActivity inject(MainActivity mainActivity);
    SourceModel sourceModel();
}
