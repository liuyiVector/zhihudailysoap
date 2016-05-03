package pku.miao.zhihudaily.presenter;

import android.app.Activity;
import android.util.Log;

import pku.miao.zhihudaily.bean.NewsDetail;
import pku.miao.zhihudaily.bean.NewsExtra;
import pku.miao.zhihudaily.component.RetrofitSingleton;
import pku.miao.zhihudaily.contract.NewsDetailContract;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by vector on 16/4/13.
 */
public class NewsDetailPresenter implements NewsDetailContract.Presenter{

    private final NewsDetailContract.View mNewsDetailView;
    private Observer<NewsDetail> observerDetail;
    private Observer<NewsExtra> observerExtra;

    int userID;


    public NewsDetailPresenter(final NewsDetailContract.View mNewsDetailView, int userID) {
        this.mNewsDetailView = mNewsDetailView;
        mNewsDetailView.setPresenter(this);
        this.userID = userID;
        observerDetail = new Observer<NewsDetail>() {
            @Override
            public void onCompleted() {
                Log.v("miao", "complete");
            }

            @Override
            public void onError(Throwable e) {

                Log.v("miao", "onError");
                Log.v("miao", e.getLocalizedMessage());
                Log.v("miao", e.toString());
            }

            @Override
            public void onNext(NewsDetail newsDetail) {
                Log.v("miao", "onNext");
                mNewsDetailView.showNews(newsDetail);
            }
        };
        observerExtra = new Observer<NewsExtra>() {
            @Override
            public void onCompleted() {
                Log.v("miao", "complete1");
            }

            @Override
            public void onError(Throwable e) {

                Log.v("miao", "onError1");
                Log.v("miao", e.getLocalizedMessage());
                Log.v("miao", e.toString());
            }

            @Override
            public void onNext(NewsExtra newsExtra) {
                Log.v("miao", "onNext1");
                mNewsDetailView.showNewsExtra(newsExtra);
            }
        };
    }

    @Override
    public void start() {
        Log.v("miao", "-----------");
        fetchDataByNetWork(observerDetail, observerExtra, userID);
    }



    @Override
    public void fetchDataByNetWork(Observer<NewsDetail> observer, Observer<NewsExtra> observer1, int newsID) {
        RetrofitSingleton.getApiService((Activity) mNewsDetailView).newsDetail(newsID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        RetrofitSingleton.getApiService((Activity) mNewsDetailView).newsExtra(newsID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer1);
    }
}
