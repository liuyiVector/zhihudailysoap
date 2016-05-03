package pku.miao.zhihudaily.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vector on 16/5/3.
 * "color":62140,"thumbnail":"http:\/\/p1.zhimg.com\/d3\/7b\/d37b38d5c82b4345ccd7e50c4ae997da.jpg","description":"好设计需要打磨和研习，我们分享灵感和路径","id":4,"name":"设计日报"
 */
public class Subject {
    @SerializedName("color")@Expose
    public int color;
    @SerializedName("thumbnail")@Expose
    public String thumbnail;
    @SerializedName("description")@Expose
    public String description;
    @SerializedName("id")@Expose
    public int id;
    @SerializedName("name")@Expose
    public String name;
}
