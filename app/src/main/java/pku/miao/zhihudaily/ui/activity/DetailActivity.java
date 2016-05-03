package pku.miao.zhihudaily.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import pku.miao.zhihudaily.R;
import pku.miao.zhihudaily.bean.NewsDetail;
import pku.miao.zhihudaily.bean.NewsExtra;
import pku.miao.zhihudaily.contract.NewsDetailContract;
import pku.miao.zhihudaily.presenter.NewsDetailPresenter;
import pku.miao.zhihudaily.presenter.RecommendPresenter;

public class DetailActivity extends AppCompatActivity implements NewsDetailContract.View{


    WebView content_wv;
    CollapsingToolbarLayout toolbar_layout;
    NewsDetailContract.Presenter presenter;
    SimpleDraweeView tpoic_imv;
    TextView title_tv, image_source_tv;
    ImageView praise_imv, comment_imv, ab_back_img;
    TextView praise_num_tv, comment_num_tv;
    int newsID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        newsID = getIntent().getIntExtra("newsID", 0);
        initView();

        new NewsDetailPresenter(this, newsID);

    }

    @Override
    public void onResume(){
        super.onResume();
        presenter.start();
    }


    void initView(){
        initToolbar();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        content_wv = (WebView) findViewById(R.id.content_wv);
        content_wv.getSettings().setDefaultTextEncodingName("UTF -8");//设置默认为utf-8
        content_wv.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;
            }
        });
    }

    void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_layout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

        praise_imv = (ImageView) toolbar.findViewById(R.id.praise_imv);
        comment_imv = (ImageView) toolbar.findViewById(R.id.comment_imv);
        ab_back_img = (ImageView) toolbar.findViewById(R.id.ab_back_img);
        praise_num_tv = (TextView) toolbar.findViewById(R.id.praise_num_tv);
        comment_num_tv = (TextView) toolbar.findViewById(R.id.comment_num_tv);

        tpoic_imv = (SimpleDraweeView) toolbar_layout.findViewById(R.id.tpoic_imv);
        title_tv = (TextView) toolbar_layout.findViewById(R.id.title_tv);
        image_source_tv = (TextView) toolbar_layout.findViewById(R.id.image_source_tv);

        ab_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //getSupportActionBar().setTitle("xx");

        toolbar_layout.setTitleEnabled(false);
    }

    @Override
    public void showNews(NewsDetail newsDetail) {
        tpoic_imv.setImageURI(Uri.parse(newsDetail.getImage()));
        //增加一个蒙版的效果
        tpoic_imv.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        title_tv.setText(newsDetail.getTitle());
        image_source_tv.setText(newsDetail.getImage_source());
        Log.v("miao", newsDetail.getHTML());
        content_wv.loadData(newsDetail.getHTML(),"text/html; charset=UTF-8", null);
    }

    @Override
    public void showNewsExtra(final NewsExtra newsExtra) {
        praise_num_tv.setText(newsExtra.popularity+"");
        comment_num_tv.setText(newsExtra.comments+"");
        comment_imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, CommentsActivity.class);
                intent.putExtra("newsID", newsID);
                intent.putExtra("long_comments", newsExtra.long_comments);
                intent.putExtra("short_comments", newsExtra.short_comments);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setPresenter(NewsDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

}
