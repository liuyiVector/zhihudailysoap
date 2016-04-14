package pku.miao.zhihudaily.base;

/**
 * Created by vector on 16/4/13.
 * BaseView中含方法setPresenter，
 * 该方法作用是在将presenter实例传入view中，
 * 其调用时机是presenter实现类的构造函数中。
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

}
