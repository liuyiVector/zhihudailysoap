package pku.miao.zhihudaily;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by vector on 16/4/17.
 */
public class ZhihuApplication extends Application{
    public ZhihuApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
