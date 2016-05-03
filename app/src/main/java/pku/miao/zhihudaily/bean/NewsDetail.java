package pku.miao.zhihudaily.bean;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vector on 16/4/19.
 * {
     body: "<div class="main-wrap content-wrap">...</div>",
     image_source: "Yestone.com 版权图片库",
     title: "深夜惊奇 · 朋友圈错觉",
     image: "http://pic3.zhimg.com/2d41a1d1ebf37fb699795e78db76b5c2.jpg",
     share_url: "http://daily.zhihu.com/story/4772126",
     js: [ ],
     recommenders": [
     { "avatar": "http://pic2.zhimg.com/fcb7039c1_m.jpg" },
     { "avatar": "http://pic1.zhimg.com/29191527c_m.jpg" },
     { "avatar": "http://pic4.zhimg.com/e6637a38d22475432c76e6c9e46336fb_m.jpg" },
     { "avatar": "http://pic1.zhimg.com/bd751e76463e94aa10c7ed2529738314_m.jpg" },
     { "avatar": "http://pic1.zhimg.com/4766e0648_m.jpg" }
     ],
     ga_prefix: "050615",
     section": {
     "thumbnail": "http://pic4.zhimg.com/6a1ddebda9e8899811c4c169b92c35b3.jpg",
     "id": 1,
     "name": "深夜惊奇"
     },
     type: 0,
     id: 4772126,
     css: [
     "http://news.at.zhihu.com/css/news_qa.auto.css?v=1edab"
 ]
 }
 */
public class NewsDetail {
    @SerializedName("body") @Expose
    String body;

    @SerializedName("image_source") @Expose
    String image_source;

    @SerializedName("title") @Expose
    String title;

    @SerializedName("image") @Expose
    String image;

    @SerializedName("share_url") @Expose
    String share_url;

    @SerializedName("js") @Expose
    List js;

    @SerializedName("recommenders") @Expose
    List<User> recommenders;

    @SerializedName("ga_prefix") @Expose
    String ga_prefix;

    @SerializedName("section") @Expose

    Section section;

    @SerializedName("type") @Expose
    int type;

    @SerializedName("id") @Expose

    int newsDetailID;

    @SerializedName("css") @Expose
    List<String> css;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public List getJs() {
        return js;
    }

    public void setJs(List js) {
        this.js = js;
    }

    public List<User> getRecommenders() {
        return recommenders;
    }

    public void setRecommenders(List<User> recommenders) {
        this.recommenders = recommenders;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNewsDetailID() {
        return newsDetailID;
    }

    public void setNewsDetailID(int newsDetailID) {
        this.newsDetailID = newsDetailID;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }


    public String getHTML(){
        String sb = "";
        sb = ("<!DOCTYPE html>\n" +
                "<html lang=\"zh-CN\">\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->\n" +
                "    <title>"+title+"</title>\n");
        for(int i = 0; i < css.size(); i++){
                sb += ("    <link href=\""+css.get(i)+"\" rel=\"stylesheet\">\n");
        }
        for(int i = 0; i < js.size(); i++) {
            sb += ("      <script src=\""+js.get(i)+"\"></script>\n");
        }
        sb +=   ("  </head>\n" +
                "  <body>\n" +
                body +
                "  </body>\n" +
                "</html>\n");
        sb = sb.replace("headline", "test");
        sb = sb.replace("img-place-holder","test");
        Log.v("miao", sb);
        return sb.toString();
    }
}
