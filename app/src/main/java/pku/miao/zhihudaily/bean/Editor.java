package pku.miao.zhihudaily.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vector on 16/5/3.
 */
public class Editor {
    @SerializedName("url")@Expose
    public String url;
    @SerializedName("bio")@Expose
    public String bio;
    @SerializedName("id")@Expose
    int id;
    @SerializedName("avatar")@Expose
    String avatar;
    @SerializedName("name")@Expose
    String name;

}
