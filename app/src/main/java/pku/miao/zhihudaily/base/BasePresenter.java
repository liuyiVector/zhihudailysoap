package pku.miao.zhihudaily.base;

/**
 * Created by vector on 16/4/13.
 * BasePresenter中含有方法start(),
 * 该方法的作用是presenter开始获取数据并调用view中方法改变界面显示，
 * 其调用时机是在Fragment类的onResume方法中
 */
public interface BasePresenter {

    void start();

}
