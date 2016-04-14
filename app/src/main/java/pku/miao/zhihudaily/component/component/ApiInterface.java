package pku.miao.zhihudaily.component.component;


import pku.miao.zhihudaily.bean.LatestNews;
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


    //而且在Retrofit 2.0中我们还可以在@Url里面定义完整的URL：这种情况下Base URL会被忽略。
    @GET("http://api.fir.im/apps/latest/5630e5f1f2fc425c52000006") Observable mVersionAPI(
            @Query("api_token") String api_token);
}
