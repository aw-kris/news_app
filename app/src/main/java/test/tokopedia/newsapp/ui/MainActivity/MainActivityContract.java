package test.tokopedia.newsapp.ui.MainActivity;

import java.util.List;

import test.tokopedia.newsapp.data.Source;
import test.tokopedia.newsapp.data.SourceData;

/**
 * Created by Kharisma AW on 8/14/2018.
 */
public class MainActivityContract {
    public interface View{
        void setAdapter(List<SourceData> sourceDataList);
        void initializeData();
        void showProgressBar();
        void hideProgressBar();
    }

    public interface Presenter {
        void getSourcesData();
        void saveSourcesData(Source source);
        void getArticleList(View mView);
    }
}
