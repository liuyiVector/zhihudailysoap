package pku.miao.zhihudaily.component.component;

import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by vector on 15/12/31.
 */
class LoggingInterceptor implements Interceptor {

    @Override public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Log.v("miao", request.urlString());

        long t1 = System.nanoTime();

        Response response = chain.proceed(request);

        //好蛋疼的错误，这里如果用了response后后面返回的是空的……，导致不能解析
//        String result = new String(response.body().bytes());
//        Log.v("miao", result);
        return response;
    }
}
