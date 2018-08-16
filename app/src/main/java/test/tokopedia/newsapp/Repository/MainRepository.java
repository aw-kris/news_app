package test.tokopedia.newsapp.Repository;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import test.tokopedia.newsapp.data.Article;
import test.tokopedia.newsapp.data.Source;
import test.tokopedia.newsapp.network.NetworkService;

/**
 * Created by Kharisma AW on 8/13/2018.
 */
public class MainRepository extends BaseRepository{
    public MainRepository(NetworkService networkService) {
        super(networkService);
    }

    /**
     * Get Sources
     * */
    public Flowable<Source> getSources(String url) {
        return networkService.getSources(url)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Get Articles
     * */
    public Flowable<Article> getArticles(String url) {
        return networkService.getArticles(url)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Search Articles
     * */
    public Flowable<Article> searchArticles(String url) {
        return networkService.searchArticles(url)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
