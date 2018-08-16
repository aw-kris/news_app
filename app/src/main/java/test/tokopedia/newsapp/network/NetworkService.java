package test.tokopedia.newsapp.network;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Url;
import test.tokopedia.newsapp.data.Article;
import test.tokopedia.newsapp.data.Source;

/**
 * Created by Kharisma AW on 8/13/2018.
 */
public interface NetworkService {

    /**
     * Get sources
     * */
    @GET
    Flowable<Source> getSources(@Url String url);

    /**
     * Get article
     * */
    @GET
    Flowable<Article> getArticles(@Url String url);

    /**
     * Search article
     * */
    @GET
    Flowable<Article> searchArticles(@Url String url);


}
