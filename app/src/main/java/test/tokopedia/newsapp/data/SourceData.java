package test.tokopedia.newsapp.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Kharisma AW on 8/14/2018.
 */
@Entity
public class SourceData implements Parcelable{
    @SerializedName("id")
    @Nullable
    @Expose
    private String id;
    @SerializedName("name")
    @Nullable
    @Expose
    private String name;
    @SerializedName("description")
    @Nullable
    @Expose
    private String description;
    @SerializedName("url")
    @Nullable
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

    protected SourceData(Parcel in) {
        id = in.readString();
        name = in.readString();
        description = in.readString();
        url = in.readString();
        category = in.readString();
        language = in.readString();
        country = in.readString();
    }

    @Generated(hash = 1015438095)
    public SourceData(String id, String name, String description, String url,
            String category, String language, String country) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.category = category;
        this.language = language;
        this.country = country;
    }

    @Generated(hash = 1096280314)
    public SourceData() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeString(category);
        dest.writeString(language);
        dest.writeString(country);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SourceData> CREATOR = new Creator<SourceData>() {
        @Override
        public SourceData createFromParcel(Parcel in) {
            return new SourceData(in);
        }

        @Override
        public SourceData[] newArray(int size) {
            return new SourceData[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
