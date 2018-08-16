package test.tokopedia.newsapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by Kharisma AW on 8/14/2018.
 */
public class Source {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sources")
    @Expose
    private List<SourceData> sources = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SourceData> getSources() {
        return sources;
    }

    public void setSources(List<SourceData> sources) {
        this.sources = sources;
    }
}
