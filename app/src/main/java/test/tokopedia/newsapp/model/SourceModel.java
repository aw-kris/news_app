package test.tokopedia.newsapp.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import test.tokopedia.newsapp.data.DaoSession;
import test.tokopedia.newsapp.data.SourceData;
import test.tokopedia.newsapp.data.SourceDataDao;

/**
 * Created by Kharisma AW on 8/14/2018.
 */
public class SourceModel extends BaseModel{
    private SourceDataDao mSourceDataDao;

    public SourceModel(DaoSession daoSession) {
        super(daoSession);
        mSourceDataDao = daoSession.getSourceDataDao();
    }

    @NonNull
    public void insertSource(SourceData sourceData){
        mSourceDataDao.insertOrReplace(sourceData);
    }

    @Nullable
    public List<SourceData> getAllSources(){
        return mSourceDataDao.loadAll();
    }
}
