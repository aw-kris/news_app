package test.tokopedia.newsapp;

import android.app.Application;
import android.arch.persistence.room.Room;

import test.tokopedia.newsapp.data.AppDatabase;
import test.tokopedia.newsapp.di.component.AppComponent;
import test.tokopedia.newsapp.di.component.DaggerAppComponent;
import test.tokopedia.newsapp.di.module.AppModule;
import test.tokopedia.newsapp.di.module.NetworkModule;

/**
 * Created by Kharisma AW on 8/14/2018.
 */
public class NewsApp extends Application{
    private AppComponent appComponent = createAppComponent();

    private static NewsApp instance;

    public static NewsApp get() {
        return instance;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
//        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class, "news-db").build();
    }

    protected AppComponent createAppComponent() {
        return appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return  appComponent;
    }
}
