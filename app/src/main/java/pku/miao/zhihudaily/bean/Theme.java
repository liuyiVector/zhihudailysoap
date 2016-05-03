package pku.miao.zhihudaily.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vector on 16/5/3.
 */
public class Theme {
    @SerializedName("stories")@Expose
    public List<Story> stories;
    @SerializedName("description")@Expose
    public String description;
    @SerializedName("background")@Expose
    public String background;
    @SerializedName("color")@Expose
    public int color;
    @SerializedName("name")@Expose
    public String name;
    @SerializedName("image")@Expose
    public String image;
    @SerializedName("image_source")@Expose
    public String image_source;
    @SerializedName("editors")@Expose
    public List<Editor> editors;
}
