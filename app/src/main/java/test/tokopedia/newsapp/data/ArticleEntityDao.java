package test.tokopedia.newsapp.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ArticleEntityDao {
    @Query("SELECT * FROM articles")
    List<ArticleEntity> getAll();

    @Insert
    void insertAll(ArticleEntity... articleEntities);

    @Delete
    void delete(ArticleEntity articleEntity);
}
