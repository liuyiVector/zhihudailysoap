package pku.miao.zhihudaily.presenter;

import android.support.v4.app.Fragment;
import android.util.Log;

import pku.miao.zhihudaily.bean.LatestNews;
import pku.miao.zhihudaily.component.component.RetrofitSingleton;
import pku.miao.zhihudaily.contract.RecommendContract;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by vector on 16/4/13.
 */
public class RecommendPresenter implements RecommendContract.Presenter{

    private final RecommendContract.View mRecommendView;
    private Observer<LatestNews> observer;


    public RecommendPresenter(RecommendContract.View mRecommendView1) {
        this.mRecommendView = mRecommendView1;
        mRecommendView.setPresenter(this);
        observer = new Observer<LatestNews>() {
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
            public void onNext(LatestNews latestNews) {
                Log.v("miao", "onNext");
                mRecommendView.showStory(latestNews);
            }
        };
    }

    @Override
    public void start() {
        fetchDataByNetWork(observer);
    }


    @Override
    public void fetchDataByNetWork(Observer<LatestNews> observer){
        RetrofitSingleton.getApiService(((Fragment) mRecommendView).getActivity())
                .latestNew()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
