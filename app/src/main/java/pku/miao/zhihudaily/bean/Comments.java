package pku.miao.zhihudaily.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vector on 16/4/28.
 */
public class Comments {
    @SerializedName("comments")@Expose
    public List<Comment> comments;
}
