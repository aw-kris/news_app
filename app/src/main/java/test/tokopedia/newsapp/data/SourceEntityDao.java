package test.tokopedia.newsapp.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface SourceEntityDao {
    @Query("SELECT * FROM sources")
    List<SourceEntity> getAll();

    @Insert
    void insertAll(SourceEntity... sourceEntities);

    @Delete
    void delete(SourceEntity sourceEntity);
}
