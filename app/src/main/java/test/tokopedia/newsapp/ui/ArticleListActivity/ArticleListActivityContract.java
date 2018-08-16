package test.tokopedia.newsapp.ui.ArticleListActivity;

import java.util.List;

import test.tokopedia.newsapp.data.Article;
import test.tokopedia.newsapp.data.ArticleData;
import test.tokopedia.newsapp.data.Source;
import test.tokopedia.newsapp.data.SourceData;

/**
 * Created by Kharisma AW on 8/15/2018.
 */
public class ArticleListActivityContract {
    public interface View{
        void setAdapter(List<ArticleData> articleDataList);
        void initializeData();
        void requestPrevPage();
        void showProgressBar();
        void hideProgressBar();
        void setBtnContainerVisibility();
        void setPrevBtnVisibility();
        void setCurPage(int page);
    }

    public interface Presenter {
        void getArticleData(String source, int page);
        void searchArticleQuery(String source, String keyword);
    }
}
