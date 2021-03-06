package pku.miao.zhihudaily.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pku.miao.zhihudaily.ui.activity.DetailActivity;
import pku.miao.zhihudaily.R;
import pku.miao.zhihudaily.ui.adapter.RecommendAdapter;
import pku.miao.zhihudaily.bean.LatestNews;
import pku.miao.zhihudaily.ui.view.DividerItemDecoration;
import pku.miao.zhihudaily.contract.RecommendContract;

/**
 * Created by vector on 16/4/13.
 */
public class RecommendFragment extends Fragment implements RecommendContract.View, SwipeRefreshLayout.OnRefreshListener, RecommendAdapter.OnStoryItemClick{

    private RecommendContract.Presenter mPresenter;
    public static final String ARGUMENT_TASK_ID = "TASK_ID";

    RecyclerView hot_rcv;
    SwipeRefreshLayout swp;

    Context context;

    private RecommendAdapter recommendAdapter;



    public static RecommendFragment newInstance(String taskId){
        Bundle arguments = new Bundle();
        arguments.putString(ARGUMENT_TASK_ID, taskId);
        RecommendFragment fragment = new RecommendFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recommend, container, false);
        context = getActivity();

        setHasOptionsMenu(true);
        initView(root);

        return root;
    }


    void initView(View root){
        // Set up floating action button
        FloatingActionButton fab =
                (FloatingActionButton) getActivity().findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        hot_rcv = (RecyclerView) root.findViewById(R.id.id_hot_rcv);

        hot_rcv.setLayoutManager(new LinearLayoutManager(getActivity()));
        hot_rcv.setHasFixedSize(true);
        int spacingInPixels = 8;
        hot_rcv.addItemDecoration(new DividerItemDecoration(spacingInPixels));

        recommendAdapter = new RecommendAdapter(context, null);
        recommendAdapter.setOnStoryItemClick(this);
        hot_rcv.setAdapter(recommendAdapter);

        swp = (SwipeRefreshLayout) root.findViewById(R.id.id_swp);

        swp.setOnRefreshListener(this);


    }


    @Override
    public void onResume(){
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(RecommendContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onRefresh() {
        mPresenter.start();
    }

    @Override
    public void showStory(LatestNews latestNews) {
        Log.v("miao", "story date: " + latestNews.getDate() );
        swp.setRefreshing(false);
        recommendAdapter.refresh(latestNews);
    }

    @Override
    public void onStoryItemClick(int position, int id) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("newsID", recommendAdapter.latestNews.getStories().get(position-1).getId());
        startActivity(intent);
    }
}
