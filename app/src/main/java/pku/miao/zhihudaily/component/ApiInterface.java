package pku.miao.zhihudaily.component;


import java.util.List;

import pku.miao.zhihudaily.bean.Comment;
import pku.miao.zhihudaily.bean.Comments;
import pku.miao.zhihudaily.bean.LatestNews;
import pku.miao.zhihudaily.bean.NewsDetail;
import pku.miao.zhihudaily.bean.NewsExtra;
import pku.miao.zhihudaily.bean.Subjects;
import pku.miao.zhihudaily.bean.Theme;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;


public interface ApiInterface {

    String HOST = "http://news-at.zhihu.com/api/4/";

    //获取最新的日报内容
    @GET("news/latest") Observable<LatestNews> latestNew();

    //获取指定某天的日报内容
    @GET("news/before/{date}") Observable<LatestNews> newsat(@Path("date") String date);

    //获取某新闻的详细信息
    @GET("news/{newsid}") Observable<NewsDetail> newsDetail(@Path("newsid") int newsid);

    //获取某新闻的额外信息，主要就是点赞和评论的数目
    @GET("story-extra/{newsid}") Observable<NewsExtra> newsExtra(@Path("newsid") int newsid);

    //获取长评论
    @GET("story/{newsid}/long-comments") Observable<Comments> longComment(@Path("newsid") int newsid);
    //获取短评论
    @GET("story/{newsid}/short-comments") Observable<Comments> shortComment(@Path("newsid") int newsid);

    //获取主题日报列表
    @GET("themes") Observable<Subjects> themes();

    //获取主题日报内容
    @GET("theme/{theme_id}") Observable<Theme> themeContent(@Path("theme_id") int theme_id);



    //而且在Retrofit 2.0中我们还可以在@Url里面定义完整的URL：这种情况下Base URL会被忽略。
    @GET("http://api.fir.im/apps/latest/5630e5f1f2fc425c52000006") Observable mVersionAPI(
            @Query("api_token") String api_token);
}
