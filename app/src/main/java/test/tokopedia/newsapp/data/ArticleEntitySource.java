package test.tokopedia.newsapp.data;

import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleEntitySource {
    @SerializedName("id")
    @NonNull
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;

    public ArticleEntitySource() {
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
