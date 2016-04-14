package pku.miao.zhihudaily.contract;

import pku.miao.zhihudaily.base.BasePresenter;
import pku.miao.zhihudaily.base.BaseView;
import pku.miao.zhihudaily.bean.LatestNews;
import rx.Observer;

/**
 * Created by vector on 16/4/13.
 */
public interface RecommendContract {
    interface View extends BaseView<Presenter> {

        void showStory(LatestNews latestNews);

    }

    interface Presenter extends BasePresenter{
        public void fetchDataByNetWork(Observer<LatestNews> observer);
    }
}
