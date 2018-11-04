package test.tokopedia.newsapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "sources")
public class SourceEntity {
    @SerializedName("id")
    @NonNull
    @Expose
    @PrimaryKey
    @ColumnInfo(name = "source_id")
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Nullable
    @Expose
    @ColumnInfo(name = "source_desc")
    private String description;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("category")
    @Nullable
    @Expose
    private String category;
    @SerializedName("language")
    @Nullable
    @Expose
    private String language;
    @SerializedName("country")
    @Nullable
    @Expose
    private String country;

    public SourceEntity() {
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Nullable
    public String getCategory() {
        return category;
    }

    public void setCategory(@Nullable String category) {
        this.category = category;
    }

    @Nullable
    public String getLanguage() {
        return language;
    }

    public void setLanguage(@Nullable String language) {
        this.language = language;
    }

    @Nullable
    public String getCountry() {
        return country;
    }

    public void setCountry(@Nullable String country) {
        this.country = country;
    }
}
