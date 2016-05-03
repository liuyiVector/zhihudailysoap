package pku.miao.zhihudaily.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import pku.miao.zhihudaily.R;
import pku.miao.zhihudaily.bean.Comments1;
import pku.miao.zhihudaily.contract.CommentsContract;
import pku.miao.zhihudaily.presenter.CommentPresenter;
import pku.miao.zhihudaily.ui.adapter.CommentsAdapter;
import pku.miao.zhihudaily.ui.view.DividerItemDecoration;

public class CommentsActivity extends AppCompatActivity implements CommentsContract.View{

    RecyclerView comments_rcv;
    CommentPresenter commentPresenter;
    int newsID;
    int long_comments;
    int short_comments;
    CommentsAdapter commentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        Intent intent = getIntent();
        newsID = intent.getIntExtra("newsID", 0);
        long_comments = intent.getIntExtra("long_comments", 0);
        short_comments = intent.getIntExtra("short_comments", 0);
        initView();

        new CommentPresenter(this, newsID);
    }

    @Override
    public void onResume(){
        super.onResume();
        commentPresenter.start();
    }


    void initView(){
        initToolbar();

        comments_rcv = (RecyclerView) findViewById(R.id.comments_rcv);
        comments_rcv.setLayoutManager(new LinearLayoutManager(this));
        comments_rcv.setHasFixedSize(true);
        int spacingInPixels = 5;
        comments_rcv.addItemDecoration(new DividerItemDecoration(spacingInPixels));

        commentsAdapter = new CommentsAdapter(this, null);
        comments_rcv.setAdapter(commentsAdapter);

    }

    void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("xx条点评");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAbTxt));
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showComments(Comments1 comments) {
        commentsAdapter.refresh(comments);
    }

    @Override
    public void setPresenter(CommentsContract.Presenter presenter) {
        this.commentPresenter = (CommentPresenter) presenter;
    }
}
