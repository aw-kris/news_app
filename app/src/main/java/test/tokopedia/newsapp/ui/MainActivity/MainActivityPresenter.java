package test.tokopedia.newsapp.ui.MainActivity;

import io.reactivex.subscribers.ResourceSubscriber;
import test.tokopedia.newsapp.Repository.MainRepository;
import test.tokopedia.newsapp.data.Source;
import test.tokopedia.newsapp.data.SourceData;
import test.tokopedia.newsapp.helper.Constant;
import test.tokopedia.newsapp.model.SourceModel;

/**
 * Created by Kharisma AW on 8/14/2018.
 */
public class MainActivityPresenter implements MainActivityContract.Presenter {
    private MainActivityContract.View mView;
    private MainRepository mMainRepository;
    private SourceModel mSourceModel;

    public MainActivityPresenter(MainRepository mMainRepository, SourceModel mSourceModel) {
        this.mMainRepository = mMainRepository;
        this.mSourceModel = mSourceModel;
    }

    public void setView(MainActivityContract.View view){
        mView = view;
    }

    @Override
    public void getSourcesData() {
        String url = Constant.SOURCES + Constant.API_KEY;
        mView.showProgressBar();
        mMainRepository.getSources(url)
                .subscribe(new ResourceSubscriber<Source>() {
                    @Override
                    public void onNext(Source source) {
                        mView.hideProgressBar();
                        mView.setAdapter(source.getSources());
                        saveSourcesData(source);
                    }

                    @Override
                    public void onError(Throwable t) {
                        mView.hideProgressBar();
                        mView.setAdapter(mSourceModel.getAllSources());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void saveSourcesData(Source source) {
        for(SourceData sourceData : source.getSources()){
            mSourceModel.insertSource(sourceData);
        }
    }

    @Override
    public void getArticleList(MainActivityContract.View mView) {

    }


}
