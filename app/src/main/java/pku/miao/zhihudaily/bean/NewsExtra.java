package pku.miao.zhihudaily.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vector on 16/4/27.
 */
public class NewsExtra {
    @SerializedName("long_comments") @Expose
    public int long_comments;
    @SerializedName("popularity") @Expose
    public int popularity;
    @SerializedName("short_comments") @Expose
    public int short_comments;
    @SerializedName("comments") @Expose
    public int comments;
}
