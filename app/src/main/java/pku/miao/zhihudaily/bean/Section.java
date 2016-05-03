package pku.miao.zhihudaily.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vector on 16/4/19.
 */
public class Section {
    @SerializedName("thumbnail") @Expose
    String thumbnail;

    @SerializedName("id") @Expose

    int sectionID;

    @SerializedName("name") @Expose

    String name;

    public Section(String thumbnail, int id, String name) {
        this.thumbnail = thumbnail;
        this.sectionID = id;
        this.name = name;
    }
}
