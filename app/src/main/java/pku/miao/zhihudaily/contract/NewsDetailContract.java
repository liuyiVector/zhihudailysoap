package pku.miao.zhihudaily.contract;

import pku.miao.zhihudaily.base.BasePresenter;
import pku.miao.zhihudaily.base.BaseView;
import pku.miao.zhihudaily.bean.LatestNews;
import pku.miao.zhihudaily.bean.NewsDetail;
import pku.miao.zhihudaily.bean.NewsExtra;
import rx.Observer;

/**
 * Created by vector on 16/4/13.
 */
public interface NewsDetailContract {
    interface View extends BaseView<Presenter> {

        void showNews(NewsDetail newsDetail);

        void showNewsExtra(NewsExtra newsExtra);

    }

    interface Presenter extends BasePresenter{
        public void fetchDataByNetWork(Observer<NewsDetail> observer, Observer<NewsExtra> observer1, int newsID);
    }
}
