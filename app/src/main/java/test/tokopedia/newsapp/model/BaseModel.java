package test.tokopedia.newsapp.model;

import test.tokopedia.newsapp.data.DaoSession;

/**
 * Created by Kharisma AW on 8/14/2018.
 */
public class BaseModel {
    protected final DaoSession mDaoSession;

    public BaseModel(DaoSession daoSession) {
        mDaoSession = daoSession;
    }
}
