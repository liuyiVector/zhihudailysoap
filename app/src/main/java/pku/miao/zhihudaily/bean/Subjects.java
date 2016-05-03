package pku.miao.zhihudaily.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vector on 16/5/3.
 */
public class Subjects {
    @SerializedName("limit")@Expose
    public int limit;
//    @SerializedName("subscribed")@Expose
//    List subscribed;
    @SerializedName("others")@Expose
    List<Subject> others;

}
