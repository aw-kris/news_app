package test.tokopedia.newsapp.Repository;

import test.tokopedia.newsapp.network.NetworkService;

/**
 * Created by Kharisma AW on 8/13/2018.
 */
public class BaseRepository {
    protected NetworkService networkService;

    public BaseRepository(NetworkService networkService) {
        this.networkService = networkService;
    }
}
