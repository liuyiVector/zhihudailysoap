package pku.miao.zhihudaily.presenter;

import android.support.v4.app.Fragment;
import android.util.Log;

import pku.miao.zhihudaily.bean.LatestNews;
import pku.miao.zhihudaily.bean.Theme;
import pku.miao.zhihudaily.component.RetrofitSingleton;
import pku.miao.zhihudaily.contract.RecommendContract;
import pku.miao.zhihudaily.contract.ThemeContract;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by vector on 16/4/13.
 */
public class ThemePresenter implements ThemeContract.Presenter{

    private final ThemeContract.View mThemeView;
    private Observer<Theme> observer;
    private int theme_id;


    public ThemePresenter(ThemeContract.View mThemeView1, int theme_id) {
        this.mThemeView = mThemeView1;
        this.theme_id = theme_id;
        mThemeView.setPresenter(this);
        observer = new Observer<Theme>() {
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
            public void onNext(Theme theme) {
                Log.v("miao", "onNext");
                mThemeView.showStory(theme);
            }
        };
    }

    @Override
    public void start() {
        fetchDataByNetWork(observer);
    }


    @Override
    public void fetchDataByNetWork(Observer<Theme> observer) {
        RetrofitSingleton.getApiService(((Fragment) mThemeView).getActivity())
                .themeContent(theme_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
