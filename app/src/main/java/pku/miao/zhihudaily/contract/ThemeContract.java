package pku.miao.zhihudaily.contract;

import pku.miao.zhihudaily.base.BasePresenter;
import pku.miao.zhihudaily.base.BaseView;
import pku.miao.zhihudaily.bean.LatestNews;
import pku.miao.zhihudaily.bean.Theme;
import rx.Observer;

/**
 * Created by vector on 16/4/13.
 */
public interface ThemeContract {
    interface View extends BaseView<Presenter> {

        void showStory(Theme theme);

    }

    interface Presenter extends BasePresenter{
        public void fetchDataByNetWork(Observer<Theme> observer);
    }
}
