package pku.miao.zhihudaily.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by vector on 16/4/13.
 */
public class BaseStory implements Serializable {
    @SerializedName("type")@Expose
    public Integer type;
    @SerializedName("id")@Expose
    public Integer id;
    @SerializedName("title")@Expose
    public String title;
    @SerializedName("ga_prefix")@Expose
    public String ga_prefix;

    public Integer getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }
}
