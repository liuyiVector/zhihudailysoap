package pku.miao.zhihudaily.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vector on 16/4/28.
 */
public class Comments1 {
    //long comments
    public List<Comment> long_comments;
    public List<Comment> short_comments;

    public List<Comment> all_comments;

    public void aggregrate(){
        all_comments = new ArrayList<Comment>();
        all_comments.addAll(short_comments);
        all_comments.addAll(long_comments);
    }
}
