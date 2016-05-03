package pku.miao.zhihudaily.contract;

import java.util.List;

import pku.miao.zhihudaily.base.BasePresenter;
import pku.miao.zhihudaily.base.BaseView;
import pku.miao.zhihudaily.bean.Comment;
import pku.miao.zhihudaily.bean.Comments1;
import pku.miao.zhihudaily.bean.NewsDetail;
import pku.miao.zhihudaily.bean.NewsExtra;
import rx.Observer;

/**
 * Created by vector on 16/4/28.
 */
public interface CommentsContract {
    interface View extends BaseView<Presenter> {
        void showComments(Comments1 comments);
    }

    interface Presenter extends BasePresenter {
        public void fetchDataByNetWork(int newsID);
    }
}
