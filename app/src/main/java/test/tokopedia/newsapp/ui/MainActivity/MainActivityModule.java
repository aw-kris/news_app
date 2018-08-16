package test.tokopedia.newsapp.ui.MainActivity;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import dagger.Module;
import dagger.Provides;
import test.tokopedia.newsapp.NewsApp;
import test.tokopedia.newsapp.Repository.MainRepository;
import test.tokopedia.newsapp.data.DaoMaster;
import test.tokopedia.newsapp.data.DaoSession;
import test.tokopedia.newsapp.di.scope.ActivityScope;
import test.tokopedia.newsapp.helper.Constant;
import test.tokopedia.newsapp.model.SourceModel;
import test.tokopedia.newsapp.network.NetworkService;

/**
 * Created by Kharisma AW on 8/14/2018.
 */
@Module
public class MainActivityModule {
    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainRepository provideMainRepository(NetworkService networkService) {
        return new MainRepository(networkService);
    }

    @Provides
    @ActivityScope
    DaoSession provideDaoSession() {
        String DbName = Constant.DATABASE_NAME;
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(NewsApp.get(), DbName);
        Log.d("New DB Name: ", DbName);
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        Log.d("DB PATH", db.getPath());
        DaoMaster daoMaster = new DaoMaster(db);
        return daoMaster.newSession();
    }


    @Provides
    @ActivityScope
    SourceModel provideSourceModel(DaoSession daoSession){
        return new SourceModel(daoSession);
    }

    @Provides
    @ActivityScope
    MainActivityPresenter provideMainActivityPresenter(MainRepository mainRepository, SourceModel sourceModel) {
        return new MainActivityPresenter(mainRepository, sourceModel);
    }
}
