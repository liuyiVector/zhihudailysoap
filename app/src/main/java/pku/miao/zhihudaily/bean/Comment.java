package pku.miao.zhihudaily.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vector on 16/4/28.
 */
public class Comment {
    @SerializedName("author")@Expose
    public String author;
    @SerializedName("id")@Expose
    public int id;
    @SerializedName("content")@Expose
    public String content;
    @SerializedName("likes")@Expose
    public int likes;
    @SerializedName("time")@Expose
    public long time;
    @SerializedName("avatar")@Expose
    public String avatar;
}
