package pku.miao.zhihudaily.bean;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vector on 16/4/19.
 * {
 "body": "<div class=\"main-wrap content-wrap\">\n<div class=\"headline\">\n\n\n<h1 class=\"headline-title onlyheading\">为什么很多老人都不喜欢使用家用电器？<\/h1>\n\n\n\n\n<\/div>\n\n<div class=\"content-inner\">\n\n\n\n\n<div class=\"question\">\n<h2 class=\"question-title\"><\/h2>\n\n<div class=\"answer\">\n\n<div class=\"meta\">\n<img class=\"avatar\" src=\"http:\/\/pic2.zhimg.com\/156e1cd889654634157d006d24623831_is.jpg\">\n<span class=\"author\">张昕，<\/span><span class=\"bio\">发展心理学<\/span>\n<\/div>\n\n<div class=\"content\">\n老年人对新技术的抗拒是从来都有的，比方说相机，刚开始有照相技术的时候，大多是年轻人去吧，老年人还会说拍照会把人的魂给勾走，对吧？主要还是老年人对于新技术的不了解，以及他们也没有更多意愿去了解新技术导致的。不得不说，在这一点上，国内很多生产商对于产品的宣传已经自动将老年人排除在外了（可以关注一下电器广告中，有多少是针对儿童、年轻人、中年人，而又有多少是针对老年人的）。<br><br>这一点国外就做得比较成熟了，主要还是因为国外老年人有钱（大家都想着挣他们的钱啊！），中国老年人就目前状况来看，没钱，自然就没有针对性的宣传了。。。<br><br>不过，老年人对家用电器\/新技术的抗拒其实也是可以改变的，这方面心理学家也是有所贡献的。比方说电脑，最开始都是一些年轻人在用，老年人也是不愿意用的，但现在越来越多的老年人在学习使用电脑，为什么？通过<strong>有效的劝说<\/strong>。举一篇论文为例，是2003年发表的一项研究[1]，讨论的是如何提高老年人对数码相机(以及其他产品)广告的记忆以及对产品的评价。<br><br><img src=\"http:\/\/pic4.zhimg.com\/ade178ebf0f78d5db36c6e617ede8303_b.jpg\" data-width=\"644\" data-height=\"935\"><br>同样的广告图片，只是标题不同（如数码相机是：capture the unexplored world vs. capture the specific moment； 烟雾报警器是：Protect your bright future vs. Protect those you cherish）。结果都发现相比于第一个广告语，老年人对第二个广告语记忆得更好，也有更高的评价，表现出更多的喜欢。根据老年学中的社会情绪选择理论来说，老年人更加看重的与情感相关的目标（例如人际关系），而年轻人则更看重未来相关的目标（如探索未知世界，学习知识等）。因此在劝说老年人的时候，你仅仅罗列事实是没有用的，需要的是更多告诉老年人产品的好处，尤其是与其情感目标相关的好处。<br><br>我自己也做过相关的研究，劝说老年人多进行健康饮食[2]，结果也同样发现，你仅仅告诉老年人多吃谷物，蔬菜，水果可以帮助他们控制血糖，保持健康是没有特别大的效果的，更有效的办法是告诉他们多吃谷物，蔬菜，水果可以帮助他们保持健康，<strong>从而能够有更多美好的时光陪着自己爱的人<\/strong>。相同的道理，用加湿器、除湿器、空气清新机可以看作是保持健康，有更多时间与爱的人享受生活；洗衣机、吸尘器可以说成节约时间、少费力气，而节省的时间可以多陪陪家人，或者出去见见朋友等等（当然，如果家人都不陪她就另当别论了...）。 <br><br>Reference<br><br><p>[1] Fung, H. H., &amp; Carstensen, L. L.\n(2003). Sending memorable messages to the old: age differences in preferences\nand memory for advertisements. <i>Journal of Personality and Social Psychology<\/i>,\n<i>85<\/i>, 163 - 178.<\/p><p><\/p><p>[2] <strong>Zhang, X.<\/strong>,\nFung, H. H., &amp; Ching, B. H. (2009). Age differences in goals: Implications\nfor health promotion. <i>Aging and Mental\nHealth, 13, <\/i>336 – 348.<\/p>\n<\/div>\n<\/div>\n\n\n<div class=\"view-more\"><a href=\"http:\/\/www.zhihu.com\/question\/22679132\">查看知乎讨论<span class=\"js-question-holder\"><\/span><\/a><\/div>\n\n<\/div>\n\n\n<\/div>\n<\/div>",
 "title": "为什么很多老人都不喜欢使用家用电器？",
 "recommenders": [
 {
 "avatar": "http:\/\/pic1.zhimg.com\/fa546aed8_m.jpg"
 }
 ],
 "share_url": "http:\/\/daily.zhihu.com\/story\/4738657",
 "js": [

 ],
 "theme": {
 "thumbnail": "http:\/\/pic3.zhimg.com\/0e71e90fd6be47630399d63c58beebfc.jpg",
 "id": 13,
 "name": "日常心理学"
 },
 "ga_prefix": "052510",
 "type": 0,
 "id": 4738657,
 "css": [
 "http:\/\/news-at.zhihu.com\/css\/news_qa.auto.css?v=4b3e3"
 ]
 }
 */
public class ThemeStoryDetail {
    @SerializedName("body") @Expose
    String body;

    @SerializedName("title") @Expose
    String title;

    @SerializedName("share_url") @Expose
    String share_url;

    @SerializedName("js") @Expose
    List js;

    @SerializedName("recommenders") @Expose
    List<User> recommenders;

    @SerializedName("ga_prefix") @Expose
    String ga_prefix;

    @SerializedName("type") @Expose
    int type;

    @SerializedName("id") @Expose

    int newsDetailID;

    @SerializedName("css") @Expose
    List<String> css;


    @SerializedName("theme")@Expose
    Subject theme;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Subject getTheme() {
        return theme;
    }

    public void setTheme(Subject theme) {
        this.theme = theme;
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
