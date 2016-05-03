package pku.miao.zhihudaily.presenter;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pku.miao.zhihudaily.bean.Comment;
import pku.miao.zhihudaily.bean.Comments;
import pku.miao.zhihudaily.bean.Comments1;
import pku.miao.zhihudaily.component.RetrofitSingleton;
import pku.miao.zhihudaily.contract.CommentsContract;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by vector on 16/4/13.
 */
public class CommentPresenter implements CommentsContract.Presenter{

    private final CommentsContract.View mCommentView;
    private Observer<Comments1> observer;
    int newsID;


    public CommentPresenter(CommentsContract.View mCommentView1, int newsID) {
        this.mCommentView = mCommentView1;
        mCommentView.setPresenter(this);
        this.newsID = newsID;
        observer = new Observer<Comments1>() {
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
            public void onNext(Comments1 comments) {
                Log.v("miao", "onNext");
                Log.v("miao", comments.long_comments.size()+"-----"+ comments.short_comments.size());
                mCommentView.showComments(comments);
            }
        };
    }

    @Override
    public void start() {
        fetchDataByNetWork(newsID);
    }


    @Override
    public void fetchDataByNetWork(final int newsID) {
        Observable<Comments> short_comments_service = RetrofitSingleton.getApiService((Activity) mCommentView).shortComment(newsID);
        Observable<Comments> long_comments_service = RetrofitSingleton.getApiService((Activity) mCommentView).longComment(newsID);
        Observable.zip(short_comments_service, long_comments_service, new Func2<Comments, Comments, Comments1>(){

            @Override
            public Comments1 call(Comments comments, Comments comments2) {
                Comments1 comments1 = new Comments1();
                comments1.long_comments = comments.comments;
                comments1.short_comments = comments2.comments;
                return comments1;
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer);
    }
}
